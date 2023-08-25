package horo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Command {
  BYE("^bye",
      "bye"),
  LIST("^list",
      "list"),
  MARK("^mark ([0-9]+)",
      "mark <number>"),
  UNMARK("^unmark ([0-9]+)",
      "unmark <number>"),
  DELETE("^delete ([0-9]+)",
      "delete <number>"),
  TODO("^todo ([\\w ]+)",
      "todo <description>"),
  DEADLINE("^deadline ([\\w ]+) \\/by (\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2})",
      "deadline <description> /by yyyy/mm/dd HH:mm"),
  EVENT("^event ([\\w ]+) \\/from (\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}) \\/to (\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2})",
      "event <description> /from yyyy/mm/dd HH:mm /to yyyy/mm/dd HH:mm");

  private final Pattern pattern;
  private final String format;

  private static final Pattern commandPattern = Pattern
      .compile("^(deadline|todo|event|bye|mark|unmark|list|delete)");

  Command(String regex, String format) {
    this.pattern = Pattern.compile(regex);
    this.format = format;
  }

  public static Command commandParser(String input) throws HoroException {
    Matcher m = commandPattern.matcher(input);

    if (!m.find()) {
      throw new HoroException("Invalid Command");
    }

    String s = m.group(1);

    Command c = Command.valueOf(s.toUpperCase());

    return c;
  }

  public Matcher getMatcher(String input) throws HoroException {
    Matcher m = pattern.matcher(input);
    if (!m.find()) {
      throw new HoroException("Wrong command format\n" + format);
    }
    return m;
  }
}

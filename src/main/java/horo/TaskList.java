package horo;

import java.util.ArrayList;

import horo.data.Task;

public class TaskList {

  private ArrayList<Task> taskList = new ArrayList<Task>();

  public TaskList() {

  }

  public TaskList(ArrayList<Task> taskList) {
    this.taskList = taskList;
  }

  public void addTask(Task newTask) {
    taskList.add(newTask);
    System.out.println("Added: ");
    System.out.println(newTask);
  }

  public void markTaskDone(int i) {
    if (taskList.isEmpty()) {
      System.out.println("No tasks available");
      return;
    }

    try {
      taskList.get(i).markDone();
      System.out.println("Task marked as done");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Please enter a valid number from 1 - " + taskList.size());
    }
  }

  public void markTaskNotDone(int i) {
    if (taskList.isEmpty()) {
      System.out.println("No tasks available");
      return;
    }

    try {
      taskList.get(i).markNotDone();
      System.out.println("Task marked as not done");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Please enter a valid number from 1 - " + taskList.size());
    }
  }

  public void removeTask(int i) {
    if (taskList.isEmpty()) {
      System.out.println("No tasks available");
      return;
    }

    try {
      Task t = taskList.remove(i);
      System.out.println("Removed task: ");
      System.out.println(t);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Please enter a valid number from 1 - " + taskList.size());
    }
  }

  public ArrayList<Task> getTasks() {
    return taskList;
  }

  public void showTasks() {
    System.out.println("-----Tasks-----");
    for (int i = 0; i < taskList.size(); i++) {
      System.out.println((i + 1) + ". " + taskList.get(i));
    }
  }
}

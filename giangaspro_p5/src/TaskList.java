import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    ArrayList<TaskItem> TaskList = new ArrayList<>();

    public static void PrintCompletedList (TaskList List) {
        System.out.println("Completed Tasks");
        System.out.println("-----------------\n");
        for (int i = 0; i < List.TaskList.size(); i++) {
            if ("*** ".equals(List.TaskList.get(i).Complete)) {
                System.out.println(i + ") " + "[" + List.TaskList.get(i).Date + "] " + List.TaskList.get(i).Title + ": " + List.TaskList.get(i).Description);
            }
        }
        System.out.print("\n");
    }
    public static void PrintUncompletedList(TaskList List) {
        System.out.println("Uncompleted Tasks");
        System.out.println("------------------\n");
        for (int i = 0; i < List.TaskList.size(); i++) {
            if (!"*** ".equals(List.TaskList.get(i).Complete)) {
                System.out.println(i + ") " + "[" + List.TaskList.get(i).Date + "] " + List.TaskList.get(i).Title + ": " + List.TaskList.get(i).Description);
            }
        }
        System.out.print("\n");
    }
    public static String EditTaskDate (int i) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + i + ": ");
        String Date = input.nextLine();
        System.out.print("\n");
        return Date;
    }
    public static String EditTaskDescription (int i) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new description for task " + i + ": ");
        return input.nextLine();
    }
    public static String EditTaskTitle (int i) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new title for task " + i + ": ");
        return input.nextLine();
    }
    public static String GetTaskTitle () {
        Scanner input = new Scanner(System.in);
        System.out.print("Task title: ");
        return input.nextLine();
    }
    public static String GetTaskDescription () {
        Scanner input = new Scanner(System.in);
        System.out.print("Task description: ");
        return input.nextLine();
    }
    public static String GetTaskDate () {
        Scanner input = new Scanner(System.in);
        System.out.print("Task due date (YYYY-MM-DD): ");
        String Date = input.nextLine();
        System.out.print("\n");
        return Date;
    }
    public static void PrintListOperationMenu () {
        System.out.println("List Operation Menu");
        System.out.println("--------------------\n");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu\n");
    }
    public static void PrintTaskList (TaskList List) {
        System.out.println("Current Tasks");
        System.out.println("--------------\n");
        for (int i = 0; i < List.TaskList.size(); i++) {
            System.out.println(i + ") " + List.TaskList.get(i).Complete + "[" + List.TaskList.get(i).Date + "] " + List.TaskList.get(i).Title + ": " + List.TaskList.get(i).Description);
        }
        System.out.print("\n");
    }
    public static void AddAnItem (TaskList List, String Title, String Description, String Date, String Complete) {
        int checkItem = TaskItem.CheckItemCreation(Title, Date);

        if (checkItem == 0) {
            TaskItem Item = new TaskItem(Title, Description, Date, Complete);
            List.TaskList.add(Item);
        }
    }
    public static void EditAnItem (TaskList List, int TaskChoice, String title, String description, String date) {
        int checkItem;
            checkItem = TaskItem.CheckItemEdit(title, date);
            if (checkItem == 0) {
                checkItem = CheckTaskChoice(List, TaskChoice);
                if (checkItem == 0) {
                    List.TaskList.get(TaskChoice).Title = title;
                    List.TaskList.get(TaskChoice).Description = description;
                    List.TaskList.get(TaskChoice).Date = date;
                }
            }
    }
    public static void RemoveAnItem (TaskList List, int TaskChoice) {
        int checkItem = CheckTaskChoice(List, TaskChoice);
        if (checkItem == 0) {
            List.TaskList.remove(TaskChoice);
        }
    }
    public static String MarkAsCompleted (TaskList List, int TaskChoice) {
        if (TaskChoice > ((List.TaskList.size())-1) || TaskChoice < 0) {
            System.out.print("Not a valid task, task not marked as completed");
            return "";
        }
        return "*** ";
    }
    public static String MarkAsUncomplete (TaskList List, int TaskChoice) {
        if (TaskChoice > ((List.TaskList.size())-1) || TaskChoice < 0) {
            System.out.print("Not a valid task, task not unmarked as completed");
            return "*** ";
        }
        return "";
    }
    public static void Save (TaskList List, String fileName) {
        try {
            File ListFile = new File(fileName);
            PrintStream writer = new PrintStream(ListFile);

            for (int i = 0; i < List.TaskList.size(); i++) {
                writer.println(List.TaskList.get(i).Complete);
                writer.println(List.TaskList.get(i).Date);
                writer.println(List.TaskList.get(i).Title);
                writer.println(List.TaskList.get(i).Description);
            }
            writer.close();
        }
        catch (FileNotFoundException fnf) {
            System.out.print("File not found");
            return;
        }
        System.out.print("task list has been saved\n\n");
    }
    public static void Load (TaskList List, String fileName) {
        try {
            File ListFile = new File(fileName);
            Scanner reader = new Scanner(ListFile);

            String complete;
            String date;
            String title;
            String description;

            while (reader.hasNext()) {
                complete = reader.nextLine();
                date = reader.nextLine();
                title = reader.nextLine();
                description = reader.nextLine();

                TaskItem item = new TaskItem(title, description, date, complete);
                List.TaskList.add(item);
            }

            reader.close();
        } catch (FileNotFoundException fnf) {
            System.out.print("File not found\n\n");
            return;
        }
        System.out.print("task list has been loaded\n\n");
    }
    public static int CheckForItemsToEdit (TaskList List) {
        if (List.TaskList.size() == 0) {
            System.out.println("No tasks to edit\n");
            return 1;
        }
        return 0;
    }
    public static int CheckTaskChoice (TaskList List, int TaskChoice) {
        if (TaskChoice > ((List.TaskList.size())-1) || TaskChoice < 0) {
            System.out.print("Not a valid task\n\n");
            return 1;
        }
        return 0;
    }
    public static int CheckForItemsToRemove (TaskList List) {
        if (List.TaskList.size() == 0) {
            System.out.println("No tasks to remove\n");
            return 1;
        }
        return 0;
    }
    public  static int CheckForPossibleCompletion (TaskList List) {
        int check = 0;
        for (int i = 0; i < List.TaskList.size(); i++) {
            if ("*** ".equals(List.TaskList.get(i).Complete)) {
                check++;
            }
        }
        if (check == List.TaskList.size()) {
            System.out.println("No items to mark as completed\n");
            return 1;
        }
        return 0;
    }
    public static int CheckForValidSave (TaskList List) {
        if (List.TaskList.size() == 0) {
            System.out.println("No items to save");
            return 1;
        }
        return 0;
    }
    public static int CheckForPossibleUncompletion (TaskList List) {
        int check = 0;
        for (int i = 0; i < List.TaskList.size(); i++) {
            if (!"*** ".equals(List.TaskList.get(i).Complete)) {
                check++;
            }
        }
        if (check == List.TaskList.size()) {
            System.out.println("No items to unmark as completed\n");
            return 1;
        }
        return 0;
    }
}

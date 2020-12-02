import java.util.Scanner;

public class TaskApp {
    public static void TaskApplication () {
        int choice;
        do {
            PrintTaskMenu();
            choice = MainApp.ObtainChoice(3);

            if (choice == 1) {
                OptionOne();
            }
            if (choice == 2) {
                Scanner input = new Scanner(System.in);
                TaskList List = new TaskList();
                System.out.print("Enter the filename to load: ");
                String fileName = input.nextLine();
                TaskList.Load(List, fileName);
                OptionTwo(List);
            }
        }while(choice != 3);
    }
    public static void PrintTaskMenu () {
        System.out.println("\nMain Menu");
        System.out.println("-----------\n");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit\n");
    }
    public static void OptionOne () {
        TaskList List = new TaskList();
        System.out.println("new task list has been created\n");
        OptionTwo(List);
    }
    public static void OptionTwo (TaskList List) {
        int choice1;
        do {
            TaskList.PrintListOperationMenu();
            choice1 = MainApp.ObtainChoice(8);

            if (choice1 == 1) {
                TaskList.PrintTaskList(List);
            }
            if (choice1 == 2) {
                String Title = TaskList.GetTaskTitle();
                String Description = TaskList.GetTaskDescription();
                String Date = TaskList.GetTaskDate();
                String Complete = "";
                TaskList.AddAnItem(List, Title, Description, Date, Complete);
            }
            if (choice1 == 3) {
                int check = TaskList.CheckForItemsToEdit(List);
                if (check != 1) {
                    Scanner input = new Scanner(System.in);
                    TaskList.PrintTaskList(List);
                    System.out.print("Which task will you edit? ");
                    int TaskChoice = input.nextInt();
                    int check1 = TaskList.CheckTaskChoice(List, TaskChoice);
                    if (check1 == 0) {
                        String title = TaskList.EditTaskTitle(TaskChoice);
                        String description = TaskList.EditTaskDescription(TaskChoice);
                        String date = TaskList.EditTaskDate(TaskChoice);

                        TaskList.EditAnItem(List, TaskChoice, title, description, date);
                    }
                }
            }
            if (choice1 == 4) {
                int check = TaskList.CheckForItemsToRemove(List);
                if (check != 1) {
                    Scanner input = new Scanner(System.in);
                    TaskList.PrintTaskList(List);
                    System.out.print("Which task will you remove? ");
                    int TaskChoice = input.nextInt();
                    System.out.print("\n");

                    TaskList.RemoveAnItem(List, TaskChoice);
                }
            }
            if (choice1 == 5) {
                int check = TaskList.CheckForPossibleCompletion(List);
                if (check == 0) {
                    Scanner input = new Scanner(System.in);
                    TaskList.PrintUncompletedList(List);
                    System.out.print("Which task will you mark as completed? ");
                    int TaskChoice = input.nextInt();
                    System.out.print("\n");
                    List.TaskList.get(TaskChoice).Complete = TaskList.MarkAsCompleted(List, TaskChoice);
                }
            }
            if (choice1 == 6) {
                int check = TaskList.CheckForPossibleUncompletion(List);
                if (check == 0) {
                    Scanner input = new Scanner(System.in);
                    TaskList.PrintCompletedList(List);
                    System.out.print("Which task will you unmark as completed? ");
                    int TaskChoice = input.nextInt();
                    System.out.print("\n");
                    List.TaskList.get(TaskChoice).Complete = TaskList.MarkAsUncomplete(List, TaskChoice);
                }
            }
            if (choice1 == 7) {
                int check = TaskList.CheckForValidSave(List);
                if (check == 0) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the filename to save as: ");
                    String fileName = input.nextLine();
                    TaskList.Save(List, fileName);
                }
            }
            if (choice1 == 8) {
                System.out.print("\n");
            }
        }while(choice1 != 8);
    }
}

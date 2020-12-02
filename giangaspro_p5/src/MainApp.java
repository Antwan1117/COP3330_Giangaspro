import java.util.Scanner;

public class MainApp {
    public static void main (String [] args) {
        int choice;
        do {
            PrintMenu();
            choice = ObtainChoice(3);

            if (choice == 1) {
                TaskApp.TaskApplication();
            }
            if (choice == 2) {
                ContactApp.ContactApplication();
            }
        }while(choice != 3);

    }
    public static void PrintMenu () {
        System.out.print("Select Your Application\n");
        System.out.print("------------------------\n\n");
        System.out.print("1) task list\n");
        System.out.print("2) contact list\n");
        System.out.print("3) quit\n\n");
    }
    public static int ObtainChoice (int check) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        while (choice < 1 || choice > check) {
            System.out.println("Invalid Entry! Try again:");
            choice = input.nextInt();
        }
        return choice;
    }
}

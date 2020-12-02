import java.util.Scanner;

public class ContactApp {
    public static void ContactApplication () {
        int choice;
        do {
            PrintContactMenu();
            choice = MainApp.ObtainChoice(3);

            if (choice == 1) {
                Choice1();
            }
            if (choice == 2) {
                Scanner input = new Scanner(System.in);
                ContactList List = new ContactList();
                System.out.print("Enter the filename to load: ");
                String fileName = input.nextLine();
                ContactList.LoadContactList(List, fileName);
                Choice2(List);
            }
        }while(choice != 3);

    }
    public static void PrintContactMenu () {
        System.out.print("\nMain Menu\n");
        System.out.print("----------\n\n");
        System.out.print("1) create a new list\n");
        System.out.print("2) load an existing list\n");
        System.out.print("3) quit\n\n");
    }
    public static void Choice1 () {
        ContactList List1 = new ContactList();
        System.out.print("new contact list has been created\n\n");
        Choice2(List1);
    }
    public static void Choice2 (ContactList List1) {
        int choice1;
        do {
            ContactList.PrintContactListOperationsMenu();
            choice1 = MainApp.ObtainChoice(6);

            if (choice1 == 1) {
                ContactList.PrintContactList(List1);
            }
            if (choice1 == 2) {
                String FirstName = ContactList.GetContactFirstName();
                String LastName = ContactList.GetContactLastName();
                String Phone = ContactList.GetContactPhone();
                String Email = ContactList.GetContactEmail();
                ContactList.AddAContact(List1, FirstName, LastName, Phone, Email);
                System.out.print("\n");
            }
            if (choice1 == 3) {
                int check = ContactList.CheckForContactsToEdit(List1);
                if (check == 0) {
                    Scanner input = new Scanner(System.in);
                    ContactList.PrintContactList(List1);
                    System.out.print("Which contact will you edit? ");
                    int ContactChoice = input.nextInt();
                    int check1 = ContactList.CheckContactChoice(List1, ContactChoice);
                    if (check1 == 0) {
                        String firstname = ContactList.EditContactFirstName(ContactChoice);
                        String lastname = ContactList.EditContactLastName(ContactChoice);
                        String phone = ContactList.EditContactPhone(ContactChoice);
                        String email = ContactList.EditContactEmail(ContactChoice);

                        ContactList.EditAContact(List1, ContactChoice, firstname, lastname, phone, email);
                    }
                }
            }
            if (choice1 == 4) {
                int check = ContactList.CheckForContactsToRemove(List1);
                if (check != 1) {
                    Scanner input = new Scanner(System.in);
                    ContactList.PrintContactList(List1);
                    System.out.print("Which contact will you remove? ");
                    int ContactChoice = input.nextInt();
                    System.out.print("\n");

                    ContactList.RemoveAContact(List1, ContactChoice);
                }
            }
            if (choice1 == 5) {
                int check = ContactList.CheckForValidContactSave(List1);
                if (check == 0) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the filename to save as: ");
                    String fileName = input.nextLine();
                    ContactList.SaveContactList(List1, fileName);
                }
            }
        }while (choice1 != 6);
    }
}

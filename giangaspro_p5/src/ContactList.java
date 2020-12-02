import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<ContactItem> ContactList = new ArrayList<>();

    public static void PrintContactListOperationsMenu () {
        System.out.println("List Operation Menu");
        System.out.println("--------------------\n");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu\n");
    }
    public static void PrintContactList (ContactList List) {
        System.out.println("Current Contacts");
        System.out.println("-----------------\n");
        for (int i = 0; i < List.ContactList.size(); i++) {
            System.out.println(i + ") Name: " + List.ContactList.get(i).FirstName + " " + List.ContactList.get(i).LastName + "\nPhone: " + List.ContactList.get(i).PhoneNumber + "\nEmail: " + List.ContactList.get(i).Email);
        }
        System.out.print("\n");
    }
    public static String GetContactFirstName () {
        Scanner input = new Scanner(System.in);
        System.out.print("First name: ");
        return input.nextLine();
    }
    public static String GetContactLastName () {
        Scanner input = new Scanner(System.in);
        System.out.print("Last name: ");
        return input.nextLine();
    }
    public static String GetContactPhone () {
        Scanner input = new Scanner(System.in);
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        return input.nextLine();
    }
    public static String GetContactEmail () {
        Scanner input = new Scanner(System.in);
        System.out.print("Email address (x@y.z): ");
        return input.nextLine();
    }
    public static void AddAContact (ContactList List, String first, String last, String phone, String email) {
        int checkcontact = ContactItem.CheckContactCreation(first, last, phone, email);

        if (checkcontact == 0) {
            ContactItem item = new ContactItem(first, last, phone, email);
            List.ContactList.add(item);
        }
    }
    public static int CheckForContactsToEdit (ContactList List) {
        if (List.ContactList.size() == 0) {
            System.out.println("No Contacts to edit\n");
            return 1;
        }
        return 0;
    }
    public static String EditContactFirstName (int i) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new first name for contact " + i + ": ");
        return input.nextLine();
    }
    public static String EditContactLastName (int i) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new last name for contact " + i + ": ");
        return input.nextLine();
    }
    public static String EditContactPhone (int i) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + i + ": ");
        return input.nextLine();
    }
    public static String EditContactEmail (int i) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new email address (x@y.z) for contact " + i + ": ");
        String email = input.nextLine();
        System.out.print("\n");
        return email;
    }
    public static void EditAContact (ContactList List, int ContactChoice, String firstname, String lastname, String phone, String email) {
        int checkItem;
        checkItem = ContactItem.CheckContactEdit(firstname, lastname, phone, email);
            if (checkItem == 0) {
                checkItem = CheckContactChoice(List, ContactChoice);
                if (checkItem == 0) {
                    List.ContactList.get(ContactChoice).FirstName = firstname;
                    List.ContactList.get(ContactChoice).LastName = lastname;
                    List.ContactList.get(ContactChoice).PhoneNumber = phone;
                    List.ContactList.get(ContactChoice).Email = email;
                }
            }
    }
    public static int CheckContactChoice (ContactList List, int ContactChoice) {
        if (ContactChoice > ((List.ContactList.size())-1) || ContactChoice < 0) {
            System.out.print("Not a valid Contact\n\n");
            return 1;
        }
        return 0;
    }
    public static int CheckForContactsToRemove (ContactList List) {
        if (List.ContactList.size() == 0) {
            System.out.println("No Contacts to remove\n");
            return 1;
        }
        return 0;
    }
    public static void RemoveAContact (ContactList List, int ContactChoice) {
        int checkItem = CheckContactChoice(List, ContactChoice);
        if (checkItem == 0) {
            List.ContactList.remove(ContactChoice);
        }
    }
    public static void SaveContactList (ContactList List, String fileName) {
        try {
            File ListFile = new File(fileName);
            PrintStream writer = new PrintStream(ListFile);

            for (int i = 0; i < List.ContactList.size(); i++) {
                writer.println(List.ContactList.get(i).FirstName);
                writer.println(List.ContactList.get(i).LastName);
                writer.println(List.ContactList.get(i).PhoneNumber);
                writer.println(List.ContactList.get(i).Email);
            }
            writer.close();
        }
        catch (FileNotFoundException fnf) {
            System.out.print("File not found");
            return;
        }
        System.out.print("contact list has been saved\n\n");
    }
    public static int CheckForValidContactSave (ContactList List) {
        if (List.ContactList.size() == 0) {
            System.out.println("No items to save");
            return 1;
        }
        return 0;
    }
    public static void LoadContactList (ContactList List, String fileName) {
        try {
            File ListFile = new File(fileName);
            Scanner reader = new Scanner(ListFile);

            String firstname;
            String lastname;
            String phone;
            String email;

            while (reader.hasNext()) {
                firstname = reader.nextLine();
                lastname = reader.nextLine();
                phone = reader.nextLine();
                email = reader.nextLine();

                ContactItem item = new ContactItem(firstname, lastname, phone, email);
                List.ContactList.add(item);
            }

            reader.close();
        } catch (FileNotFoundException fnf) {
            System.out.print("File not found\n\n");
            return;
        }
        System.out.print("contact list has been loaded\n\n");
    }
}

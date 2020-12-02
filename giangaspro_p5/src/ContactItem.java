import java.io.Serializable;


public class ContactItem implements Serializable{
    String FirstName;
    String LastName;
    String PhoneNumber;
    String Email;
    public ContactItem (String firstname, String lastname, String phonenumber, String email) {
        FirstName = firstname;
        LastName = lastname;
        PhoneNumber = phonenumber;
        Email = email;
    }
    public static int CheckContactCreation (String firstname, String lastname, String phoneNumber, String email) {
        int check = 0;
        if (firstname.isBlank()) {
            check = check + 1;
        }
        if (lastname.isBlank()) {
            check = check + 1;
        }
        if (phoneNumber.isBlank()) {
            check = check + 1;
        }
        if (email.isBlank()) {
            check = check + 1;
        }
        if (check == 4) {
            System.out.print("WARNING: must contain at least one of [first name], [last name], [phone number], or [email address]; contact not created\n\n");
            return 1;
        }
        if (!phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
            if (check != 3) {
                System.out.print("WARNING: invalid phone number; contact not created\n\n");
                return 1;
            }
        }
        if (!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            if (check != 3) {
                System.out.print("WARNING: invalid email; contact not created\n\n");
                return 1;
            }
        }
        return 0;
    }
    public static int CheckContactEdit (String firstname, String lastname, String phone, String email) {
        int check = 0;
        if (firstname.isBlank()) {
            check = check + 1;
        }
        if (lastname.isBlank()) {
            check = check + 1;
        }
        if (phone.isBlank()) {
            check = check + 1;
        }
        if (email.isBlank()) {
            check = check + 1;
        }
        if (check == 4) {
            System.out.print("WARNING: must contain at least one of [first name], [last name], [phone number], or [email address]; contact not edited\n\n");
            return 1;
        }
        if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            if (check != 3) {
                System.out.print("WARNING: invalid phone number; contact not edited\n\n");
                return 1;
            }
        }
        if (!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            if (check != 3) {
                System.out.print("WARNING: invalid email; contact not edited\n\n");
                return 1;
            }
        }
        return 0;
    }
}

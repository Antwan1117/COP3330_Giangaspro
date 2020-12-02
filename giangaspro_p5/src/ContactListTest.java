import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactListTest {
    @Test
    public void AddingContactIncreasesSize() {
        ContactList List = new ContactList();
        ContactList.AddAContact(List, "jon", "jonson", "555-555-5555", "hello@cia.gov");
        assertEquals(1, List.ContactList.size());
    }

    @Test
    public void EditingContactFirstNameChangesFirstName() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.EditAContact(List, 0, "johnny", "jonson", "555-555-5555", "hello@cia.gov");
        assertEquals("johnny", List.ContactList.get(0).FirstName);
    }

    @Test
    public void EditingContactLastNameChangesLastName() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.EditAContact(List, 0, "jon", "appleseed", "555-555-5555", "hello@cia.gov");
        assertEquals("appleseed", List.ContactList.get(0).LastName);
    }

    @Test
    public void EditingContactPhoneNumberChangesPhoneNumber() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.EditAContact(List, 0, "jon", "jonson", "999-999-9999", "hello@cia.gov");
        assertEquals("999-999-9999", List.ContactList.get(0).PhoneNumber);
    }

    @Test
    public void EditingContactEmailChangesEmail () {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.EditAContact(List, 0, "jon", "jonson", "555-555-5555", "okay@gmail.com");
        assertEquals("okay@gmail.com", List.ContactList.get(0).Email);
    }

    @Test
    public void EditingContactFirstNameFailsWithInvalidIndex() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.EditAContact(List, 1, "Hi", "Hello", "999-999-9999", "no@gmail.com");
        assertEquals("jon", List.ContactList.get(0).FirstName);
    }

    @Test
    public void EditingContactLastNameFailsWithInvalidIndex() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.EditAContact(List, 1, "Hello", "Hi", "999-999-9999", "no@gmail.com");
        assertEquals("jonson", List.ContactList.get(0).LastName);
    }

    @Test
    public void EditingContactPhoneNumberFailsWithInvalidIndex() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.EditAContact(List, 1, "Hello", "Hello", "666-666-6666", "no@gmail.com");
        assertEquals("555-555-5555", List.ContactList.get(0).PhoneNumber);
    }

    @Test
    public void EditingContactEmailFailsWithInvalidIndex () {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.EditAContact(List, 1, "hello", "hello", "666-666-6666", "no@gmail.com");
        assertEquals("hello@cia.gov", List.ContactList.get(0).Email);
    }

    @Test
    public void GettingContactDataFailsWithInvalidIndex() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        assertEquals(1, ContactList.CheckContactChoice(List, 1));
    }

    @Test
    public void GettingContactFirstNamePassesWithValidIndex() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        assertEquals("jon", List.ContactList.get(0).FirstName);
    }

    @Test
    public void GettingContactLastNamePassesWithValidIndex() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        assertEquals("jonson", List.ContactList.get(0).LastName);
    }

    @Test
    public void GettingContactPhoneNumberPassesWithValidIndex() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        assertEquals("555-555-5555", List.ContactList.get(0).PhoneNumber);
    }

    @Test
    public void GettingContactEmailPassesWithValidIndex () {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        assertEquals("hello@cia.gov", List.ContactList.get(0).Email);
    }

    @Test
    public void NewContactListIsEmpty() {
        ContactList List = new ContactList();
        assertEquals(0, List.ContactList.size());
    }

    @Test
    public void RemovingContactDecreasesSizeWithValidIndex() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.RemoveAContact(List, 0);
        assertEquals(0, List.ContactList.size());
    }

    @Test
    public void RemovingContactFailsWithInvalidIndex() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.RemoveAContact(List, 1);
        assertEquals(1, List.ContactList.size());
    }

    @Test
    public void SavedContactListsCanBeLoaded() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.SaveContactList(List, "List.txt");
        List.ContactList.remove(0);
        ContactList.LoadContactList(List, "List.txt");
        assertEquals("jon", List.ContactList.get(0).FirstName);
    }

    @Test
    public void SavedContactListsFailToLoadWithInvalidFileName() {
        ContactList List = new ContactList();
        ContactItem item = new ContactItem("jon", "jonson", "555-555-5555", "hello@cia.gov");
        List.ContactList.add(item);
        ContactList.SaveContactList(List, "List.txt");
        List.ContactList.remove(0);
        ContactList.LoadContactList(List, "Lis.txt");
        assertEquals(0, List.ContactList.size());
    }

    @Test
    public void ContactListsFailToSaveWhenEmpty() {
        ContactList List = new ContactList();
        assertEquals(1, ContactList.CheckForValidContactSave(List));
    }
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactItemTest {
    @Test
    public void ContactCreationFailsWithInvalidEmail () {
        assertEquals(1, ContactItem.CheckContactCreation("jon", "jonson", "904-555-5555", "hello"));
    }

    @Test
    public void ContactCreationFailsWithInvalidPhoneNumber () {
        assertEquals(1, ContactItem.CheckContactCreation("jon", "jonson", "904-46-5555", "hello@cia.gov"));
    }

    @Test
    public void ContactCreationFailsWhenAllInformationIsBlank () {
        assertEquals(1, ContactItem.CheckContactCreation("", "", "", ""));
    }

    @Test
    public void ContactCreationPassesWithValidAllValidInformation () {
        assertEquals(0, ContactItem.CheckContactCreation("jon", "jonson", "555-555-5555", "hello@cia.gov"));
    }

    @Test
    public void ContactCreationPassesWithOnlyValidPhoneNumber () {
        assertEquals(0, ContactItem.CheckContactCreation("", "", "555-555-5555", ""));
    }

    @Test
    public void ContactCreationPassesWithOnlyValidEmail () {
        assertEquals(0, ContactItem.CheckContactCreation("", "", "", "hello@cia.gov"));
    }

    @Test
    public void ContactEditFailsWithAllBlankInformation () {
        assertEquals(1, ContactItem.CheckContactEdit("", "", "", ""));
    }

    @Test
    public void ContactEditFailsWithInvalidPhoneNumber () {
        assertEquals(1, ContactItem.CheckContactEdit("jon", "jonson", "555-55-5555", "poop@cia.gov"));
    }

    @Test
    public void ContactEditFailsWithInvalidEmail () {
        assertEquals(1, ContactItem.CheckContactEdit("jon", "jonson", "555-555-5555", "no.com"));
    }

    @Test
    public void ContactEditPassesWithAllValidInformation () {
        assertEquals(0, ContactItem.CheckContactEdit("jon", "jonson", "555-555-5555", "hello@cia.gov"));
    }

    @Test
    public void ContactEditPassesWithOnlyValidPhoneNumber () {
        assertEquals(0, ContactItem.CheckContactEdit("", "", "555-555-5555", ""));
    }

    @Test
    public void ContactEditPassesWithOnlyValidEmail () {
        assertEquals(0, ContactItem.CheckContactEdit("", "", "", "hello@cia.gov"));
    }

    @Test
    public void ContactEditPassesWithOnlyValidName () {
        assertEquals(0, ContactItem.CheckContactEdit("jon", "", "", ""));
    }
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskItemTest {
    @Test
    public void ItemCreationFailsWithInvalidDueDate () {
        assertEquals(1, TaskItem.CheckItemCreation("Hello there", "2020-1-04"));
    }

    @Test
    public void ItemCreationFailsWithInvalidTitle () {
        assertEquals(1, TaskItem.CheckItemCreation("", "2020-03-08"));
    }

    @Test
    public void ItemCreationPassesWithValidDueDateAndTitle () {
        assertEquals(0, TaskItem.CheckItemCreation("hello there", "2020-03-08"));
    }

    @Test
    public void ItemEditFailsWithInvalidDueDate () {
        assertEquals(1, TaskItem.CheckItemEdit("Hello there", "2020-1-04"));
    }

    @Test
    public void ItemEditFailsWithInvalidTitle () {
        assertEquals(1, TaskItem.CheckItemEdit("", "2020-01-04"));
    }

    @Test
    public void ItemEditPassesWithValidDueDateAndTitle () {
        assertEquals(0, TaskItem.CheckItemEdit("Hello there", "2020-01-04"));
    }
}
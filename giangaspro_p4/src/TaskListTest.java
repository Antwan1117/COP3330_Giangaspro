import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TaskListTest {
    @Test
    public void AddingItemIncreasesSize () {
        TaskList List = new TaskList();
        TaskList.AddAnItem(List, "Hello there", "Hello there", "2020-03-08", "");
        assertEquals(1, List.TaskList.size());
    }

    @Test
    public void CompletingTaskItemChangesStatus () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        assertEquals("*** ", TaskList.MarkAsCompleted(List, 0));
    }

    @Test
    public void CompletingTaskItemFailsWhenTaskChoiceInvalid () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        assertEquals("", TaskList.MarkAsCompleted(List, 1));
    }

    @Test
    public void UncompletingTaskItemChangesStatus () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.MarkAsCompleted(List, 0);
        assertEquals("", TaskList.MarkAsUncomplete(List, 0));
    }

    @Test
    public void UncompletingTaskItemFailsWhenTaskChoiceInvalid () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.MarkAsCompleted(List, 0);
        assertEquals("*** ", TaskList.MarkAsUncomplete(List, 1));
    }

    @Test
    public void EditingTaskItemTitleChangesTitle () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.EditAnItem(List, 0, "Hi", "Hello", "2020-03-08");
        assertEquals("Hi", List.TaskList.get(0).Title);
    }

    @Test
    public void EditingTaskItemDescriptionChangesDescription () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.EditAnItem(List, 0, "Hello", "Hi", "2020-03-08");
        assertEquals("Hi", List.TaskList.get(0).Description);
    }

    @Test
    public void EditingTaskItemDateChangesDate () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.EditAnItem(List, 0, "Hello", "Hello", "3000-03-08");
        assertEquals("3000-03-08", List.TaskList.get(0).Date);
    }

    @Test
    public void EditingTaskItemTitleFailsWithInvalidIndex () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.EditAnItem(List, 1, "Hi", "Hello", "2020-03-08");
        assertEquals("Hello", List.TaskList.get(0).Title);
    }

    @Test
    public void EditingTaskItemDescriptionFailsWithInvalidIndex () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.EditAnItem(List, 1, "Hello", "Hi", "2020-03-08");
        assertEquals("Hello", List.TaskList.get(0).Description);
    }

    @Test
    public void EditingTaskItemDateFailsWithInvalidIndex () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.EditAnItem(List, 1, "Hello", "Hello", "3030-03-08");
        assertEquals("2020-03-08", List.TaskList.get(0).Date);
    }

    @Test
    public void GettingTaskItemDataFailsWithInvalidIndex () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        assertEquals(1, TaskList.CheckTaskChoice(List, 1));
    }

    @Test
    public void GettingTaskItemTitlePassesWithValidIndex () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        assertEquals("Hello", List.TaskList.get(0).Title);
    }

    @Test
    public void GettingTaskItemDescriptionPassesWithValidIndex () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        assertEquals("Hello", List.TaskList.get(0).Description);
    }

    @Test
    public void GettingTaskItemDatePassesWithValidIndex () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        assertEquals("2020-03-08", List.TaskList.get(0).Date);
    }

    @Test
    public void NewTaskListIsEmpty () {
        TaskList List = new TaskList();
        assertEquals(0, List.TaskList.size());
    }

    @Test
    public void RemovingTaskItemDecreasesSizeWithValidIndex () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.RemoveAnItem(List, 0);
        assertEquals(0, List.TaskList.size());
    }

    @Test
    public void RemovingTaskItemFailsWithInvalidIndex () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.RemoveAnItem(List, 1);
        assertEquals(1, List.TaskList.size());
    }

    @Test
    public void SavedTaskListsCanBeLoaded () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.Save(List, "List.txt");
        List.TaskList.remove(0);
        TaskList.Load(List, "List.txt");
        assertEquals("Hello", List.TaskList.get(0).Title);
    }

    @Test
    public void SavedTaskListsFailToLoadWithInvalidFileName () {
        TaskList List = new TaskList();
        TaskItem item = new TaskItem("Hello", "Hello", "2020-03-08", "");
        List.TaskList.add(item);
        TaskList.Save(List, "List.txt");
        List.TaskList.remove(0);
        TaskList.Load(List, "Lis.txt");
        assertEquals(0, List.TaskList.size());
    }

    @Test
    public void TaskListsFailToSaveWhenEmpty () {
        TaskList List = new TaskList();
        assertEquals(1, TaskList.CheckForValidSave(List));
    }
}
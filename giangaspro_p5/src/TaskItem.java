import java.io.Serializable;

public class TaskItem implements Serializable {
    String Title;
    String Description;
    String Date;
    String Complete;
    public TaskItem (String title, String description, String date, String complete) {
        Title = title;
        Description = description;
        Date = date;
        Complete = complete;
    }
    public static int CheckItemCreation (String title, String date) {
        if (title.isBlank()) {
            System.out.print("WARNING: title must be at least 1 character long; task not created\n\n");
            return 1;
        }
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.print("WARNING: invalid due date; task not created\n\n");
            return 1;
        }
        return 0;
    }
    public static int CheckItemEdit (String title, String date) {
        if (title.isBlank()) {
            System.out.print("WARNING: title must be at least 1 character long; task not edited\n\n");
            return 1;
        }
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.print("WARNING: invalid due date; task not edited\n\n");
            return 1;
        }
        return 0;
    }
}

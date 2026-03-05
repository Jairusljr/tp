package seedu.duke.categories;

public class Other implements Category {
    public String getTypeIcon() {
        return "[Other]";
    }

    public String toString() {
        return "This expense has been automatically assigned to " + getTypeIcon();
    }
}

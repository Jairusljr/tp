package seedu.duke.categories;

public enum CategoryType {
    FOOD, GROCERIES, OTHER, SUBSCRIPTION, TRANSPORT;

    public static boolean isValid(String userInput) {
        for (CategoryType type : values()) {
            if (type.name().equalsIgnoreCase(userInput)) {
                return true;
            }
        }
        return false;
    }
}

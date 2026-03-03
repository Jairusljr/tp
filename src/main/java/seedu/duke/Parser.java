package seedu.duke;

/**
 * Parses raw user input into command tokens.
 *
 * <p>This class is responsible only for extracting the command keyword
 * from a full user input line. It does not validate arguments or execute
 * commands.</p>
 *
 * <p>Example:
 * <ul>
 *   <li>"add 12.50" -> "add"</li>
 *   <li>"delete 3" -> "delete"</li>
 * </ul>
 * </p>
 */
public class Parser {
    public static final int MAX_SPLIT_LENGTH = 2;

    /**
     * Extracts the command keyword from a raw input string.
     *
     * <p>The input is split at the first space character.</p>
     *
     * <p>No validation is performed. The returned string may be empty
     * if the input string is empty.</p>
     *
     * @param input Raw user input line.
     * @return The command keyword (first token before the first space).
     */
    public static String parseCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        return input.trim().split(" ", MAX_SPLIT_LENGTH)[0].toLowerCase();
    }
}

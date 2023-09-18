package duke;

/**
 * Class to parse the input
 */
public class Parser {

    /**
     * Handles user input and determines the relevant command and input for further processing.
     * Parses the user input and extracts the command type and associated input.
     * Supports commands such as "mark," "unmark," "delete," "list," "todo," "deadline," and "event."
     *
     * @param userInput The input string entered by the user.
     * @return An array containing the command type and associated input.
     * @throws InvalidInputExpression If the user input does not match any supported command.
     */
    public String[] handleUserInput(String userInput) throws DukeException, InvalidInputExpression {
        try {
            parseInputForFormatErrors(userInput);
            if (userInput.startsWith("mark")) {
                return new String[]{"mark", userInput};
            } else if (userInput.startsWith("unmark")) {
                return new String[]{"unmark", userInput};
            } else if (userInput.startsWith("delete")) {
                return new String[]{"delete", userInput};
            } else if (userInput.startsWith("list")) {
                return new String[]{"list", userInput};
            } else if (userInput.startsWith("todo")) {
                return new String[]{"todo", userInput};
            } else if (userInput.startsWith("deadline")) {
                return new String[]{"deadline", userInput};
            } else if (userInput.startsWith("event")) {
                return new String[]{"event", userInput};
            } else if (userInput.startsWith("find")) {
                return new String[]{"find", userInput};
            } else {
                throw new InvalidInputExpression("Invalid input!!SUI, "
                        + "Specify commands as list, mark, unmark, or deadline, event "
                        + "and todo followed by the task please la dei!\n");
            }
        } catch (InvalidInputExpression e) {
            throw new InvalidInputExpression("Invalid input!!SUI, "
                    + "Specify commands as list, mark, unmark, or deadline, event "
                    + "and todo followed by the task please la dei!\n");
        }
    }

    public void parseInputForFormatErrors(String input) throws DukeException{
        checkInputHasMoreThanOneSpace(input);
        checkInputHasTrailingSpace(input);
        checkInputHasLeadingSpace(input);
    }

    /**
     * Method to check if the input has more than one space.
     * @param input user input
     * @throws DukeException
     */
    public void checkInputHasMoreThanOneSpace(String input) throws DukeException {
        if (input.contains("  ")) {
            throw new DukeException("SUI, input has more than a single space");
        }
    }

    public void checkInputHasLeadingSpace(String input) throws DukeException {
        if (!(Character.isAlphabetic(input.charAt(0)) || Character.isDigit(input.length() - 1))) {
            throw new DukeException("SUI, input has leading spaces");
        }
    }

    public void checkInputHasTrailingSpace(String input) throws DukeException {
        if (input.charAt(input.length() - 1) == ' ') {
            throw new DukeException("SUI, input has trailing spaces");
        }
    }
}

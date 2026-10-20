package org.example.console;

import java.util.Scanner;


// this class handles user inputs from the console
//
public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readNonEmptyString(String prompt) {
        while (true) {
            String value = readLine(prompt);
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Value cannot be empty.");
        }
    }

    public int readInt(String prompt) {
        return Integer.parseInt(readLine(prompt));
    }

    public String readChoice(String prompt, String... choices) {
        if (choices.length == 0) {
            return readNonEmptyString(prompt);
        }

        while (true) {
            String value = readLine(prompt);
            for (String choice : choices) {
                if (choice.equalsIgnoreCase(value)) {
                    return choice;
                }
            }
            System.out.println("Choose one of: " + String.join(", ", choices) + ".");
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}

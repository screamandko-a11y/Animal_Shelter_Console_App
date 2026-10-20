package org.example.console;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;


// this class handles user inputs from the console

@RequiredArgsConstructor
public class ConsoleInput {
    private final Scanner scanner;

    public String readNonEmptyString(String prompt) {
        while (true) {
            String value = readLine(prompt);
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Value cannot be empty");
        }
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid whole number");
            }
        }
    }

    public int readNonNegativeInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value >= 0) {
                return value;
            }
            System.out.println("Value cannot be negative");
        }
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
            System.out.println("Choose one of :" + String.join(", ", choices) + ".");
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}

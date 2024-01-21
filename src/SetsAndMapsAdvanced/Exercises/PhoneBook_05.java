package SetsAndMapsAdvanced.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook_05 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();
        String entry = kbInput.nextLine();

        while (!"search".equalsIgnoreCase(entry)) {

            String name = entry.split("-")[0];
            String number = entry.split("-")[1];

            if (phonebook.containsKey(entry)) {

                phonebook.replace(name, number);
            } else {
                phonebook.put(name, number);
            }

            entry = kbInput.nextLine();
        }

        if ("search".equalsIgnoreCase(entry)) {
            entry = kbInput.nextLine();
        }

        while (!"stop".equalsIgnoreCase(entry)) {

            if (phonebook.containsKey(entry)) {

                System.out.printf("%s -> %s%n", entry, phonebook.get(entry));
            } else {
                System.out.printf("Contact %s does not exist.%n", entry);
            }

            entry = kbInput.nextLine();
        }

    }
}

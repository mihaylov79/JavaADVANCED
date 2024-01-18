package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Set<String> container = new LinkedHashSet<>();

        int nums = Integer.parseInt(kbInput.nextLine());

        for (int i = 0; i < nums; i++) {
            String greetings = kbInput.nextLine();

            container.add(greetings);

        }

        container.forEach(System.out::println);
    }
}

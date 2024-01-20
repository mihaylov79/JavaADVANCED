package SetsAndMapsAdvanced.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int lenght = Integer.parseInt(kbInput.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < lenght; i++) {

            elements.addAll(Arrays.asList(kbInput.nextLine().split("\\s+")));

        }
         elements.forEach(e -> System.out.print(e + " " ));

    }
}

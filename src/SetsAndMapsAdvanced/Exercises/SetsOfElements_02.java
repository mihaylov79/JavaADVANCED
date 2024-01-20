package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        String lengthInput = kbInput.nextLine();

        int set1Length = Integer.parseInt(lengthInput.split("\\s+")[0]);
        int set2Length = Integer.parseInt(lengthInput.split("\\s+")[1]);

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        fillTheSet(set1Length, set1, kbInput);
        fillTheSet(set2Length,set2,kbInput);

        set1.retainAll(set2);
        set1.forEach(e -> System.out.print(e + " "));
    }

    private static void fillTheSet(int set1Length, Set<Integer> set1, Scanner kbInput) {
        for (int i = 0; i < set1Length; i++) {
            set1.add(Integer.parseInt(kbInput.nextLine()));

        }
    }
}

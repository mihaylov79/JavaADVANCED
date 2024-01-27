package FunctinalPrograming.Exercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor_ver02_02 {

    public static void main(String[] args) {

        Scanner kbInput = new Scanner(System.in);

        Consumer<String> printSir = s -> System.out.println("Sir" + " " + s);

        String[] nameArr = kbInput.nextLine().split("\\s+");

        for (String s : nameArr) {
            printSir.accept(s);
        }
    }
}

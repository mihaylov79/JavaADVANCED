package FunctinalPrograming.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {

        Scanner kbInput = new Scanner(System.in);

        Arrays.stream(kbInput.nextLine().split("\\s+")).forEach(s -> System.out.println("Sir" + " "+ s));
    }
}

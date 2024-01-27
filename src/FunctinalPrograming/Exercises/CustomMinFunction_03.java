package FunctinalPrograming.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        System.out.println(Arrays.stream(kbInput.nextLine().split("\\s+"))
                    .map(Integer::parseInt).min(Integer::compare).get());
    }
}

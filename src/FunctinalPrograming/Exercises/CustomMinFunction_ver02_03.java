package FunctinalPrograming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;


public class CustomMinFunction_ver02_03 {
    public static void main(String[] args) {

        Scanner kbInput = new Scanner(System.in);

        int[] input = Arrays.stream(kbInput.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Integer[] inputArr = new Integer[input.length];

        Function<Integer[], Integer> minValue = integers -> Arrays.stream(integers).min(Integer::compare).get();


        for (int i = 0; i < input.length; i++) {

            inputArr[i] = input[i];

        }


        System.out.println(minValue.apply(inputArr));
    }
}

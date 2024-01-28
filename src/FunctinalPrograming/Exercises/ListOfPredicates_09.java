package FunctinalPrograming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int n = Integer.parseInt(kbInput.nextLine());

        List<Integer> divisibles = new ArrayList<>();

        List<Integer> divisors = Arrays.stream(kbInput.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 1; i <= n; i++) {

            divisibles.add(i);

        }

        BiPredicate<Integer, List<Integer>> isDividable = (i1, integers) -> {
            boolean valid = true;
            for (int i = 0; i < integers.size(); i++) {

                if (i1 % integers.get(i) != 0) {
                    valid = false;
                    break;
                }
            }
            return valid;
        };

        for (Integer i1 : divisibles) {

            if (isDividable.test(i1, divisors)) {

                System.out.print(i1 + " ");
            }
        }
    }
}

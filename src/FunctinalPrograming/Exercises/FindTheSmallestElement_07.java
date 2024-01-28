package FunctinalPrograming.Exercises;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07 {

    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

      List<Integer> inputArr = Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

      Function<List<Integer>,Integer> minVal = integers -> integers.indexOf(Collections.min(integers));

      System.out.println(minVal.apply(inputArr));

    }
}

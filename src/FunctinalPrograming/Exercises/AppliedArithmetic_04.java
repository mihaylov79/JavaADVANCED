package FunctinalPrograming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        List<Integer> list = Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
       //Integer[] arr1 = Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).toArray();


        Function < List<Integer>, List<Integer> > addFunc = integers -> integers.stream().map(e-> e + 1).collect(Collectors.toList());
        Function < List<Integer>, List<Integer> > multiplyFunc = integers -> integers.stream().map(e-> e * 2).collect(Collectors.toList());
        Function <List<Integer>, List<Integer> > subtractFunc = integers -> integers.stream().map(e-> e - 1).collect(Collectors.toList());


        String command = kbInput.nextLine();

        while (!"end".equalsIgnoreCase(command)){


            switch (command){

                case "add":

                list = addFunc.apply(list);

                break;
                case "multiply":
                  list = multiplyFunc.apply(list);
                 break;

                case "subtract":

                  list = subtractFunc.apply(list);

                  break;
                case "print":
                    list.forEach(l-> System.out.print(l + " "));
                    System.out.println();
                    break;
            }

            command = kbInput.nextLine();

        }
    }
}

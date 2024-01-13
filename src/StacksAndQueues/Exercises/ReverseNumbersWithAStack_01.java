package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(kbInput.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(stack::push);


        for (int i = stack.size(); i > 0; i--) {

            System.out.print(stack.pop() + " ");

        }


    }
}

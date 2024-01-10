package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = kbInput.nextLine();

        while (!"Home".equalsIgnoreCase(input)) {

            if (!"Back".equalsIgnoreCase(input)) {
                stack.push(input);
                System.out.println(input);
            } else {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }


            input = kbInput.nextLine();


        }


    }
}

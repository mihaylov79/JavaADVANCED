package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String [] input = kbInput.nextLine().split("");

        for (int i = 0; i < input.length /2; i++) {

            if (input.length % 2 != 0){
                System.out.println("NO");
                return;
            }

            if (input[i].equals("{")){
                stack.push("}");
            } else if (input[i].equals("[")) {
                stack.push("]");

            } else if (input[i].equals("(")) {
                stack.push(")");

            } else if (input[i].equals("}") || input[i].equals("]") || input[i].equals(")")) {

                if (input[i].equals(stack.peek())){
                    stack.pop();
                }

            }

            //stack.push(input[i]);

        }

        for (int i = (input.length / 2); i < input.length ; i++) {

            if (input[i].equals(stack.peek())){
                stack.pop();
            }
//            else {
//                System.out.println("NO");
//                return;
//            }

        }


        if (stack.isEmpty()){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}

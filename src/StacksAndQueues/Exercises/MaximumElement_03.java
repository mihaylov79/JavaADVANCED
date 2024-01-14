package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int commandsNumber = Integer.parseInt(kbInput.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commandsNumber; i++) {

            String commandInput = kbInput.nextLine();
            int command = Integer.parseInt(commandInput.split("\\s+")[0]);


            if (command == 1){
                stack.push(Integer.parseInt(commandInput.split("\\s+")[1]));

            }else if (command == 2){
                stack.pop();
            }else if (command == 3){

                System.out.println(Collections.max(stack));
            }



        }


    }
}

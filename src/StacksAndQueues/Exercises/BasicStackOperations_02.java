package StacksAndQueues.Exercises;

import java.util.*;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        String parameters = kbInput.nextLine();

        int popLength = Integer.parseInt(parameters.split(" ")[1]);
        int elementX = Integer.parseInt(parameters.split(" ")[2]);

        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(kbInput.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(stack::push);

        for (int pop = popLength; pop > 0; pop--) {

            stack.pop();

        }

        boolean isFound = stack.contains(elementX);

        if (stack.isEmpty()){
            System.out.println("0");
        }else if (isFound){
            System.out.println("true");
        }else {
            int smallestElement = Collections.min(stack);
            System.out.println(smallestElement);
        }


    }
}

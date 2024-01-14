package StacksAndQueues.Exercises;

import java.util.*;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();

        String parameters = kbInput.nextLine();


        int pollLength = Integer.parseInt(parameters.split("\\s+")[1]);
        int xElement = Integer.parseInt(parameters.split("\\s+")[2]);

        Arrays.stream(kbInput.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);

        for (int i = 0; i < pollLength; i++) {

            queue.poll();

        }
        if (queue.isEmpty()){
            System.out.println("0");
        }else if (queue.contains(xElement)){
            System.out.println("true");
        }else {
            int smallestEllement = Collections.min(queue);
            System.out.println(smallestEllement);
        }
    }
}

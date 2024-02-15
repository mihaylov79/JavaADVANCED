package ExamsPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class RubberDuckDebuggers_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<Integer> timeQueue = new ArrayDeque<>();
        Deque<Integer> tasksStack = new ArrayDeque<>();

        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(timeQueue::offer);
        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(tasksStack::push);

        int vaderDuck = 0;
        int thorDuck = 0;
        int blueDuck = 0;
        int yellowDuck = 0;

        while (!timeQueue.isEmpty() && !tasksStack.isEmpty()){

            int time = timeQueue.peek();
            int task = tasksStack.peek();
            int calculatedTime = time * task;

            if (calculatedTime > 0 && calculatedTime <= 60){
                vaderDuck ++;
                timeQueue.poll();
                tasksStack.pop();
            } else if (calculatedTime > 60 && calculatedTime <= 120) {
                thorDuck++;
                timeQueue.poll();
                tasksStack.pop();
            } else if (calculatedTime > 120 && calculatedTime <= 180) {
                blueDuck++;
                timeQueue.poll();
                tasksStack.pop();
            } else if (calculatedTime > 180 && calculatedTime <= 240) {
                yellowDuck++;
                timeQueue.poll();
                tasksStack.pop();
            } else if (calculatedTime > 240) {
                timeQueue.offer(timeQueue.poll());
                tasksStack.push(tasksStack.pop() - 2);
            }

        }


        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%n",vaderDuck);
        System.out.printf("Thor Ducky: %d%n",thorDuck);
        System.out.printf("Big Blue Rubber Ducky: %d%n",blueDuck);
        System.out.printf("Small Yellow Rubber Ducky: %d%n",yellowDuck);



    }
}

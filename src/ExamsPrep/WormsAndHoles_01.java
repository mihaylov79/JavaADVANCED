package ExamsPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class WormsAndHoles_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<Integer> wormsStack = new ArrayDeque<>();
        Deque<Integer> holesQueue = new ArrayDeque<>();

        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(wormsStack::push);
        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(holesQueue::offer);


//        int[] wormsInput = Arrays.stream(kbInput.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] holesInput = Arrays.stream(kbInput.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int matchesCount = 0;


        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()){

            int currentWorm = wormsStack.peek();
            int currentHole = holesQueue.peek();

            if (currentWorm == currentHole){
                wormsStack.pop();
                holesQueue.poll();
                matchesCount++;
            }else {
                wormsStack.push(wormsStack.pop() - 3);
                if (wormsStack.peek() <= 0){
                    wormsStack.pop();
                }
                holesQueue.poll();
            }

        }


        System.out.println(matchesCount > 0 ? "Matches: " + matchesCount:"There are no matches.");
        System.out.println(wormsStack.isEmpty()? "Every worm found a suitable hole!": "Worms left: "  );





    }
}

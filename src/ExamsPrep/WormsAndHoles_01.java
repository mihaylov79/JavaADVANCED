package ExamsPrep;

import java.util.*;
import java.util.stream.Collectors;

public class WormsAndHoles_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

       Stack<Integer> wormsStack = new Stack<>();


        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(wormsStack::push);
        Queue<Integer> holesQueue =Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));



        int matchesCount = 0;
        int wormsSize = wormsStack.size();


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

        if (matchesCount !=wormsSize){

            System.out.println( !wormsStack.isEmpty() ?"Worms left: " + String.join(", ",wormsStack.toString().replaceAll("[\\[\\]]","")):"Worms left: none");

        }else {
            System.out.println("Every worm found a suitable hole!");
        }
        System.out.println("Holes left: " + (!holesQueue.isEmpty() ? String.join(", ", holesQueue.toString()
                .replaceAll("[\\[\\]]", "")) : "none"));






    }
}

package ExamsPrep;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<Integer> toolsQueue = new ArrayDeque<>();
        Deque<Integer> substancesStack = new ArrayDeque<>();

        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(toolsQueue::offer);
        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(substancesStack::push);
        List<Integer> chalenges = Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());


        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty() && !chalenges.isEmpty()){

            int tool = toolsQueue.peek();
            int substance = substancesStack.peek();
            int use = tool * substance;
            if (chalenges.contains(use)){
                toolsQueue.poll();
                substancesStack.pop();
                chalenges.remove(chalenges.indexOf(use));

                if (chalenges.isEmpty()){
                    System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                    break;
                }
            }else {
                toolsQueue.offer(toolsQueue.poll() + 1);
                if (substancesStack.peek() -1 <= 0){
                    substancesStack.pop();
                }else {
                    substancesStack.push(substancesStack.pop() - 1);
                }

                if (toolsQueue.isEmpty() || substancesStack.isEmpty()){
                    System.out.println("Harry is lost in the temple. Oblivion awaits him.");
                    break;
                }
            }

        }



//        if ((toolsQueue.isEmpty() || substancesStack.isEmpty()) && !chalenges.isEmpty()){
//
//            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
//
//            PrintNonEmptySequences(toolsQueue, substancesStack);
//
//            System.out.println("Challenges: " + String.join(", ",chalenges.toString().replaceAll("[\\[\\]]","")));
//
//        } else {
//
//            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
//
//            PrintNonEmptySequences(toolsQueue,substancesStack);
//
//        }

        if (!toolsQueue.isEmpty()){
            // toolsQueue.forEach(t->System.out.print("Tools: "+ t));
            System.out.println("Tools: " + String.join(", ", toolsQueue.toString().replaceAll("[\\[\\]]","")));
            //System.out.println();
        }

        if (!substancesStack.isEmpty()){

            System.out.println("Substances: " + String.join(", ", substancesStack.toString().replaceAll("[\\[\\]]","")));

        }

        if (!chalenges.isEmpty()){
            System.out.println("Challenges: " + String.join(", ",chalenges.toString().replaceAll("[\\[\\]]","")));
        }



    }

//    private static void PrintNonEmptySequences(Deque<Integer> toolsQueue, Deque<Integer> substancesStack) {
//        if (!toolsQueue.isEmpty()){
//           // toolsQueue.forEach(t->System.out.print("Tools: "+ t));
//            System.out.println("Tools: " + String.join(", ", toolsQueue.toString().replaceAll("[\\[\\]]","")));
//
//        }else {
//            //substancesStack.forEach(s->System.out.print("Substances: " + s));
//            System.out.println("Substances: " + String.join(", ", substancesStack.toString().replaceAll("[\\[\\]]","")));
//
//        }
//    }
}

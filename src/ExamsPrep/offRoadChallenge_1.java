package ExamsPrep;

import java.util.*;

public class offRoadChallenge_1 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<Integer>fuelStack = new ArrayDeque<>();
        Deque<Integer>consumptionQueue = new ArrayDeque<>();
        Deque<Integer>fuelNeededQueue = new ArrayDeque<>();
        Set<String>altitudes = new LinkedHashSet<>();

        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(fuelStack::push);
        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(consumptionQueue::offer);
        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(fuelNeededQueue::offer);

        int altitudeCounter = 0;

        while (!fuelNeededQueue.isEmpty()){

            int fuel = fuelStack.peek();
            int consumption = consumptionQueue.peek();
            int fuelNeeded = fuelNeededQueue.peek();

            if (fuel - consumption >= fuelNeeded){
                fuelStack.pop();
                consumptionQueue.poll();
                fuelNeededQueue.poll();
                altitudeCounter++;
                altitudes.add("Altitude " + altitudeCounter);

                System.out.printf("John has reached: Altitude %d%n",altitudeCounter);
            }else {

                System.out.printf("John did not reach: Altitude %d%n",altitudeCounter + 1);
                System.out.println("John failed to reach the top.");
                if (altitudeCounter > 0){
                    System.out.print("Reached altitudes: ");
                    System.out.print(String.join(",",altitudes.toString()).replaceAll("[\\[\\]]",""));
                    return;
                }else {
                    System.out.println("John didn't reach any altitude.");
                    return;
                }
            }


        }

        System.out.println("John has reached all the altitudes and managed to reach the top!");

    }
}

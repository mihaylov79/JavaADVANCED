package ExamsPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonstersExtermination_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<Integer> monstersArmorQueue = new ArrayDeque<>();
        Deque<Integer> soldierStrikeStack = new ArrayDeque<>();

        Arrays.stream(kbInput.nextLine().split(",")).map(Integer::parseInt).forEach(monstersArmorQueue::offer);
        Arrays.stream(kbInput.nextLine().split(",")).map(Integer::parseInt).forEach(soldierStrikeStack::push);

        int monsterskilled = 0;
        while (!monstersArmorQueue.isEmpty() && !soldierStrikeStack.isEmpty()){

            int strike = soldierStrikeStack.peek();
            int armor = monstersArmorQueue.peek();

            if (strike == armor){
                soldierStrikeStack.pop();
                monstersArmorQueue.poll();
                monsterskilled++;

            } else if (strike > armor) {

                int remainingImpactPow = soldierStrikeStack.pop() - monstersArmorQueue.peek();

                if (soldierStrikeStack.isEmpty()){

                    soldierStrikeStack.push(remainingImpactPow);
                    monstersArmorQueue.poll();
                    monsterskilled++;
                }else {
                    soldierStrikeStack.push(soldierStrikeStack.pop() + remainingImpactPow);
                    monstersArmorQueue.poll();
                    monsterskilled++;

                }


            }else {
                int remainingArmor = monstersArmorQueue.poll() - soldierStrikeStack.peek();
                monstersArmorQueue.offer(remainingArmor);
                soldierStrikeStack.pop();
            }
        }

        if (monstersArmorQueue.isEmpty()){
            System.out.println("All monsters have been killed!");
        }
        if (soldierStrikeStack.isEmpty()){
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d",monsterskilled);


    }
}

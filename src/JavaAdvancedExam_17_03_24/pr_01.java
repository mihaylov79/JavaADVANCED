package JavaAdvancedExam_17_03_24;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class pr_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<Integer> moneyStack = new ArrayDeque<>();
        Deque<Integer> pricesQueue = new ArrayDeque<>();

        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(moneyStack::push);
        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(pricesQueue::offer);

        int foodCounter = 0;
        int foodAvailable = pricesQueue.size();

       while (!moneyStack.isEmpty() && !pricesQueue.isEmpty()){

           int money = moneyStack.peek();
           int prices = pricesQueue.peek();

           if (money == prices){
               moneyStack.pop();
               pricesQueue.poll();
               foodCounter++;
           } else if (money > prices) {
               moneyStack.pop();
               if (!moneyStack.isEmpty()){
                   moneyStack.push(moneyStack.pop() + (money - prices));
               }
               pricesQueue.poll();
               foodCounter++;
           } else {
               moneyStack.pop();
               pricesQueue.poll();
           }
       }
       if (foodCounter == foodAvailable){
           System.out.printf("Gluttony of the day! Henry ate %d foods.",foodCounter);
       }else {
           System.out.printf(foodCounter == 0 ? "Henry remained hungry. He will try next weekend again." : foodCounter == 1 ? "Henry ate: %d food." : "Henry ate: %d foods.",foodCounter,foodCounter );
       }
    }
}

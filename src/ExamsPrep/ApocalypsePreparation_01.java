package ExamsPrep;

import java.util.*;

public class ApocalypsePreparation_01 {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        Deque<Integer>textilesQueue = new ArrayDeque<>();
        Deque<Integer>medicamentStack = new ArrayDeque<>();

        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(textilesQueue::offer);
        Arrays.stream(kbInput.nextLine().split("\\s+")).map(Integer::parseInt).forEach(medicamentStack::push);

        Map<String, Integer > items = new HashMap<>();
        items.put("Patch", 0);
        items.put("Bandage", 0);
        items.put("MedKit", 0);


        while (!textilesQueue.isEmpty() && !medicamentStack.isEmpty()){

            int textile = textilesQueue.peek();
            int med = medicamentStack.peek();
            int combined = textile + med;

            if (combined == 30){
                textilesQueue.poll();
                medicamentStack.pop();
                items.replace("Patch",items.get("Patch") + 1);

            } else if (combined == 40) {
                textilesQueue.poll();
                medicamentStack.pop();
                items.replace("Bandage",items.get("Bandage") + 1);

            } else if (combined == 100) {
                textilesQueue.poll();
                medicamentStack.pop();
                items.replace("MedKit",items.get("MedKit") + 1);
            } else if (combined > 100) {
                textilesQueue.poll();
                medicamentStack.pop();
                medicamentStack.push(medicamentStack.pop() + (combined - 100));
                items.replace("MedKit",items.get("MedKit") + 1);
            }else {
                textilesQueue.poll();
                medicamentStack.push(medicamentStack.pop() + 10);
            }
        }

        System.out.println((textilesQueue.isEmpty() && medicamentStack.isEmpty()) ? "Textiles and medicaments are both empty.":
                                                    textilesQueue.isEmpty() ? "Textiles are empty.": "Medicaments are empty."  );




        if (!items.isEmpty()){
            items.entrySet().stream().filter(e -> e.getValue() > 0).sorted(Comparator.comparing(Map.Entry<String ,Integer>::getValue)
                    .reversed().thenComparing(Map.Entry::getKey)).forEach((e1 -> System.out.printf("%s - %d%n",e1.getKey(),e1.getValue())));
        }

        if (!medicamentStack.isEmpty()){
            System.out.println("Medicaments left: " + String.join(", ",medicamentStack.toString().replaceAll("[\\[\\]]","")));
        }
        if (!textilesQueue.isEmpty()){
            System.out.println("Textiles left: " + String.join(", ",textilesQueue.toString().replaceAll("[\\[\\]]","")));
        }

    }

}

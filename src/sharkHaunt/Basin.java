package sharkHaunt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basin {

    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark){
        if (capacity > sharks.size()){
            sharks.add(shark);
        }else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public String getName() {
        return name;
    }

    public boolean removeShark(String kind){

        return sharks.removeIf(s ->s.getKind().equals(kind));
    }

    public Shark getLargestShark(){

        return sharks.stream().max(Comparator.comparing(Shark::getLength)).orElse(null);
    }

    public Shark getShark(String kind){

        return sharks.stream().filter(s -> s.getKind().equals(kind)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.sharks.size();
    }

    public int getAverageLength(){
        return (int) sharks.stream().mapToInt(Shark::getLength).average().orElse(0);
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Sharks in ").append(getName()).append(":");
        sb.append(System.lineSeparator());
        sharks.forEach(s ->sb.append(String.format("The %s is %d centimeters long, eats %s and inhabits %s.",s.getKind(),s.getLength(),s.getFood(),s.getHabitation()))
                .append(String.format(System.lineSeparator())));
        return sb.toString().trim();
    }







}

package fishingPond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Pond {

    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity){
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish){

        if (this.capacity > this.fishes.size()){

            this.fishes.add(fish);
        }
    }

    public boolean removeFish(String species){

        return this.fishes.removeIf(fish -> fish.getSpecies().equals(species));
    }

    public Fish getOldestFish(){
       return fishes.stream().max(Comparator.comparing(Fish::getAge)).orElse(null);
    }

    public Fish getFish(String species){
        return fishes.stream().filter(f -> f.getSpecies().equals(species)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.fishes.size();
    }

    public int getVacancies(){
        return capacity - getCount();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Fishes in the pond:");
        sb.append(System.lineSeparator());
        fishes.forEach(fish -> sb.append(fish.toString()).append(String.format(System.lineSeparator())));

        return sb.toString().trim();
    }


}

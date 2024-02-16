package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {

    private int capacity;
    private List<Animal> data;


    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal){

        if (this.capacity > this.data.size()){
            data.add(animal);
        }
    }

    public boolean remove(String name){
        return this.data.removeIf(a-> a.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker){

        return this.data.stream().filter(a-> a.getName().equals(name)).
                filter(a-> a.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }

    public Animal getOldestAnimal(){
        return this.data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }

    public int getCount(){
        return  this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:");
        sb.append(System.lineSeparator());
        data.forEach(a-> sb.append(String.format(a.getName() + " " + a.getCaretaker())).append(String.format(System.lineSeparator())));
        return sb.toString().trim();
    }
}

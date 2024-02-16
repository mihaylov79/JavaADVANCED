package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName(String name){
        return this.name;
    }
    public int  getCapacity(int capacity){
        return this.capacity;
    }

    public void add(Parrot parrot){
        if (this.capacity > this.data.size()){
            this.data.add(parrot);
        }
    }
    public boolean remove(String name){

        return data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name){

        Parrot parrot = data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);

        if (null != parrot)
            parrot.setAvailable(false);

        return parrot;

    }

    public List<Parrot>sellParrotBySpecies(String species){

        List<Parrot> parrotsBySpecies = data.stream().filter(p -> p.getSpecies().equals(species)).collect(Collectors.toList());

        parrotsBySpecies.forEach(parrot -> parrot.setAvailable(false));

        return parrotsBySpecies;
    }
    
    public int getCount(){
        return this.data.size();
    }
    
    public String report(){
        List<Parrot> availableParrots = data.stream().filter(Parrot::isAvailable).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(getName(name)).append(":");
        sb.append(System.lineSeparator());
        availableParrots.forEach(parrot -> sb.append(parrot.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}

package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child){
        boolean isValid = false;
        if (this.capacity > this.registry.size()){
            registry.add(child);
            isValid = true;
        }
        return isValid;
    }

    public boolean removeChild(String firstName){

       return registry.removeIf(child -> child.getFirstName().equals(firstName));
    }

    public int getChildrenCount(){
        return this.registry.size();
    }

    public Child getChild(String firstname){

        return registry.stream().filter(c-> c.getFirstName().equals(firstname)).findFirst().orElse(null);
    }

    public String registryReport(){

        StringBuilder sb = new StringBuilder();
        sb.append("Registered children in ").append(this.name).append(":");
        registry.stream().sorted(Comparator.comparing(Child::getAge).
                        thenComparing(Child::getFirstName).thenComparing(Child::getLastName)).
                        forEach(child -> sb.append(String.format(System.lineSeparator())).append("--").append(String.format(System.lineSeparator())).append(child.toString()));
        return sb.toString().trim();

    }
}

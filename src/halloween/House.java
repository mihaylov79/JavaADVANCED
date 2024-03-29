package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {

    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid){
        if (this.capacity > this.data.size()){
            data.add(kid);
        }
    }

    public boolean removeKid(String name){
        return data.removeIf(kid -> kid.getName().equals(name));
    }

    public Kid getKid(String street){
        return data.stream().filter(kid -> kid.getStreet().equals(street)).findFirst().orElse(null);
    }
    public int getAllKids(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:");
        sb.append(System.lineSeparator());
        data.forEach(c -> sb.append(String.format("%s from %s street",c.getName(),c.getStreet())).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}

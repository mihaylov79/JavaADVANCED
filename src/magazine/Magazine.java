package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity){

        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth){
        if (capacity > data.size()){
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color){
        return data.removeIf(c ->c.getColor().equals(color));

    }

    public Cloth getSmallestCloth(){

        return this.data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);
    }

    public Cloth getCloth(String color){

        return this.data.stream().filter(c -> c.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount(){

        return this.data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.type).append(" magazine contains:");
        sb.append(System.lineSeparator());
        data.forEach(c-> sb.append(c.toString()).append(String.format(System.lineSeparator())));
        return sb.toString().trim();
    }

}

package vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink>drinks;


    public VendingMachine(int buttonCapacity){
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount(){
        return this.drinks.size();
    }

    public void addDrink(Drink drink){

        if (this.buttonCapacity > this.drinks.size()){
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name){

       return this.drinks.removeIf(d -> d.getName().equals(name));
    }

    public Drink getLongest(){

        return this.drinks.stream().max(Comparator.comparing(Drink::getVolume)).orElse(null);
    }

    public Drink getCheapest(){

        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }

    public String buyDrink(String name){
       Drink drink = this.drinks.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
        assert drink != null;
        return drink.toString();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Drinks available:");
        sb.append(System.lineSeparator());
        drinks.forEach(drink -> sb.append(drink.toString()).append(String.format(System.lineSeparator())));
        return sb.toString().trim();
    }

}

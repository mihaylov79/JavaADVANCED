package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity){
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){

        if (capacity > vehicles.size()){
            this.vehicles.add(vehicle);
        }
    }
    public boolean removeVehicle(String vin){
        return vehicles.removeIf(vehicle -> vehicle.getVIN().equals(vin));
    }

    public int getCount(){
        return vehicles.size();
    }
    public Vehicle getLowestMileage(){

        return vehicles.stream().min(Comparator.comparing(Vehicle::getMileage)).orElse(null);
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:");
        sb.append(System.lineSeparator());
        vehicles.forEach(vehicle -> sb.append(vehicle.toString()).append(String.format(System.lineSeparator())));
        return sb.toString();
    }
}

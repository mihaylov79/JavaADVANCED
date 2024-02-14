package automotiveRepairShop;

public class Vehicle {

    private String VIN;
    private int mileage;
    private String damage;

    public Vehicle(String VIN,int mileage,String damage){
        this.VIN = VIN;
        this.mileage = mileage;
        this.damage = damage;
    }

    public String getVIN() {
        return this.VIN;
    }

    public int getMileage() {
        return this.mileage;
    }

    public String getDamage() {
        return this.damage;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return String.format("Damage: %s, Vehicle: %s (%d km)",this.damage,this.VIN,this.mileage);
    }
}

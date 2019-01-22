package h_Vehicle08;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumptionInLitersPerKm;

    protected VehicleImpl(Double fuelQuantity, Double fuelConsumptionInLitersPerKm) {
        this.fuelQuantity = fuelQuantity;
        setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm);
    }

    @Override
    public String drive(double distance){
        DecimalFormat df = new DecimalFormat("#.################");
        if (distance * this.fuelConsumptionInLitersPerKm <= this.fuelQuantity){
            this.fuelQuantity -= distance*this.fuelConsumptionInLitersPerKm;
            return String.format("%s travelled %s km", this.getClass().getSimpleName(),df.format(distance));
        }
        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }

    public void setFuelConsumptionInLitersPerKm(Double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    @Override
    public void refuel(double liters){
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity));
        return sb.toString();
    }
}

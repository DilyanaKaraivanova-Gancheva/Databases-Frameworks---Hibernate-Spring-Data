package h_Vehicle08;

public class Truck extends VehicleImpl {
    public Truck(Double fuelQuantity, Double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    public void setFuelConsumptionInLitersPerKm(Double fuelConsumptionInLitersPerKm) {
        super.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm + 1.6);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}

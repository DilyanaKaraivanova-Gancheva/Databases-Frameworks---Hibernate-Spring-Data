package h_Vehicle08;

public class Car extends VehicleImpl{
    public Car(Double fuelQuantity, Double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    public void setFuelConsumptionInLitersPerKm(Double fuelConsumptionInLitersPerKm) {
        super.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm + 0.9);
    }
}

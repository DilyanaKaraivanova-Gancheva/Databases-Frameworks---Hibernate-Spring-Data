package app.dtos.views;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarsPartsView implements Serializable{
    @Expose
    private CarView car;

    @Expose
    private List<PartView> parts;

    public CarsPartsView() {
        this.parts = new ArrayList<>();
    }

    public CarView getCar() {
        return car;
    }

    public void setCar(CarView car) {
        this.car = car;
    }

    public List<PartView> getParts() {
        return parts;
    }

    public void setParts(List<PartView> parts) {
        this.parts = parts;
    }
}

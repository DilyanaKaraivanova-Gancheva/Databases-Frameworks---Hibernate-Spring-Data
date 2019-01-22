package app.dto.view;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class UserView {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private List<SoldProductView> soldProducts;

    public UserView() {
        this.soldProducts = new ArrayList<>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SoldProductView> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductView> soldProducts) {
        this.soldProducts = soldProducts;
    }
}

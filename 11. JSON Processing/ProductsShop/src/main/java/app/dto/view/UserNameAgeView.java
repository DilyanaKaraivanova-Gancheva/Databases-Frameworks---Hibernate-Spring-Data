package app.dto.view;

import com.google.gson.annotations.Expose;

public class UserNameAgeView implements Comparable<UserNameAgeView> {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    @Expose
    private SoldProductsView soldProducts;

    public UserNameAgeView() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SoldProductsView getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsView soldProducts) {
        this.soldProducts = soldProducts;
    }

    @Override
    public int compareTo(UserNameAgeView o) {
        int comp = Integer.compare(o.getSoldProducts().getCount(), this.getSoldProducts().getCount());
        if (comp == 0) {
            comp = this.getLastName().compareTo(o.getLastName());
        }
        return comp;
    }
}

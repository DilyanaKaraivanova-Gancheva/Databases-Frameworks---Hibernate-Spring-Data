package Exercises.f_ShoppingSpree06;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        if (cost<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
}

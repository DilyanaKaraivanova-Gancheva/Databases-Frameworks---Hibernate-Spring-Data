package Exercises.f_ShoppingSpree06;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<String> bagOfProducts;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.bagOfProducts = new LinkedList<>();
    }
    public double getMoney() {
        return money;
    }

    public void addProduct(String name, double cost){
        this.bagOfProducts.add(name);
        this.money -= cost;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<String> getBagOfProducts() {
        return Collections.unmodifiableList(this.bagOfProducts);
    }
}

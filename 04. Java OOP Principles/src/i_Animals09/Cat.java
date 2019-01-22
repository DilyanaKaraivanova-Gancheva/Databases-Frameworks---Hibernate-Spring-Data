package i_Animals09;

public class Cat extends Animal {
    Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
       return "MiauMiau";
    }
}

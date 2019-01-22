package i_Animals09;

public class Dog extends Animal {
    Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
       return "BauBau";
    }
}

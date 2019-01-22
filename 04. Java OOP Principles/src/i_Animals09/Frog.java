package i_Animals09;

public class Frog extends Animal {
    Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
       return "Frogggg";
    }
}

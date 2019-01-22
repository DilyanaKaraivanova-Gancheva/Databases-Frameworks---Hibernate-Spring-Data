package i_Animals09;

public class Kitten extends Cat {
    Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
       return "Miau";
    }

}

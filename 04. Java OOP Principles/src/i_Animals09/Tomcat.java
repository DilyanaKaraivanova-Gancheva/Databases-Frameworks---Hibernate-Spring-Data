package i_Animals09;

public class Tomcat extends Cat {
    Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }

}

package f_BirthdayCelebrations06;

public class Pet implements Birthable {
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthDate() {
        return this.birthdate;
    }
}

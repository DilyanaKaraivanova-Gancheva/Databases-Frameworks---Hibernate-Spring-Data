package i_Animals09;

public  abstract class Animal {
    public static final String MESSAGE = "Invalid input!";
    private String name;
    private int age;
    private String gender;

    protected Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String produceSound(){
       return "Not implemented!";
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(MESSAGE);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException(MESSAGE);
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()){
            throw new IllegalArgumentException(MESSAGE);
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(String.format("%s %d %s",this.name,this.age,this.gender));
        sb.append(System.lineSeparator());
        sb.append(produceSound());
        return sb.toString();
    }
}

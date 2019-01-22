package g_Mankind07;

public abstract class HumanImpl implements Human {
    private String firstName;
    private String lastName;

    protected HumanImpl(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    @Override
    public void setFirstName(String firstName) {
        if (!Character.isUpperCase(firstName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        else if (firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        if (!Character.isUpperCase(lastName.charAt(0))){
        throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        else if (lastName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: " + this.firstName).append(System.lineSeparator());
        sb.append("Last Name: " + this.lastName).append(System.lineSeparator());
        return sb.toString();
    }
}

package d_Telephony04;

public class Smartphone implements Callable, Browseable {
    private String[] phoneNumbers;
    private String[] websites;

    public Smartphone(String[] phoneNumbers, String[] websites) {
        this.phoneNumbers = phoneNumbers;
        this.websites = websites;
    }

    @Override
    public String callingPhones() {
        StringBuilder sb = new StringBuilder();
        for (String phoneNumber : this.phoneNumbers) {
            if (phoneNumber.matches("^[\\d]+$")){
                sb.append("Calling... ").append(phoneNumber);
            }
            else{
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String browseSite() {
        StringBuilder sb = new StringBuilder();
        for (String website : this.websites) {
            if (website.matches("(.*\\d.*)")){
                sb.append("Invalid URL!");
            }
            else{
                sb.append("Browsing: ").append(website).append("!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.callingPhones() + this.browseSite();
    }
}

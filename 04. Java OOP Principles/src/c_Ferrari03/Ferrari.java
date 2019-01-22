package c_Ferrari03;

public class Ferrari implements Car {
    private  static final String  MODEL = "488-Spider";
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",MODEL,this.useBrakes(),this.pushGasPedal(),this.driver);
    }
}

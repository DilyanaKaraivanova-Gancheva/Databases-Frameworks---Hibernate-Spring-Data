package Exercises.d_NumberInReversedOrder04;

public class DecimalNumber {
    private String number;

    public DecimalNumber(String  number) {
        this.number = number;
    }

    public void printDigits(){
        StringBuilder sb = new StringBuilder(number);
        sb.reverse();
        System.out.println(sb.toString());
    }
}

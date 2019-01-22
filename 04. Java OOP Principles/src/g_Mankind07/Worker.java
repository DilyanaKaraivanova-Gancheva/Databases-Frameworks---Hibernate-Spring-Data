package g_Mankind07;

public class Worker extends HumanImpl{
    private Double weekSalary;
    private Double workHoursPerDay;

    public Worker(String firstName, String lastName, Double weekSalary, Double workHoursPerDay) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(Double weekSalary) {
        if (weekSalary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(Double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private Double salaryPerHour(){
       return this.weekSalary/7/this.workHoursPerDay;
    }



    @Override
    public void setLastName(String lastName) {
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("Week Salary: %.2f",this.weekSalary)).append(System.lineSeparator());
        sb.append(String.format("Hours per day: %.2f",this.workHoursPerDay)).append(System.lineSeparator());
        sb.append(String.format("Salary per hour: %.2f",salaryPerHour())).append(System.lineSeparator());
        return sb.toString();
    }
}

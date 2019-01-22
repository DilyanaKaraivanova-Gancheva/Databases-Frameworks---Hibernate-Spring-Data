package auto.mapping.lab.models;

import java.util.List;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private List<EmployeeDto> workers;

    public ManagerDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<EmployeeDto> getWorkers() {
        return workers;
    }

    public void setWorkers(List<EmployeeDto> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s | Employees: %d%n",this.firstName,this.lastName,this.workers.size()));
        for (EmployeeDto worker : workers) {
            sb.append(worker);
        }
        return sb.toString().trim();
    }
}

package auto.mapping.lab;

import auto.mapping.lab.models.EmployeeDto;
import auto.mapping.lab.models.ManagerDto;
import auto.mapping.lab.models.entities.Employee;
import auto.mapping.lab.repositories.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Transactional
public class ConsoleRunner implements CommandLineRunner {
    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public ConsoleRunner(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {

    }

    public void simpleMapping(){
        Employee employee = this.employeeRepo.getOne(2L);
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
    }

    public void advancedMapping(){
        List<Employee> employees = this.employeeRepo.findAll();
        List<ManagerDto> managerDtos = employees.stream()
                .map(e -> modelMapper.map(e, ManagerDto.class))
                .collect(Collectors.toList());
        for (ManagerDto managerDto : managerDtos) {
            System.out.println(managerDto);
        }
    }

    public void projection() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        /*List<Employee> employeeList = new ArrayList<>();
        Employee em = new Employee();
        em.setFirstName("Anelia");
        em.setLastName("Doychinova");
        em.setBirthday(df.parse("1990-10-07"));
        employeeList.add(em);

        Employee em1 = new Employee();
        em1.setFirstName("Kont");
        em1.setLastName("Marokov");
        em1.setBirthday(df.parse("1988-10-07"));
        em1.setManager(em);
        employeeList.add(em1);

        this.employeeRepo.saveAll(employeeList);*/

        Date date = df.parse("1990-01-01");
        List<Employee> employees = this.employeeRepo.findAllByBirthdayBeforeOrderBySalaryDesc(date);
        TypeMap<Employee, EmployeeDto> typeMap = modelMapper.createTypeMap(Employee.class, EmployeeDto.class);
        typeMap.addMappings(m -> m.map(src -> src.getManager().getLastName(), EmployeeDto::setManagerLastName));

        List<EmployeeDto> employeeDtos = employees.stream()
                .map(e -> typeMap.map(e))
                .collect(Collectors.toList());
        for (EmployeeDto e : employeeDtos) {
            System.out.printf("%s %s %.2f – Manager: %s%n",e.getFirstName(),e.getLastName(),e.getSalary(),
                    e.getManagerLastName() == null? "[no manager]":e.getManagerLastName());
        }
    }
}

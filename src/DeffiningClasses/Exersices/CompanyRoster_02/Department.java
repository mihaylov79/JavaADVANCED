package DeffiningClasses.Exersices.CompanyRoster_02;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employeeList;

    public Department(String name, List<Employee> employeeList){
        this.name = name;
        this.employeeList = new ArrayList<>();

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public double getAvgSalary(){

        return employeeList.stream().mapToDouble(Employee::getSalary).
                average().orElse(0.0);


    }

}


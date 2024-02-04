package DeffiningClasses.Exersices.CompanyRoster_02;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }
}





//Define a class Employee that holds the following information: name, salary, position, department, email, and age.
// The name, salary, position, and department are mandatory, while the rest are optional.
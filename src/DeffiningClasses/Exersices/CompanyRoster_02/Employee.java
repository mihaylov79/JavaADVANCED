package DeffiningClasses.Exersices.CompanyRoster_02;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;


//    public Employee(String name, double salary, String position, String department) {
//        this(name,salary,position,department, -1);
//    }
//
//    public Employee(String name, double salary, String position, String department, int age) {
//        this(name, salary, position, department, "n/a", age);
//    }
//
//    public Employee(String name, double salary, String position, String department, String email) {
//        this(name, salary, position, department,email, -1);
//    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getPosition(){
        return this.position;
    }
    public String getDepartment(){
        return this.department;
    }
    public String getEmail(){
    return this.email;
    }
    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", getName(), getSalary(), getEmail(), getAge());
    }
}





//Define a class Employee that holds the following information: name, salary, position, department, email, and age.
// The name, salary, position, and department are mandatory, while the rest are optional.
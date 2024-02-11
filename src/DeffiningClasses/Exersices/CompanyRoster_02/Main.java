package DeffiningClasses.Exersices.CompanyRoster_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kbInput = new Scanner(System.in);

        int n = Integer.parseInt(kbInput.nextLine());

        Map<String, List<Employee>> departments = new HashMap<>();


        //Department departments = new Department(deaprtment, List<Employee>empplyeelist);


        for (int i = 0; i < n; i++) {
            String[] inputInfo = kbInput.nextLine().split("\\s+");
            String name = inputInfo[0];
            double salary = Double.parseDouble(inputInfo[1]);
            String position = inputInfo[2];
            String department = inputInfo[3];
            String email =  inputInfo.length > 4 && !(inputInfo[4].matches("\\d+")) ? inputInfo[4] : "n/a";
            int age  = (inputInfo.length == 5 && inputInfo[4].matches("\\d+")) ? Integer.parseInt(inputInfo[4]):(inputInfo.length == 6 && inputInfo[5].matches("\\d+")) ? Integer.parseInt(inputInfo[5]) : -1 ;

            Employee employee = new Employee(name,salary,position,department,email,age);

            departments.computeIfAbsent(department,Department -> new ArrayList<>()).add(employee);

        }




    }
}

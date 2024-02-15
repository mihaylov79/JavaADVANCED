package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity(int capacity){
        return this.capacity;
    }

    public int getCount(){
        return this.data.size();
    }

    public String insert(Student student){
        String statement;
        if (this.capacity > this.data.size()){
            if (this.data.contains(student)){
                statement = "Student is already in the hall.";
            }else {
                this.data.add(student);
                statement = String.format("Added student %s %s.",student.getFirstName(),student.getLastName());
            }
        }else {
            statement = "The hall is full.";
        }
        return statement;
    }

    public String remove(Student student){
        String statement;
        if (this.data.contains(student)){
            statement= String.format("Removed student %s %s.",student.getFirstName(),student.getLastName());
            this.data.remove(student);

        }else {
            statement = "Student not found.";
        }
        return statement;
    }

    public Student getStudent(String firstName, String lastName){

        return this.data.stream().filter(c -> c.getFirstName().equals(firstName)).
                filter(c-> c.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(getCount());
        sb.append(System.lineSeparator());
        data.forEach(s-> sb.append(s.toString()).append(String.format(System.lineSeparator())));
        return sb.toString().trim();
    }
}

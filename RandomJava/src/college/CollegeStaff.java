package RandomJava.src.college;

public class CollegeStaff {
    // Instance variables
    private String name;
    private String designation;
    private double salary;
    private String department;
    // Constructor
    public CollegeStaff(String name, String designation, double salary, String department) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.department = department;
    }
    // Getter and Setter methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}

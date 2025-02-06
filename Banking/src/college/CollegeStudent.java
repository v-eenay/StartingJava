package college;

public class CollegeStudent {
    // Instance variables
    private String name;
    private String studentID;
    private String department;
    private int yearOfStudy;
    private String course;
    private int feesPaid;
    private int feesDue;
    // Constructor
    public CollegeStudent(String name, String studentID, String department, int yearOfStudy, String course, int feesPaid, int feesDue) {
        this.name = name;
        this.studentID = studentID;
        this.department = department;
        this.yearOfStudy = yearOfStudy;
        this.course = course;
        this.feesPaid = feesPaid;
        this.feesDue = feesDue;
    }
    // Getter and Setter methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getYearOfStudy() {
        return yearOfStudy;
    }
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public int getFeesPaid() {
        return feesPaid;
    }
    public void setFeesPaid(int feesPaid) {
        this.feesPaid = feesPaid;
    }
    public int getFeesDue() {
        return feesDue;
    }
    public void setFeesDue(int feesDue) {
        this.feesDue = feesDue;
    }
}

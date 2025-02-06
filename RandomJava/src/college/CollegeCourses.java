package RandomJava.src.college;

public class CollegeCourses {
    private String courseName;
    private int courseCode;
    private int courseCredit;
    private int courseDuration;
    private int courseFee;
// Constructor
    public CollegeCourses(String courseName, int courseCode, int courseCredit, int courseDuration, int courseFee) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
        this.courseDuration = courseDuration;
        this.courseFee = courseFee;
    }
// Getter and Setter methods
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }
    public int getCourseCredit() {
        return courseCredit;
    }
    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }
    public int getCourseDuration() {
        return courseDuration;
    }
    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }
    public int getCourseFee() {
        return courseFee;
    }
}

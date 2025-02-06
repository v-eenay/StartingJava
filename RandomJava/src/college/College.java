package RandomJava.src.college;

import java.util.Scanner;

public class College {
    public static void main(String[] args) {
        College college = new College();
        college.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello Welcome to College! Please select an option:");
        System.out.println("1. Student");
        System.out.println("2. Staff");
        System.out.println("3. Courses");
        System.out.println("4. Exit");
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Student Name: ");
                    String name = scanner.next();
                    System.out.println("Enter Student ID: ");
                    String studentID = scanner.next();
                    System.out.println("Enter Department: ");
                    String department = scanner.next();
                    System.out.println("Enter Year of Study: ");
                    int yearOfStudy = scanner.nextInt();
                    System.out.println("Enter Course: ");
                    String studentCourse = scanner.next();
                    System.out.println("Enter Fees Paid: ");
                    int feesPaid = scanner.nextInt();
                    System.out.println("Enter Fees Due: ");
                    int feesDue = scanner.nextInt();
                    CollegeStudent student = new CollegeStudent(name, studentID, department, yearOfStudy, studentCourse,
                            feesPaid, feesDue);
                    System.out.println("Student Name: " + student.getName());
                    System.out.println("Student ID: " + student.getStudentID());
                    System.out.println("Department: " + student.getDepartment());
                    System.out.println("Year of Study: " + student.getYearOfStudy());
                    System.out.println("Course: " + student.getCourse());
                    System.out.println("Fees Paid: " + student.getFeesPaid());
                    System.out.println("Fees Due: " + student.getFeesDue());
                    break;
                case 2:
                    System.out.println("Enter Staff Name: ");
                    String staffName = scanner.next();
                    System.out.println("Enter Designation: ");
                    String designation = scanner.next();
                    System.out.println("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.println("Enter Department: ");
                    String staffDepartment = scanner.next();
                    CollegeStaff staff = new CollegeStaff(staffName, designation, salary, staffDepartment);
                    System.out.println("Staff Name: " + staff.getName());
                    System.out.println("Designation: " + staff.getDesignation());
                    System.out.println("Salary: " + staff.getSalary());
                    System.out.println("Department: " + staff.getDepartment());
                    break;
                case 3:
                    System.out.println("Enter Course Name: ");
                    String courseName = scanner.next();
                    System.out.println("Enter Course Code: ");
                    int courseCode = scanner.nextInt();
                    System.out.println("Enter Course Credit: ");
                    int courseCredit = scanner.nextInt();
                    System.out.println("Enter Course Duration: ");
                    int courseDuration = scanner.nextInt();
                    System.out.println("Enter Course Fee: ");
                    int courseFee = scanner.nextInt();
                    CollegeCourses course = new CollegeCourses(courseName, courseCode, courseCredit, courseDuration,
                            courseFee);
                    System.out.println("Course Name: " + course.getCourseName());
                    System.out.println("Course Code: " + course.getCourseCode());
                    System.out.println("Course Credit: " + course.getCourseCredit());
                    System.out.println("Course Duration: " + course.getCourseDuration());
                    System.out.println("Course Fee: " + course.getCourseFee());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println("Do you want to continue? (y/n)");
            String continueChoice = scanner.next();
            if (continueChoice.equalsIgnoreCase("n")) {
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
            }
        }
    }
}

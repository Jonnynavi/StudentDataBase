import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private final String firstName;
    private final String lastName;
    private final int gradeYear;
    //5 digits with the first number being their grade level
    private final String studentID;
    private final List<String> enrolledCourses;
    private int tuitionBalance;
    //Its static because all course will cost the same
    private static final int costOfCourse = 600;
    //This will allow us to generate a unique id for each student
    private static int id = 1000;
    //A list of available classes
    private final String[] CLASSES = new String[]{"History 101", "Mathematics 101","English 101", "Chemistry 101", "Computer Science 101"};

    public Student(String firstName, String lastName, String gradeYear){
       this.firstName = capitalize(firstName);
        this.lastName = capitalize(lastName);
       this.gradeYear = Integer.parseInt(gradeYear);
       id++;
       this.studentID = gradeYear + id;
       this.enrolledCourses = new ArrayList<>();
    }

    public void enroll(String course){
        enrolledCourses.add(course);
        tuitionBalance+=costOfCourse;
    }

    public int getTuitionBalance() {
        return tuitionBalance;
    }

    public String[] getCLASSES(){
        return CLASSES;
    }

    public static int getid(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getCourses(){
        return enrolledCourses;
    }

    public void payBalance(int payment){
        tuitionBalance-=payment;
    }

    public String capitalize(String word){
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}

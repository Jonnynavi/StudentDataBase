import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String lines = "--------------";
        Scanner in = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        System.out.println("How many students do you want to enroll?");
        int numOfStudents = in.nextInt();

        for(int i = 0; i <numOfStudents; i++){
            registration(students);
        }
        System.out.println(lines.repeat(10));
        System.out.println("These students are now enrolled in their classes");
        for(Student student: students){
            System.out.println("\u2022  " + student.getFirstName() + " " + student.getLastName() + " | Balance: " + student.getTuitionBalance());
        }


    }


    private static void registration(List<Student> students) {
        String lines = "--------------";
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.print("Enter student first name: ");
            String firstName = in.nextLine();
            System.out.println(lines.repeat(10));
            System.out.print("Enter student last name: ");
            String lastName = in.nextLine();
            System.out.println(lines.repeat(10));
            String courses = """
                    1 - Freshmen
                    2 - Sophmore
                    3 - Junior
                    4 - Senior
                    Enter student class level: """;
            System.out.print(courses);
            String gradeYear = in.nextLine();
            System.out.println(lines.repeat(10));
            Student student = new Student(firstName, lastName, gradeYear);
            System.out.println("First name: " + student.getFirstName() + " | Last name: " + student.getLastName() + " | Grade year: " + gradeYear + " | Student ID: " + Student.getid());
            System.out.println(lines.repeat(10));
            students.add(student);
            enrollClasses(student);
            break;

        }
    }

    private static void enrollClasses(Student student){
        String lines = "--------------";
        Scanner in = new Scanner(System.in);
        List<String> classes = new LinkedList<String>(Arrays.asList(student.getCLASSES()));
        while(true){
            System.out.println("Please choose from a list of classes, enter 0 to quit once you're done");
            for(int i = 0; i <classes.size(); i++){
                System.out.println((i + 1) + " " + classes.get(i));
            }
            int num = in.nextInt();
            System.out.println(lines.repeat(10));
            int course = num - 1;
            try {
                if (num == 0) {
                    System.out.println("Enrolled classes: ");
                    for (String enrolled : student.getCourses()) {
                        System.out.println(enrolled);
                    }
                    break;
                } else {
                    student.enroll(classes.get(course));
                    classes.remove(course);

                }
            }catch (IndexOutOfBoundsException e){
                continue;
            }

        }

    }

}


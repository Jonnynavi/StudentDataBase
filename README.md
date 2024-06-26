# Student Database Application

Created: April 8, 2024 11:56 AM
Tags: Java

# Instructions/Scenario

## Scenario

You are a Database administrator for a university and need to create an application to manage student enrollments and balance

## App should do the following

- Ask the user how many new students will be added to the database
- The user should be prompted to enter the name and year for each student
- The student should have a 5-digit unique ID, with the first number being their grade level
- A student can enroll in the following courses
    - History 101
    - Mathematics 101
    - English 101
    - Chemistry 101
    - Computer Science 101
- Each course cost 600$ to enroll
- The student should be able to view their balance and pay the tuition
- to see the status of the student we should see their name, ID, courses enrolled and balance

# Step 1

## Create a Main class and a Student class

## Main

```java

public class Main {
    public static void main(String[] args) {

    }
}
```

## Student

```java
public class Student {

}

```

### Create all the attributes needed in the student class

```java
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
}
```

# Step 2

## Create the constructor and methods the student class will require

### Constructor

A simple constructor allowing us to assign first name, last name and grade year.The student id will be generated by adding our grade year with the static id.

```java

//Constructor
public Student(String firstName, String lastName, String gradeYear){
   this.firstName = capitalize(firstName);
    this.lastName = capitalize(lastName);
   this.gradeYear = Integer.parseInt(gradeYear);
   id++;
   this.studentID = gradeYear + id;
   this.enrolledCourses = new ArrayList<>();
}
```

### Capitalize method

You can use a 3rd party package Known as StringUtils but It’s easy enough to create your own

```java
public String capitalize(String word){
    return Character.toUpperCase(word.charAt(0)) + word.substring(1);
}
```

### Getters

```java
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
```

### Enroll classes

```java
public void enroll(String course){
    enrolledCourses.add(course);
    //adds the total cost
    tuitionBalance+=costOfCourse;
}
```

# Step 3

## Create a registration method

This will be responsible for entering all the basic information for a student.

```java
private static void registration(List<Student> students) {

}

```

### Create the the loop and prompt

While loop will keep looping until all the prompts are completed.

I decided to use a true statment and stop the loop with a break statement.

```java
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
  
  //add student to a list of students
  students.add(student);
  
  //calls another method that brings another prompt to enroll in classes
  enrollClasses(student);
  
  break;

}
```

## Create enrollClasses method

This will handle the enrollment of students into their classes. I've created a LinkedList of available classes. It will continue to loop until the user decides to quit by entering 0.

```java
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
```

## Create the final logic for the main method

The prompt will request the number of students you wish to enroll. The for-loop will then iterate that many times, creating a new student during each iteration.

```java
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
```

# Examples

![image](https://github.com/Jonnynavi/StudentDataBase/assets/118036410/caef3b0c-ea1c-4041-bc05-8d0e20989a14)

![image](https://github.com/Jonnynavi/StudentDataBase/assets/118036410/106d1aa3-5fd0-4614-80d2-92422a41406b)

![image](https://github.com/Jonnynavi/StudentDataBase/assets/118036410/16b78d32-1fcd-4094-afa1-3ee0d7d84e24)

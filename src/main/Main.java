package main;
import model.Student;
import service.StudentService;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("  STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("==============================");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Add New Student ---");
                    scanner.nextLine();
                    System.out.print("Enter Name   : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age    : ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Email  : ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone  : ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Course : ");
                    String course = scanner.nextLine();
                    Student newStudent = new Student(0, name, age,
                                        email, phone, course);
                    service.addStudent(newStudent);
                    break;

                case 2:
                    System.out.println("\n--- All Students ---");
                    List<Student> students = service.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        for (Student s : students) {
                            s.displayInfo();
                            System.out.println("------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Update Student ---");
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name   : ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age    : ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Email  : ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter New Phone  : ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Enter New Course : ");
                    String newCourse = scanner.nextLine();
                    Student updatedStudent = new Student(updateId,
                                            newName, newAge, newEmail,
                                            newPhone, newCourse);
                    service.updateStudent(updatedStudent);
                    break;

                case 4:
                    System.out.println("\n--- Delete Student ---");
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    service.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Thankyou! Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again!");
            }

        } while (choice != 5);

        scanner.close();
    }
}
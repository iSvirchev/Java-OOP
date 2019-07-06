import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String studentOrExit = scanner.nextLine();

        while (!"Exit".equalsIgnoreCase(studentOrExit)) {
            String[] input = studentOrExit.split(" ");
            String cmd = input[0];
            String name = input[1];

            switch (cmd) {
                case "Create":
                    int age = Integer.parseInt(input[2]);
                    double grade = Double.parseDouble(input[3]);
                    Student student = new Student(name,age,grade);
                    studentSystem.addStudent(student);
                    break;
                case "Show":
                    studentSystem.showStudent(name);
                    break;
            }

            studentOrExit = scanner.nextLine();
        }

    }
}

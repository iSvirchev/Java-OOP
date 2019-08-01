import validPerson.InvalidPersonNameException;
import validPerson.Person;
import validPerson.Student;

public class Main {

    public static void main(String[] args) {
        try {
            Person peter = new Person("Franco", "Aimee", 19);

            Person noName = new Person("   ", "Aimee", 19);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Person noLastName = new Person("Franco", null, 19);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Person negativeAge = new Person("Franco", "Aimee", -1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Person tooOld = new Person("Franco", "Aimee", 121);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Student student = new Student("Petko", "email@email.com");
        } catch (InvalidPersonNameException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }
        try {
            Student studentInvalid = new Student("Pe7ko", "email@email.com");
        } catch (InvalidPersonNameException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }
    }
}

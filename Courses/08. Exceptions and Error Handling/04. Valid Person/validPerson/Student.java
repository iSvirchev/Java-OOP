package validPerson;

public class Student {
    private String name;
    private String email;


    public Student(String name, String email) {
        setName(name);
        setEmail(email);
    }

    private void setName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                throw new InvalidPersonNameException("Student name invalid!");
            }
        }

        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}

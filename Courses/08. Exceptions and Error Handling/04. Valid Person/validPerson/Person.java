package validPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("The first name cannot be null or empty");
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty()){
            throw new IllegalArgumentException("The last name cannot be null or empty");
        }

        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age < 0 || age > 120){
            throw new IllegalArgumentException("Age should be in the range [0 ... 120]");
        }
        this.age = age;
    }
}

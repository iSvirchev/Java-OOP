public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    private double getSalary() {
        return this.salary;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    private String getFirstName() {
        return this.firstName;
    }

    private String getLastName() {
        return this.lastName;
    }

    private int getAge() {
        return this.age;
    }

    public void increaseSalary(double bonus) {
        if (getAge() < 30) bonus/=2;

        setSalary(getSalary() + getSalary()*bonus/100);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva",
                getFirstName(),
                getLastName(),
                getSalary());
    }

}

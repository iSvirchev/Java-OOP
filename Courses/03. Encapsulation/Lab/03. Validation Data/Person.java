public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    protected Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    protected void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    private String getFirstName() {
        return this.firstName;
    }

    protected void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    private String getLastName() {
        return this.lastName;
    }

    protected void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }

        this.age = age;
    }

    private int getAge() {
        return this.age;
    }

    private void setSalary(double salary) {
        if (salary < 460 ) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    private double getSalary() {
        return this.salary;
    }

    protected void increaseSalary(double bonus) {
        if (getAge() < 30) bonus /= 2;

        setSalary(getSalary() + getSalary() * bonus / 100);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva",
                getFirstName(),
                getLastName(),
                getSalary());
    }

}

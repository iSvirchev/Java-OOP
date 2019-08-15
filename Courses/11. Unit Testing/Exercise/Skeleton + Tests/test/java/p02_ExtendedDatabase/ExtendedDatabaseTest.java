package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {

    private static final String[] NAMES = {
            "A",
            "B",
            "C",
            "D",
            "E"
    };
    private Database db;

    @Before
    public void createDB() throws OperationNotSupportedException {

        Person[] people = new Person[5];

        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(i+1,NAMES[i]);
        }

        this.db = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowAnExceptionWhenCalledWithNull() throws OperationNotSupportedException {
        this.db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowAnExceptionWithDuplicatedUsernames() throws OperationNotSupportedException{
        this.db.add(new Person(12,"B"));
        this.db.findByUsername("B");
    }

    @Test
    public void findByUsernameShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person b = this.db.findByUsername("B");
        boolean areEqual = b.getId() == 2 && b.getUsername().equalsIgnoreCase("B");
        Assert.assertTrue(areEqual);
    }

    @Test
    public void findByIDShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person b = this.db.findById(2);
        boolean areEqual = b.getId() == 2 && b.getUsername().equalsIgnoreCase("B");
        Assert.assertTrue(areEqual);
    }


}
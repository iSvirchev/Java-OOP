package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final int INVALID_MAX_ELEMENTS_COUNT = 17;
    private static final Integer[] INITIAL_ELEMENTS = {13,42,69,73};
    private Database db;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.db = new Database(INITIAL_ELEMENTS);
    }

    @Test
    public  void creatingDatabaseShouldSetElementsCorrectly() throws OperationNotSupportedException {
        Assert.assertArrayEquals(db.getElements(), INITIAL_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithZeroElementsShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithMoreThanSixteenElementsShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(new Integer[INVALID_MAX_ELEMENTS_COUNT]);
    }

    @Test
    public void addingElementShouldBeAddedCorrectly() throws OperationNotSupportedException {
        this.db.add(17);
        Assert.assertEquals(this.db.getElements().length, INITIAL_ELEMENTS.length+1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullShouldThrowAnException() throws OperationNotSupportedException {

        this.db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingFromEmptyDBShouldThrowAnException() throws OperationNotSupportedException {

        for (int i = 0; i < INITIAL_ELEMENTS.length; i++) {
            this.db.remove();
        }
        this.db.remove();
    }

    @Test
    public void removeShouldDecreaseElementsCount() throws OperationNotSupportedException {
        this.db.remove();
        Assert.assertEquals(this.db.getElements().length,INITIAL_ELEMENTS.length-1);
    }



}
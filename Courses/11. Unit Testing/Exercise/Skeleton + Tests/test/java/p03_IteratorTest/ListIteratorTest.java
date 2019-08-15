package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;

    @Before
    public void initializeListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("s", "2", "6");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void listIteratorShouldThrowExceptionWhenCreatedWithNULL() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(null);
    }

    @Test(expected = IllegalStateException.class)
    public void printMethodShouldThrowExceptionOnEmptyList() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        this.listIterator.print();
    }

    @Test
    public void printShouldReturnStringOfCurrentIndex(){
        listIterator.move();
        String element = listIterator.print();//elem at index 1
        Assert.assertEquals(element,"2");
    }

    @Test
    public void moveShouldReturnTrueWhenCurrIndexNotLast(){
        listIterator.move();
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void moveShouldReturnFalseWhenCurrIndexIsLast(){
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void hasNextShouldReturnFalseWhenCurrIndexIsLast(){
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

}
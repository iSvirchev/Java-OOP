package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new CustomLinkedList<>();
    }

    @Test
    public void addingShouldWork() {
        list.add(13);

        Assert.assertTrue(list.contains(13));
    }

    @Test
    public void removeShouldWork() {
        list.add(13);
        list.remove(13);

        Assert.assertFalse(list.contains(13));
    }

    @Test
    public void indexOfShouldReturnOnlyFirstOccurrenceOfValue() {
        list.add(13);
        list.add(42);
        list.add(69);
        list.add(13);

        Assert.assertEquals(list.indexOf(13), 0);
    }

    @Test
    public void getShouldWork() {
        list.add(13);

        Integer checkValue = 13;
        Assert.assertEquals(list.get(0), checkValue);
    }

    @Test
    public void setShouldWork() {
        list.add(13);
        list.add(42);

        list.set(0, 69);

        Integer checkValue = 69;
        Assert.assertEquals(list.get(0), checkValue);
    }

    @Test
    public void removeAtShouldWork() {
        list.add(13);
        list.add(42);

        list.removeAt(0);

        Integer checkValue = 42;
        Assert.assertEquals(list.get(0), checkValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldThrowExceptionWhenIndexOutOfBounds() {
        list.add(13);
        list.get(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExceptionWhenIndexOutOfBounds() {
        list.add(13);
        list.set(1,69);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeShouldThrowExceptionWhenIndexOutOfBounds() {
        list.add(13);
        list.removeAt(1);
    }
}
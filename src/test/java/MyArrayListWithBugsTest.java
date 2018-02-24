import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MyArrayListWithBugsTest {

    private MyArrayListWithBugs arrayList;

    // TC001
    @Before
    public void setUp() {
        this.arrayList = new MyArrayListWithBugs();
        Assert.assertEquals(0, this.arrayList.size());
    }

    // TC002
    @Test
    public void addToEmptyListTest() {
        String firstObject = "First object";
        arrayList.add(firstObject);
        Assert.assertEquals(1, arrayList.size());
        Assert.assertEquals(firstObject, arrayList.get(0));
    }

    // TC003
    @Test(expected = IndexOutOfBoundsException.class)
    public void replaceItemInEmptyListTest() {
        arrayList.add(10, "Replaced");
    }

    // TC004
    @Test
    public void addItemToNonEmptyListtest() {
        addToEmptyListTest();

        String secondObject = "Second object";
        arrayList.add(secondObject);

        Assert.assertEquals(2, arrayList.size());
        Assert.assertEquals(secondObject, arrayList.get(1));
    }

    // TC005
    @Test
    public void replaceValidItemTest() {
        addItemToNonEmptyListtest();

        String newObject = "New object";
        arrayList.add(0, newObject);

        Assert.assertNotEquals(2, arrayList.size());
        Assert.assertEquals(newObject, arrayList.get(0));
    }

    // TC006
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeItemFromEmptyListTest() {
        arrayList.remove(0);
    }

    // TC007 & TC008
    @Test
    public void removeItemFromListTest() {
        addItemToNonEmptyListtest();

        String removed = (String) arrayList.remove(0);
        Assert.assertEquals(1, arrayList.size());
        Assert.assertNotNull(removed);

        removed = (String) arrayList.remove(0);
        Assert.assertEquals(0, arrayList.size());
        Assert.assertNotNull(removed);
    }

    // TC009
    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtNonExistentIndex() {
        String index4Object = "Some new object at index 4";
        arrayList.add(4, index4Object);
    }

    // TC010
    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtEndPlusOneIndexTest() {
        addItemToNonEmptyListtest();
        String newObj = "New obj2";
        arrayList.add(2, newObj);
    }

    // TC011
    @Test
    public void addAtEndTest() {
        addItemToNonEmptyListtest();
        String newObj = "New Obj11";
        arrayList.add(1, newObj);
        Assert.assertEquals(3, arrayList.size());
        Assert.assertEquals(newObj, arrayList.get(1));
    }
}

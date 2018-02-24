import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListWithoutBugsTest {
    private MyArrayListWithoutBugs arrayList;

    // TC001
    @Before
    public void setUp() {
        this.arrayList = new MyArrayListWithoutBugs();
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
    public void addItemToEmptyListTest() {
        arrayList.add(0, "Test object");
    }

    // TC004
    @Test
    public void addItemToNonEmptyListTest() {
        addToEmptyListTest();

        String secondObject = "Second object";
        arrayList.add(secondObject);

        Assert.assertEquals(2, arrayList.size());
        Assert.assertEquals(secondObject, arrayList.get(1));
    }

    // TC005
    @Test
    public void replaceValidItemTest() {
        addItemToNonEmptyListTest();

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
        addItemToNonEmptyListTest();

        String removed = (String) arrayList.remove(0);
        Assert.assertEquals(1, arrayList.size());
        Assert.assertNotNull(removed);

        removed = (String) arrayList.remove(0);
        Assert.assertEquals(0, arrayList.size());
        Assert.assertNotNull(removed);
    }

    // TC009
    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtEndPlusOneIndexTest() {
        addItemToNonEmptyListTest();
        String newObj = "New obj2";
        arrayList.add(2, newObj);
    }

    // TC010
    @Test
    public void addAtEndTest() {
        addItemToNonEmptyListTest();
        String newObj = "New Obj11";
        arrayList.add(1, newObj);
        Assert.assertEquals(3, arrayList.size());
        Assert.assertEquals(newObj, arrayList.get(1));
    }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        arrayList.add(0, "Replaced");
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

        String replaced = "Replaced object";
        arrayList.add(0, replaced);

        Assert.assertEquals(2, arrayList.size());
        Assert.assertEquals(replaced, arrayList.get(0));
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
}

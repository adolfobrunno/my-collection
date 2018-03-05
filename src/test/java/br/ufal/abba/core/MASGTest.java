package br.ufal.abba.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MASGTest {


    private MyList list;

    @Before
    public void setUp() {
        this.list = new MyList();
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetItemInEmptyList() {
        Assert.assertNotNull(list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSecondItemInEmptyList() {
        Assert.assertNotNull(list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetItemNegativeIndex() {
        Assert.assertNotNull(list.get(-1));
    }

    @Test
    public void testGetSizeInEmptyList() {
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testAddItem() {
        this.list.add(10);

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(1, this.list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullItem() {
        this.list.add(null);

        Assert.assertEquals(null, this.list.get(0));
        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testMultiplyAdds() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);
        this.list.add(13);
        this.list.add(14);
        this.list.add(15);
        this.list.add(16);

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(11, this.list.get(1).intValue());
        Assert.assertEquals(12, this.list.get(2).intValue());
        Assert.assertEquals(13, this.list.get(3).intValue());
        Assert.assertEquals(14, this.list.get(4).intValue());
        Assert.assertEquals(15, this.list.get(5).intValue());
        Assert.assertEquals(16, this.list.get(6).intValue());

        Assert.assertEquals(7, this.list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNonExistentItem() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);
        this.list.add(10);

        this.list.get(7);
    }

    @Test
    public void testAddExtremeValues() {

        this.list.add(Integer.MAX_VALUE);
        this.list.add(Integer.MIN_VALUE);

        Assert.assertEquals(Integer.MAX_VALUE, this.list.get(0).intValue());
        Assert.assertEquals(Integer.MIN_VALUE, this.list.get(1).intValue());
    }

    @Test
    public void testGetItemMultipleTimes() {
        this.list.add(0);

        Assert.assertEquals(0, this.list.get(0).intValue());
        Assert.assertEquals(0, this.list.get(0).intValue());
        Assert.assertEquals(0, this.list.get(0).intValue());
        Assert.assertEquals(0, this.list.get(0).intValue());
    }

    @Test
    public void testAddReturnTrue() {
        Assert.assertTrue(this.list.add(-1000));
    }

    @Test
    public void testAddLast() {

        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        Assert.assertTrue(this.list.addLast(-100));
        Assert.assertEquals(-100, this.list.get(this.list.size() - 1).intValue());
        Assert.assertEquals(4, this.list.size());
    }

    @Test
    public void testAddLastWithEmptyList() {
        this.list.addLast(-100);

        Assert.assertEquals(-100, this.list.get(this.list.size() - 1).intValue());
    }

    @Test
    public void testAddFirst() {

        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        Assert.assertTrue(this.list.addFirst(-100));
        Assert.assertEquals(-100, this.list.get(0).intValue());
        Assert.assertEquals(4, this.list.size());
    }

    @Test
    public void testAddFirstWithEmptyList() {
        this.list.addFirst(-100);

        Assert.assertEquals(-100, this.list.get(0).intValue());
    }

    @Test
    public void testAddInBegin() {

        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        this.list.add(0, -100);

        Assert.assertEquals(-100, this.list.get(0).intValue());
        Assert.assertEquals(10, this.list.get(1).intValue());
        Assert.assertEquals(11, this.list.get(2).intValue());
        Assert.assertEquals(12, this.list.get(3).intValue());

        Assert.assertEquals(4, this.list.size());
    }

    @Test
    public void testAddInEnd() {

        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        this.list.add(3, -100);

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(11, this.list.get(1).intValue());
        Assert.assertEquals(12, this.list.get(2).intValue());
        Assert.assertEquals(-100, this.list.get(3).intValue());

        Assert.assertEquals(4, this.list.size());
    }

    @Test
    public void testAddInMid() {

        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        this.list.add(1, -100);

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(-100, this.list.get(1).intValue());
        Assert.assertEquals(11, this.list.get(2).intValue());
        Assert.assertEquals(12, this.list.get(3).intValue());

        Assert.assertEquals(4, this.list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtNegativeIndex() {

        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        this.list.add(-1, -100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtOutOfBounds() {

        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        this.list.add(this.list.size() + 1, -100);
    }

    @Test
    public void testRemoveAtBegin() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        this.list.removeAt( 0);

        Assert.assertEquals(11, this.list.get(0).intValue());
        Assert.assertEquals(12, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testRemoveAtEnd() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        this.list.removeAt( 2);

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(11, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testRemoveAtMid() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        Assert.assertTrue(this.list.removeAt( 1));

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(12, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testRemoveAtOutOfBound() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        Assert.assertFalse(this.list.removeAt( 3));
    }

    @Test
    public void testRemoveFirst() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        Assert.assertTrue(this.list.removeFirst( ));

        Assert.assertEquals(11, this.list.get(0).intValue());
        Assert.assertEquals(12, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testRemoveLast() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        Assert.assertTrue(this.list.removeLast());

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(11, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testRemoveLastEmptyList() {
        Assert.assertFalse(this.list.removeLast());
    }

    @Test
    public void testRemoveBeginEmptyList() {
        Assert.assertFalse(this.list.removeLast());
    }

    @Test
    public void testRemoveAtEmptyList() {
        Assert.assertFalse(this.list.removeAt(0));
    }

    @Test
    public void testRemoveValue() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        Assert.assertTrue(this.list.remove(10));

        Assert.assertEquals(11, this.list.get(0).intValue());
        Assert.assertEquals(12, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWithNull() {
        this.list.remove(null);
    }

    @Test
    public void testRemoveValueTwo() {
        this.list.add(20);
        this.list.add(21);
        this.list.add(22);

        Assert.assertTrue(this.list.remove(21));

        Assert.assertEquals(20, this.list.get(0).intValue());
        Assert.assertEquals(22, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testRemoveValueThree() {
        this.list.add(10);
        this.list.add(11);
        this.list.add(12);

        Assert.assertTrue(this.list.remove(12));

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(11, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testRemoveDuplicate() {
        this.list.add(30);
        this.list.add(31);
        this.list.add(30);

        Assert.assertTrue(this.list.remove(30));

        Assert.assertEquals(31, this.list.get(0).intValue());
        Assert.assertEquals(30, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());

        Assert.assertTrue(this.list.remove(30));

        Assert.assertEquals(31, this.list.get(0).intValue());

        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testRemoveNotFound() {
        this.list.add(50);
        this.list.add(51);
        this.list.add(62);

        Assert.assertFalse(this.list.remove(88));

        Assert.assertEquals(50, this.list.get(0).intValue());
        Assert.assertEquals(51, this.list.get(1).intValue());
        Assert.assertEquals(62, this.list.get(2).intValue());

        Assert.assertEquals(3, this.list.size());
    }

    @Test
    public void testSort() {
        this.list.add(6);
        this.list.add(5);
        this.list.add(4);
        this.list.add(3);
        this.list.add(2);
        this.list.add(1);

        this.list.sort();

        Assert.assertEquals(1, this.list.get(0).intValue());
        Assert.assertEquals(2, this.list.get(1).intValue());
        Assert.assertEquals(3, this.list.get(2).intValue());
        Assert.assertEquals(4, this.list.get(3).intValue());
        Assert.assertEquals(5, this.list.get(4).intValue());
        Assert.assertEquals(6, this.list.get(5).intValue());

        Assert.assertEquals(6, this.list.size());
    }

    @Test
    public void testSortOrdered() {
        this.list.add(10);
        this.list.add(20);
        this.list.add(30);
        this.list.add(40);
        this.list.add(50);
        this.list.add(60);

        this.list.sort();

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(20, this.list.get(1).intValue());
        Assert.assertEquals(30, this.list.get(2).intValue());
        Assert.assertEquals(40, this.list.get(3).intValue());
        Assert.assertEquals(50, this.list.get(4).intValue());
        Assert.assertEquals(60, this.list.get(5).intValue());

        Assert.assertEquals(6, this.list.size());
    }

    @Test
    public void testSortOdd() {
        this.list.add(10);
        this.list.add(20);
        this.list.add(30);
        this.list.add(40);
        this.list.add(50);


        this.list.sort();

        Assert.assertEquals(10, this.list.get(0).intValue());
        Assert.assertEquals(20, this.list.get(1).intValue());
        Assert.assertEquals(30, this.list.get(2).intValue());
        Assert.assertEquals(40, this.list.get(3).intValue());
        Assert.assertEquals(50, this.list.get(4).intValue());

        Assert.assertEquals(5, this.list.size());
    }

    @Test
    public void testSortDuplicated() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(1);
        this.list.add(2);
        this.list.add(1);
        this.list.add(2);

        this.list.sort();

        Assert.assertEquals(1, this.list.get(0).intValue());
        Assert.assertEquals(1, this.list.get(1).intValue());
        Assert.assertEquals(1, this.list.get(2).intValue());
        Assert.assertEquals(2, this.list.get(3).intValue());
        Assert.assertEquals(2, this.list.get(4).intValue());
        Assert.assertEquals(2, this.list.get(5).intValue());

        Assert.assertEquals(6, this.list.size());
    }

    @Test
    public void testSortNegative() {
        this.list.add(-2);
        this.list.add(0);
        this.list.add(-7);
        this.list.add(200);
        this.list.add(10);
        this.list.add(2);

        this.list.sort();

        Assert.assertEquals(-7, this.list.get(0).intValue());
        Assert.assertEquals(-2, this.list.get(1).intValue());
        Assert.assertEquals(0, this.list.get(2).intValue());
        Assert.assertEquals(2, this.list.get(3).intValue());
        Assert.assertEquals(10, this.list.get(4).intValue());
        Assert.assertEquals(200, this.list.get(5).intValue());

        Assert.assertEquals(6, this.list.size());
    }

    @Test
    public void testSortOneElement() {
        this.list.add(-2);

        this.list.sort();

        Assert.assertEquals(-2, this.list.get(0).intValue());

        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testSortTwoElements() {
        this.list.add(9);
        this.list.add(8);

        this.list.sort();

        Assert.assertEquals(8, this.list.get(0).intValue());
        Assert.assertEquals(9, this.list.get(1).intValue());

        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testSortNoElements() {

        this.list.sort();

        Assert.assertEquals(0, this.list.size());
    }

    @Test
    public void testInverter() {
        this.list.add(4);
        this.list.add(8);
        this.list.add(5);
        this.list.add(6);

        this.list.invert();

        Assert.assertEquals(6, this.list.get(0).intValue());
        Assert.assertEquals(5, this.list.get(1).intValue());
        Assert.assertEquals(8, this.list.get(2).intValue());
        Assert.assertEquals(4, this.list.get(3).intValue());

        Assert.assertEquals(4, this.list.size());
    }

    @Test
    public void testInverterEmptyList() {
        this.list.invert();

        Assert.assertEquals(0, this.list.size());
    }

    @Test
    public void testInverterOneElement() {
        this.list.add(4);

        this.list.invert();

        Assert.assertEquals(4, this.list.get(0).intValue());

        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testUpdate() {
        this.list.add(4);
        this.list.add(8);
        this.list.add(5);
        this.list.add(6);

        Assert.assertTrue(this.list.update(8000, 1));

        Assert.assertEquals(4, this.list.get(0).intValue());
        Assert.assertEquals(8000, this.list.get(1).intValue());
        Assert.assertEquals(5, this.list.get(2).intValue());
        Assert.assertEquals(6, this.list.get(3).intValue());

        Assert.assertEquals(4, this.list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUpdateEmptyList() {

        Assert.assertTrue(this.list.update(8000, 0));

        Assert.assertEquals(8000, this.list.get(0).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUpdateOutOfBounds() {
        this.list.add(4);
        this.list.add(8);
        this.list.add(5);
        this.list.add(6);

        Assert.assertFalse(this.list.update(8000, 10));

        Assert.assertEquals(4, this.list.get(0).intValue());
        Assert.assertEquals(8, this.list.get(1).intValue());
        Assert.assertEquals(5, this.list.get(2).intValue());
        Assert.assertEquals(6, this.list.get(3).intValue());

        Assert.assertEquals(4, this.list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateWithNull() {
        this.list.update(null, 0);
    }

    @Test
    public void testSearch() {
        this.list.add(4);
        this.list.add(8);
        this.list.add(5);
        this.list.add(6);

        Assert.assertEquals(2, this.list.search(5));

        Assert.assertEquals(4, this.list.size());
    }

    @Test
    public void testSearchNotFound() {
        this.list.add(45);
        this.list.add(85);
        this.list.add(55);
        this.list.add(65);

        Assert.assertEquals(-1, this.list.search(50));

        Assert.assertEquals(4, this.list.size());
    }

    @Test
    public void testSearchInEmptyList() {

        Assert.assertEquals(-1, this.list.search(0));

        Assert.assertEquals(0, this.list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchNull() {
        this.list.search(null);
    }

    @Test
    public void testSum() {
        MyList a = new MyList();
        MyList b = new MyList();

        a.add(1);
        a.add(5);
        a.add(7);

        b.add(1);
        b.add(7);
        b.add(8);

        MyList result = (MyList) MyList.sum(a, b);

        Assert.assertEquals(2, result.get(0).intValue());
        Assert.assertEquals(2, result.get(1).intValue());
        Assert.assertEquals(6, result.get(2).intValue());
        Assert.assertEquals(1, result.get(3).intValue());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumIllegalArgs() {
        MyList a = new MyList();
        MyList b = new MyList();

        a.add(1);
        a.add(5);
        a.add(7);

        b.add(10);
        b.add(7);
        b.add(8);

        MyList.sum(a, b);
    }

}

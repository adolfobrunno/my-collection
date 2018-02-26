package br.ufal.abba.core;

import java.util.Random;

import org.junit.Test;

import junit.framework.TestCase;

public class MyListTest extends TestCase{

	@Test
	public void testCreation() {
		
		MyList list1 = new MyList();
		assertNotNull(list1);
		assertEquals(1, list1.size());
		
		MyList list2 = new MyList(5);
		assertNotNull(list2);
		assertEquals(5, list2.size());
		
		MyList list3 = MyList.asMyList(1, 2, 3);
		assertNotNull(list3);
		assertEquals(3, list3.size());
		
		MyList listString = new MyList("123456");
		assertEquals(MyList.asMyList(1,2,3,4,5,6), listString);
		
	}
	
	@Test
	public void testAdd() {
		
		MyList list = MyList.asMyList(1,2,3,4);
		list.add(5);
		assertEquals(5, list.size());
		
		list.add(2, 8);
		assertEquals(8, (int)list.get(2));
		
		MyList listFinal = MyList.asMyList(1, 2, 8, 3, 4, 5);
		assertEquals(list, listFinal);
		
		MyList list2 = new MyList();
		list2.add(1);
		assertEquals(1, list2.size());
		assertEquals(1, (int) list2.get(0));
		
		MyList addFirst = MyList.asMyList(9);
		addFirst.addFirst(1);
		assertEquals(MyList.asMyList(1,9), addFirst);
		
		MyList l = new MyList();
		assertFalse(l.add(5, 5));
		
	}
	
	@Test
	public void testRemove() {
		
		MyList list = MyList.asMyList(1,2,3,4);
		list.removeAt(0);
		assertEquals(3, list.size());
		assertEquals(2, (int) list.get(0));
		
		MyList list2 = MyList.asMyList(1,2,3,4);
		list2.removeLast();
		assertEquals(3, list2.size());
		assertEquals(list2, MyList.asMyList(1,2,3));
		
		MyList list3 = MyList.asMyList(1,2,3,4);
		list3.removeFirst();
		assertEquals(3, list3.size());
		assertEquals(list3, MyList.asMyList(2,3,4));
		
		MyList list4 = MyList.asMyList(1,2,3,4);
		list4.remove(1);
		assertEquals(3, list4.size());
		assertEquals(list4, MyList.asMyList(2,3,4));
		
	}
	
	public void testSort() {
		
		MyList list = MyList.asMyList(4,3,2,1);
		list.sort();
		assertEquals(MyList.asMyList(1,2,3,4), list);
		
		MyList list2 = MyList.asMyList(1,2,3,4);
		list2.sort();
		assertEquals(MyList.asMyList(1,2,3,4), list2);
		
		MyList list3 = MyList.asMyList(1,3,2,4);
		list3.sort();
		assertEquals(MyList.asMyList(1,2,3,4), list3);
	}

	@Test(timeout=1000)
	public void testSortTimeout() {
		
		int size = 100;
		MyList list = new MyList(size);
		
		Random random = new Random();
		
		for(int i=0; i<size; i++) {
			list.add(random.nextInt());
		}
		
		list.sort();
		
		for(int i=0; i<list.size()-1; i++) {
			assertTrue(list.get(i) <= list.get(i+1));
		}
		
		System.out.println(list);
	}
	
	@Test(timeout=1000)
	public void testInvert() {
		
		MyList list = MyList.asMyList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		list.invert();
		assertEquals(MyList.asMyList(20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1), list);
	}
	
	@Test
	public void testSum() {
		
		
//		MyList list1 = new MyList("9");
//		MyList list2 = new MyList("1");
//		
//		assertEquals(MyList.asMyList(1,0), MyList.sum(list1, list2));
//		assertEquals(new MyList("10"), MyList.sum(list1, list2));
//		
		MyList l = MyList.asMyList(1);
		MyList l2 = MyList.asMyList(9);
		System.out.println(MyList.sum(l, l2));
		assertEquals(new MyList("10"), MyList.sum(l, l2));
	}
	
}

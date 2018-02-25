package br.ufal.abba.core;

import java.util.Arrays;

public class MyList implements ICollection<Integer> {

	private Integer[] array;

	private static final Integer INIT_SIZE = 1;

	MyList() {
		array = new Integer[INIT_SIZE];
	}

	MyList(int size) {
		array = new Integer[size];
	}

	MyList(String number) {
		array = new Integer[number.length()];
		for(int i = 0; i < number.length(); i++) {
			array[i] = Integer.valueOf(number.charAt(i)-'0');
		}
	}
	
	public static MyList asMyList(Integer... i) {
		MyList list = new MyList(i.length);
		list.array = i;
		return list;
	}

	public int size() {
		return array.length;
	}

	public boolean add(Integer t) {

		for (int j = 0; j < this.size(); j++) {
			if (array[j] == null) {
				array[j] = t;
				return true;
			}
		}

		int currentSize = size();
		int newSize = currentSize + 1;
		Integer[] tempArray = new Integer[newSize];
		for (int i = 0; i < currentSize; i++) {
			if (array[i] != null) {
				tempArray[i] = array[i];
			}
		}
		tempArray[newSize - 1] = t;
		array = tempArray;

		return true;
	}

	public boolean add(int index, Integer t) {

		if (index >= size())
			return false;
		else if (index < 0)
			throw new IndexOutOfBoundsException();

		if (array[index] == null) {
			array[index] = t;
		} else {
			int newSize = size() + 1;
			Integer[] arrayAux = new Integer[newSize];
			for (int i = 0; i < index; i++)
				arrayAux[i] = array[i];
			arrayAux[index] = t;
			for (int i = index + 1; i < newSize; i++)
				arrayAux[i] = array[i - 1];
			array = arrayAux;
		}

		return true;
	}

	public Integer get(int index) {
		if (index >= 0 && index < size()) {
			return array[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean remove(Integer value) {
		for (int i = 0; i < size(); i++) {
			if (array[i] == value) {
				return this.remove(i);
			}
		}
		return false;
	}

	public boolean remove(int index) {

		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();

		int newSize = size() - 1;
		Integer[] arrayAux = new Integer[newSize];

		for (int i = 0; i < index; i++)
			arrayAux[i] = array[i];

		for (int i = index; i < newSize; i++)
			arrayAux[i] = array[i + 1];

		this.array = arrayAux;

		return true;
	}

	public boolean addFirst(Integer t) {
		return this.add(0, t);
	}

	public boolean addLast(Integer t) {
		return this.add(t);
	}

	public boolean removeFirst() {
		return this.remove(0);
	}

	public boolean removeLast() {
		return this.remove(size() - 1);
	}

	public void sort() {

		int i = 0;
		int j = size() - 1;
		int aux;
		int center = array[(i + j) / 2];

		while (i < j) {

			while (array[i] < center) {
				i++;
			}
			while (array[j] > center) {
				j--;
			}

			if (i < j) {
				aux = array[i];
				array[i] = array[j];
				array[j] = aux;
				i++;
				j--;
			}
		}

	}

	public int search(Integer t) {

		for (int i = 0; i < size(); i++) {
			if (t.equals(array[i])) {
				return i;
			}
		}

		return -1;
	}

	public boolean update(Integer t, int index) {

		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();

		this.array[index] = t;

		return true;
	}

	public void invert() {

		int newSize = array.length - 1;
		Integer[] aux = new Integer[array.length];
		int index = 0;
		for (int i = newSize; i >= 0; i--) {
			aux[index] = array[i];
			index++;
		}
		this.array = aux;
	}

	public static ICollection<Integer> sum(MyList list1, MyList list2)
			throws IllegalArgumentException {
		
		int size1 = list1.size();
		int size2 = list2.size();
		
		while(size1 > size2) {
			list2.addFirst(0);
			size2 = list2.size();
		}
		while(size2 > size1) {
			list1.addFirst(0);
			size1 = list2.size();
		}
		
		MyList sum = new MyList(size1);
		
		int aux = 0;
		
		for(int i = size1-1; i >= 0; i--) {
			
			if(list1.get(i) > 9 || list2.get(i) > 9) {
				throw new IllegalArgumentException();
			}
			
			int partial = list1.get(i) + aux + list2.get(i);
			
			if(partial > 9) {
				int up = partial - 10;
				sum.update(up, i);
				aux = (partial - 9);
			} else {
				sum.update(partial, i);
				aux = 0;
			}
			
		}
		
		return sum;
	}

	public String toString() {
		return Arrays.toString(array);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof MyList) {
			return Arrays.equals(((MyList) o).array, this.array);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(array);
	}

}

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
		for (int i = 0; i < number.length(); i++) {
			array[i] = Integer.valueOf(number.charAt(i) - '0');
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

	/**
	 * Add t to the end of list. Return true if possible if size changed
	 */
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

		return currentSize != size();
	}

	/**
	 * Add t into position index Return true if possible, throws IndexOutOfBound
	 * otherwise
	 */
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

	/**
	 * @param index
	 * @return element at index position
	 */
	public Integer get(int index) {
		if (index >= 0 && index < size()) {
			return array[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Remove the first occurrence of value. Return true if can, false otherwise
	 */
	public boolean remove(Integer value) {
		for (int i = 0; i < size(); i++) {
			if (array[i] == value) {
				return this.removeAt(i);
			}
		}
		return false;
	}

	/**
	 * Remove element at index Return true if can, false otherwise
	 */
	public boolean removeAt(int index) {

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
		return this.removeAt(0);
	}

	public boolean removeLast() {
		return this.removeAt(size() - 1);
	}

	/**
	 * Sort the list. Implements QuickSort
	 */
	public void sort() {
		quickSort(0, size()-1);
	}

	private void quickSort(int begin, int end) {
		if (begin < end) {
			int middle = findMiddle(begin, end);
			quickSort(begin, middle - 1);
			quickSort(middle + 1, end);
		}
	}

	private int findMiddle(int begin, int end) {
		int middle = array[begin];
		int i = begin + 1; 
		int f = end;
		while (i <= f) {
			if (array[i] <= middle)
				i++;
			else if (middle < array[f])
				f--;
			else {
				int tmp = array[i];
				array[i] = array[f];
				array[f] = tmp;
				i++;
				f--;
			}
		}
		array[begin] = array[f];
		array[f] = middle;
		return f;
	}

	/**
	 * Find the t and return the index, -1 otherwise
	 */
	public int search(Integer t) {

		for (int i = 0; i < size(); i++) {
			if (t.equals(array[i])) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Change value on index with t. Throws IndexOutOfBoundException if index is
	 * invalid
	 */
	public boolean update(Integer t, int index) {

		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();

		this.array[index] = t;

		return true;
	}

	/**
	 * Invert the list
	 */
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

	/**
	 * Sum two distinct lists and return a new list with the result
	 * 
	 * @param list1
	 * @param list2
	 * @return the summed list
	 * @throws IllegalArgumentException
	 */
	public static ICollection<Integer> sum(MyList list1, MyList list2) throws IllegalArgumentException {

		int size1 = list1.size();
		int size2 = list2.size();

		while (size1 > size2) {
			list2.addFirst(0);
			size2 = list2.size();
		}
		while (size2 > size1) {
			list1.addFirst(0);
			size1 = list2.size();
		}

		MyList sum = new MyList(size1);

		int aux = 0;

		for (int i = size1 - 1; i >= 0; i--) {

			if (list1.get(i) > 9 || list2.get(i) > 9 || list1.get(i) < 0 || list2.get(i) < 0) {
				throw new IllegalArgumentException();
			}

			int partial = list1.get(i) + aux + list2.get(i);

			if (partial > 9) {
				int diff = partial == 10 ? 1 : partial - 10;
				aux = diff;
				sum.update(diff, i);
				if (i == 0 && aux > 0) {
					sum.addFirst(aux);
				}
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

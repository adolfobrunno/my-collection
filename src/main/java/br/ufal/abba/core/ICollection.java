package br.ufal.abba.core;

public interface ICollection<T> {

	boolean add(T t);
	boolean add(int index, T t);
	boolean remove(int i);
	boolean remove(T value);
	boolean addFirst(T t);
	boolean addLast(T t);
	boolean removeFirst();
	boolean removeLast();
	void sort();
	int search(T t);
	boolean update(T t, int index);
	void invert();
//	ICollection<T> sum(ICollection<T> collection1, ICollection<T> collection2) throws IllegalArgumentException;
	
}

package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class have to iterate through elements in an array without knowing the structure of an array.
 * 
 * @author Pasut Kittiprapas
 *
 * @param <T>
 *            the type of elements returned by this iterator
 */
public class ArrayIterator<T> implements Iterator<T> {
	
	
	/** attribute for the array we want to iterate over */
	private T[] array;
	
	/** Point the index of the element in an array */
	private int point;
	
	/** Check whether remove() method can call or not*/
	private boolean check;
	
	
	
	 /**     
	  * Initialize a new array iterator with the array to process.    
	  * @param array is the array to iterate over     
	  */ 
	public ArrayIterator(T[] array){
		this.array = array;
		this.check = false;
		
		
	}

	/**
	 * Return true or false depend on the condition.
	 * 
	 * @return true if the iteration has more non-null elements and return false
	 *         if it isn't.
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.point; i < array.length; i++) {
			if (array[i] != null) {
				point = i;
				return true;
			}
		}
		return false;
		
	}

	/**
	 * Return the next non-null element from array, if any. 
	 * @return the next non-null element in the array.     
	 * @throws NoSuchElementException if there are no more elements     
	 *        to return.     
	 */ 
	@Override
	public T next() {
		if (hasNext() == true) {
			point++;
			check = true;
			return array[point];
		} else
			throw new NoSuchElementException();
	}
	
	/**
	 * Remove the element that recent use by method next() and it do nothing when method next() hasn't used first.
	 * 
	 * @throws IllegalStateException
	 *             it was called when you didn't call next() before.
	 */
	@Override
	public void remove(){
		if (check == true) {
			array[point - 1] = null;
			check = false;
		} else
			throw new IllegalStateException();
	}

}

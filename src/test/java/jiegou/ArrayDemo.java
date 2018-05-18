package jiegou;

import java.util.Arrays;
import java.util.Collection;

public class ArrayDemo<T> {

	private Object[] array;

	private int length = 0;

	private final static int DEFAULT_CAPACITY = 3;

	public ArrayDemo() {
		super();
		this.array = new Object[DEFAULT_CAPACITY];
		this.length = DEFAULT_CAPACITY;
	}

	public ArrayDemo(int length) {
		super();
		if (length < 0) {
			throw new IllegalArgumentException("error length:" + length);
		}
		this.array = new Object[length];
		this.length = length;
	}

	public ArrayDemo(Collection<? extends T> c) {
		array = c.toArray();
		length = c.size();
		if (array.getClass() != Object[].class) {
			array = Arrays.copyOf(array, length, Object[].class);
		}
	}

	/**
	 * 在数组array的index位置处插入一个元素t,如果已经满了，则移除最后一个元素
	 * 
	 * @param array
	 * @param t
	 * @param indext
	 */
	// public void insert(T t, int index) {
	// if (null == t) {
	// throw new NullPointerException("null Pointer!");
	// }
	// if (index < 0 || index > length - 1) {
	// throw new IndexOutOfBoundsException("index is error");
	// }
	// for (int pos = length - 1; pos > index; pos--) {
	// array[pos] = array[pos - 1];
	// }
	// array[index] = t;
	// }

	// public void insert(T t, int index) {
	// if (null == t) {
	// throw new NullPointerException("null Pointer!");
	// }
	// if (index < 0 || index > length - 1) {
	// throw new IndexOutOfBoundsException("index is error");
	// }
	// for (int pos = 3; pos > index; pos--) {
	// array[pos] = array[pos - 1];
	// }
	//
	//
	// array[index] = t;
	// }

	public void insert(T t, int index) {
		if (null == t) {
			throw new NullPointerException("null Pointer!");
		}
		if (index < 0 || index > length - 1) {
			throw new IndexOutOfBoundsException("index is error");
		}
		for (int i = length - 1; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = t;
	}

	public void delete(int index) {
		if (null == array) {
			throw new NullPointerException("null Pointer!");
		}
		int length = array.length;
		if (index < 0 || index > length - 1) {
			throw new IndexOutOfBoundsException("index is error");
		}
		for (int i = index; i < array.length-1; i++) {
			array[i]=array[i+1];
		 
		}
		array[length - 1] = null;

	}

	/**
	 * 删除指定位置上的数组元素
	 * 
	 * @param array
	 * @param index
	 */
	/*
	 * public void delete(int index) { if (null == array) { throw new
	 * NullPointerException("null Pointer!"); } int length = array.length; if
	 * (index < 0 || index > length - 1) { throw new IndexOutOfBoundsException(
	 * "index is error"); } for (int pos = index; pos < length - 1; pos++) {
	 * array[pos] = array[pos + 1]; } array[length - 1] = null; }
	 */

	/**
	 * 遍历输出数组中所有元素
	 */
	public void trans() {
		if (null == array) {
			throw new NullPointerException("null Pointer!");
		}
		for (int pos = 0; pos < length; pos++) {
			System.out.println(array[pos]);
		}
	}

	public static void main(String[] args) {
		ArrayDemo<String> array = new ArrayDemo<String>(1);
		array.insert("2", 0);
	 
		array.trans();
		array.delete(0);
	 
		System.out.println("---");
		array.trans();
	}

}
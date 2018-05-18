package jiegou;

import org.apache.poi.ss.formula.functions.T;

public class Stack<T> {
	// 使用数组实现这个栈结构
	private T[] dataArr;
	// 当前元素的个数
	private int theSize;
	// 栈的容量
	private static final int DEFAULT_CAPACITY = 10;

	public Stack() {
		clear();

	}

	// 初始化数组,默认大小10,元素个数theSize初始化为o
	private void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	// 栈元素容量
	public int size() {
		return theSize;
	}

	private void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) {
			return;
		}
		T[] oldArr = dataArr;
		dataArr = (T[]) new Object[newCapacity];
		for (int i = 0; i < size(); i++) {
			dataArr[i] = oldArr[i];
		}

	}

	// 入栈
	public void push(T value) {
		if (dataArr.length == size()) {
			ensureCapacity(size() * 2);
		}
		dataArr[theSize++] = value;
	}

	// 栈是否为空
	public boolean isEmpty() {
		return size() == 0;
	}

	// 出栈
	public T pop() {
		if (isEmpty()) {
			return null;
		}
		T theValue = dataArr[theSize - 1];
		dataArr[--theSize] = null;
		return theValue;

	}

	// 返回栈尾元素
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		T theValue = dataArr[theSize - 1];
		return theValue;
	}

	public void display() {
		for (int i = 0; i < theSize; i++) {
			System.out.println(dataArr[i].toString());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> m = new Stack<Integer>();
		m.push(1);
		m.push(2);
		m.push(3);
		m.push(4);
		m.display();
		m.pop();
		m.display();

	}
}

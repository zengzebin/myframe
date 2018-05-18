package jiegou;

public class LinkedList {
	private class Data {
		private Object obj;
		private Data next = null;

		Data(Object obj) {
			this.obj = obj;
		}
	}

	private Data first = null;
	private Data last = null;

	public void insertFirst(Object obj) {
		Data data = new Data(obj);
		data.next = first;
		first = data;
	}

	public void insertLast(Object obj) {
		Data data = new Data(obj);
		if (first == null) {
			first = data;
		} else {
			last.next = data;// 把上一个复制过来第二步
		}
		last = data;// 把当前的弄成是最后一个第一步
	}

	public Object deleteFirst() {
		first = first.next;
		return null;
	}

	public void display() {
		if (first == null)
			System.out.println("empty");
		Data cur = first;
		while (cur != null) {
			System.out.print(cur.obj.toString() + " -> ");
			cur = cur.next;
		}
		System.out.print("\n");
	}

	// public void insert(Object obj) {
	// Data data = new Data(obj);
	// Data pre = null;
	// Data cur = first;
	// while (cur != null) {
	// if (Integer.parseInt(cur.obj.toString()) >
	// Integer.parseInt(data.obj.toString())) {
	// pre = cur;
	//
	// }
	// cur = cur.next;
	//
	// }
	// if (pre == null)
	// first = data;
	// else
	// pre.next = data;
	// data.next = cur;

	public void insert(Object obj) {
		Data data = new Data(obj);
		Data pre = null;
		Data cur = first;
		while (cur != null && Integer.parseInt(cur.obj.toString()) < Integer.parseInt(data.obj.toString())) {
			System.out.println(cur.obj.toString() + ">" + data.obj.toString());
		   // 2 3 7 9   4
			pre = cur;//3
			cur = cur.next;//7
 

		}
	  if(pre==null){
		  first=data;
	  }else{
		  pre.next=data;//3.next=4
	  }
	  data.next=cur;//4.next=7
		 
	}

	public void remove(Object obj) {
		if (obj.equals(first.obj)) {
			first = first.next;
		} else {
			Data pre = first;
			Data cur = first.next;
			while (cur != null) {
				if (cur.obj.equals(obj)) {
					pre.next = cur.next;
					break;
				} else {
					pre = cur;
					cur = cur.next;
				}

			}
		}
	}

	public static void main(String[] args) throws Exception {
		LinkedList ll = new LinkedList();
		ll.insert(199);
		ll.insert(1);
		ll.insert(5);
		ll.insert(2);
 		 
		// ll.insertFirst(8);

		ll.display();

		ll.display();

	}

}

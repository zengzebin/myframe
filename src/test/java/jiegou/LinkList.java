package jiegou;

public class LinkList {
	private class Data {
		private Object obj;
		private Data prev = null;
		private Data next = null;

		Data(Object obj) {
			this.obj = obj;
		}
	}

	private Data header;// 头结点
	private Data tail;// 尾节点
	private int size=0;// 链表中元素个数

	public void add(Object obj) {
		Data data = new Data(obj);
		if (header == null) {
			header = data;
		} else {
			tail.next = data;// 上一个的尾加入
			data.prev = tail;// 这个的前面
//			System.out.println(tail.next);
		}
		tail = data;// 把这个变成最后一个
//		System.out.println(tail.next);
		size++;
	}

	public void addHeader(Object obj) {
		Data data = new Data(obj);
		header.prev = data;
		data.next = header;
		header = data;
		size++;
	}
	
	public void addIndex(int index,Object obj) {
		if(index>size){
			System.out.println("index 有问题");
			return;
		}
		Data insertData = new Data(obj);
		int count=1;
		Data data = header;
		while (data != null) {
			if(index==1){
				insertData.next=header;
				header.prev=insertData;
				header=insertData;
				break;
			} 
			else if(count==index){
				Data prev=data.prev;//获取当前的上一个

 				data.prev=insertData;//当前数据的上一个
 				prev.next=insertData;//上一个的下一个
 				
				insertData.next=data;//新数据的下一个
				insertData.prev=prev;//新数据的上一个

				break;
			} 
			System.out.print(data.obj.toString() + " -> ");
			data = data.next;
			count++;
		}
		size++;
	}

	public void display() {
		System.out.print("header -> tail : ");
		Data data = header;
		while (data != null) {
			System.out.print(data.obj.toString() + " -> ");
			data = data.next;
		}
		System.out.print("\n");
	}
	
	
	public void displayTail() {
		System.out.print("header -> tail : ");
		Data data =tail;
		while (data != null) {
			System.out.print(data.obj.toString() + " -> ");
			data = data.prev;
		}
		System.out.print("\n");
	}
	
	public void remove(int index){
		Data data=header;
		int count=0;
		while (data != null) {
			if(count==index){
				System.out.println("remove index is "+count+" value is "+data.obj.toString());
				Data prev=data.prev;
				prev.next=data.next;
				data.next.prev=prev;
 			    break;
			}
			data = data.next;
			count++;
		}
	}

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
        list.remove(2);
 
        list.displayTail();
	    list.display();
	}

}

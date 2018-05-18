package test;

public class Request {
	private Subject subject;
	
	
	public Request(Subject subject){
		this.subject=subject;
	}
	
	public void show(){
	System.out.println(subject.show());
	}
	

}

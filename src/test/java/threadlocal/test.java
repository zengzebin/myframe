package threadlocal;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreadTest t=new TreadTest("t");
		TreadTest t2=new TreadTest("t2");
		TreadTest t3=new TreadTest("t3");
		t.start();t2.start();t3.start();
		
		
		
	}

}

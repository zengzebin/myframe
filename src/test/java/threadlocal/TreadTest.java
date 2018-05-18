package threadlocal;

public class TreadTest  extends Thread{
	private String name;
	public TreadTest(String name ){
		this.name=name;
	}
	public void run(){
		try {
			System.out.println(name+"=="+ThreadlocalUitl.getUser());

			Thread.sleep(3000);

			System.out.println(name+"=="+ThreadlocalUitl.getUser());
			Thread.sleep(3000);
			System.out.println(name+"=="+ThreadlocalUitl.getUser());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

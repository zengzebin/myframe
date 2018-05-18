package axis2;

/**
 * @author Siuon
 * @version 1.0
 * @create 2012-7-19 下午8:23:49
 */
public class Axis2WB {
	/**
	 * 提供了一个说Hello的服务
	 * 
	 * @return
	 */
	public String sayHello(String name) {
		return "Hello " + name;
	}

	/**
	 * 提供了一个做加法的服务
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int add(int a, int b) {
		return a + b;
	}

}
package Redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import ssxt.com.zeng.bean.SymUser;

public class javaRedis {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("127.0.0.1",7000);
		System.out.println("Connection to server sucessfully");
		// 设置 redis 字符串数据
		jedis.set("年后", "123456");
		/*
		 * jedis.set("大味道", "Redis tutorial"); // 获取存储的数据并输出 System.out.println(
		 * "Stored string in redis:: " + jedis.get("runoobkey"));
		 * 
		 * // 存储数据到列表中 jedis.lpush("tutorial-list", "Redis");
		 * jedis.lpush("tutorial-list", "Mongodb"); jedis.lpush("tutorial-list",
		 * "Mysql"); // 获取存储的数据并输出 List<String> list =
		 * jedis.lrange("tutorial-list", 0, 1); for (int i = 0; i < list.size();
		 * i++) { System.out.println("Stored string in redis:: " + list.get(i));
		 * }
		 */

		/*
		 * SymUser user=new SymUser(); user.setAddvcd("12465465");
		 * user.setLoginId("1"); jedis.set(user.getLoginId().getBytes(),
		 * SerializeUtil.serialize(user));
		 */

		/*byte[] person = jedis.get(("12454").getBytes());
		SymUser user1 = (SymUser) SerializeUtil.unserialize(person);
		System.out.println(user1);*/
	}
}

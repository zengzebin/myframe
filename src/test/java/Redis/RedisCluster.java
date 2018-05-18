package Redis;

import java.util.HashSet;  
//需要再pom.xml中引入jedis依赖  
import redis.clients.jedis.HostAndPort;  
import redis.clients.jedis.JedisCluster;  
import redis.clients.jedis.JedisPool;  
import redis.clients.jedis.JedisPoolConfig;  
public class RedisCluster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  //初始化集合，用于装下面的多个主机和端口  
        HashSet<HostAndPort> nodes = new HashSet<HostAndPort>();  
          
        //创建多个主机和端口实例  
        HostAndPort hostAndPort = new HostAndPort("127.0.0.1", 7000);  
        HostAndPort hostAndPort1 = new HostAndPort("127.0.0.1", 7001);  
        HostAndPort hostAndPort2 = new HostAndPort("127.0.0.1", 7002);  
        HostAndPort hostAndPort3 = new HostAndPort("127.0.0.1", 7003);  
        HostAndPort hostAndPort4 = new HostAndPort("127.0.0.1", 7004);  
        HostAndPort hostAndPort5 = new HostAndPort("127.0.0.1", 7005);  
          
        //添加多个主机和端口到集合中  ./
        nodes.add(hostAndPort);  
        nodes.add(hostAndPort1);  
        nodes.add(hostAndPort2);  
        nodes.add(hostAndPort3);  
        nodes.add(hostAndPort4);  
        nodes.add(hostAndPort5);  
          
        //创建config  
        JedisPoolConfig poolConfig = new JedisPoolConfig();  
        //通过config创建集群实例  
        JedisCluster jedisCluster = new JedisCluster(nodes,poolConfig);  
        jedisCluster.set("567", "你妹的");
        //获取集群中的key为name键的值  
        String str = jedisCluster.get("567");  
        System.out.println(str);  
	}

}

package common.util;
import net.sf.ehcache.Cache;  
import net.sf.ehcache.CacheManager;  
import net.sf.ehcache.Element;
import ssxt.com.zeng.xml.User;
public class EhcacheUtil {
	 public static CacheManager manager = CacheManager.create();  
	 
	 public static  final String myChche="myChche";
	  
	    public static Object get(String cacheName, Object key) {  
	        Cache cache = manager.getCache(cacheName);  
	        if (cache != null) {  
	            Element element = cache.get(key);  
	            if (element != null) {  
	                return element.getObjectValue();  
	            }  
	        }  
	        return null;  
	    }  
	  
	    public static void put(String cacheName, Object key, Object value) {  
	        Cache cache = manager.getCache(cacheName);  
	        if (cache != null) {  
	            cache.put(new Element(key, value));  
	        }  
	    }  
	  
	    public static boolean remove(String cacheName, Object key) {  
	        Cache cache = manager.getCache(cacheName);  
	        if (cache != null) {  
	            return cache.remove(key);  
	        }  
	        return false;  
	    }  
	  
	    public static void main(String[] args) {  
	    	User user1=	(User) EhcacheUtil.get("myCache", "test");
	        String key = "key";  
	        String value = "hello";  
	        EhcacheUtil.put("myCache", key, value);  
	        System.out.println(EhcacheUtil.get("myCache", key));  
	    } 
}

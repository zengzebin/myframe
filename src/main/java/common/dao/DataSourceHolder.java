package common.dao;


/**
 * 数据源操作
 * @author linhy
 */
public class DataSourceHolder {
	//线程本地环境
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();
    public static final String local="local";
    public static final String remote="remote";
    
    //设置数据源
    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
    }
    //获取数据源
    public static String getDataSource() {
        return (String) dataSources.get();
    }
    //清除数据源
    public static void clearDataSource() {
        dataSources.remove();
    }
}

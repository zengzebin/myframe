package axis2;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
  
public class RequestInfoFromMySQL {  
  
    private MySQLUtils mysqlUtils = null;  
    private String nameList[];  
    private String name;  
      
      
    public String getSingleColoumName(){  
        mysqlUtils = new MySQLUtils();  
        Statement statement = mysqlUtils.linkMySQL();  
        String sql = "select AreaName from AREA";  
        try {  
            ResultSet rs = statement.executeQuery(sql);  
            int i = 0;  
            while(rs.next()){  
                name = rs.getString(1);  
                System.out.println(name);  
                i++;  
            }  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            //e.printStackTrace();  
            System.err.println("TableInfoService get出错");  
            System.err.println(e.getMessage());  
        }  
        mysqlUtils.closeMySQL(statement);  
        return name;  
    }  
      
    public String getName(String name){  
        return "test1:"+name;  
    }  
      
}  
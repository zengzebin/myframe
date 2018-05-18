package axis2;
import java.io.Serializable;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
public class TableInfoService implements Serializable{  
  
    private static final long serialVersionUID = 677484458789332877L;  
    private RequestInfoFromMySQL requestInfo = new RequestInfoFromMySQL();  
    private String nameList[];   
      
    public String getSingleColoumName(){  
          
        return requestInfo.getSingleColoumName();  
    }  
      
    public String getName(String name){  
        return requestInfo.getName(name);  
    }  
    
    public static void main(String[] args) {  
    	TableInfoService t=new TableInfoService();
    	t.getSingleColoumName();
    	
    }
      
}  
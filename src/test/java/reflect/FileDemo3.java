package reflect;
import java.io.File;  
public class FileDemo3 {  
	  
    public static void main(String[] args) {  
        File dir=new File("D:\\山西省");  
        //File dir=new File("F:\\");  
        //如果使用上述的盘符的根目录，会出现java.lang.NullPointerException  
        //为什么？  
        getAllFiles(dir,0);//0表示最顶层  
    }  
    //获取层级的方法  
    public static String getLevel(int level)  
    {  
        //A mutable sequence of characters.  
        StringBuilder sb=new StringBuilder();  
        for(int l=0;l<level;l++)  
        {  
            sb.append("|--");  
        }  
        return sb.toString();  
    }  
    public static void getAllFiles(File dir,int level)  
    {  
       System.out.println(getLevel(level)+dir.getName());  
        level++;  
        File[] files=dir.listFiles();  
        for(int i=0;i<files.length;i++)  
        {  
            if(files[i].isDirectory())  
            {  
                //这里面用了递归的算法  
                getAllFiles(files[i],level);  
            }  
            else {  
            	String path=getLevel(level)+files[i];
                if(path.contains(".xls"))
                	System.out.println(path);
            }     
        }          
    }  
    
	 
}

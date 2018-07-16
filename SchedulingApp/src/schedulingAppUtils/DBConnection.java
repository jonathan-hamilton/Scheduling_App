package schedulingAppUtils;
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class DBConnection {  
  private static Connection conn;  
  private static String url = "jdbc:mysql://52.206.157.109:3306/";  
  private static String user = "U03nV2";
  private static String pass = "53688032514"; 
  
  public static Connection connect() throws SQLException{  
    try{  
      Class.forName("com.mysql.jdbc.Driver").newInstance();  
    }catch(ClassNotFoundException cnfe){  
      System.err.println("Error: "+cnfe.getMessage());  
    }catch(InstantiationException ie){  
      System.err.println("Error: "+ie.getMessage());  
    }catch(IllegalAccessException iae){  
      System.err.println("Error: "+iae.getMessage());  
    }  
    conn = DriverManager.getConnection(url,user,pass);
    System.out.println("Successful connection to: " + conn);
	return conn;
  }  
  public static Connection getConnection() throws SQLException, ClassNotFoundException{  
    if(conn !=null && !conn.isClosed())  
      return conn;  
    connect();

    return conn;  
  } 
  public static void main(String[] args)throws SQLException{
	  DBConnection c = new DBConnection();
	  try {
		c.connect();
	} catch (Exception e) {
		System.out.println("Didn't connect");
		e.printStackTrace();
	}
  }
}

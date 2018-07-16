package schedulingAppUtils;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class TestConnection {
    public static void main(String[] argv) throws ClassNotFoundException {
        Connection conn = null;
        String driver = "com.mysql.jdbc.Driver";
        String db = "U03nV2";
        String url = "jdbc:mysql://52.206.157.109/" + db;
        String user = "U03nV2";
        String pass = "53688032514";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connected to database : " + db);
        } catch (SQLException e) {
            System.out.println("SQLException: "+e.getMessage());
            System.out.println("SQLState: "+e.getSQLState());
            System.out.println("VendorError: "+e.getErrorCode());
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnExample.java{
        //database URI connection
        public static String DB_URI="jdbc:mysql://localhost:3306/netID?useSSL=false";
        // database name
        public static String DB_USER ="netID"; 
        // database password
        public static String DB_PASS="password";

        public static void main (String[] args) throws Exception{

        Connection con = null;
        //load the MySQL database driver
        try{
                // Still supported, but not needed for Java 8
                Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(java.lang.ClassNotFoundException e){
                System.err.print("ClassNotFoundException:");
                System.err.print(e.getMessage());
        }
                //use DriverManager to try to establish a connection 
        try{
                con = DriverManager.getConnection(DB_URI,DB_USER,DB_PASS);
                System.out.println("Got Connection.");
        }
        catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
                //close the connection once you'r done
                con.close();
        }

}

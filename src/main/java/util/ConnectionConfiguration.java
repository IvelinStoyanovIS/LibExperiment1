package util;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionConfiguration {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uktcLib", "root", "Kwadrat4e!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }




//    public static Connection getConnection() {
//        try  {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection
//                    ("jdbc:mysql://127.0.0.1:3306/uktcLib",
//                            "root", "Kwadrat4e!");
//            return con;
//        }
//        catch(Exception ex) {
//            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
//            return null;
//        }
//    }
//
//    public static void close(Connection con) {
//        try  {
//            con.close();
//        }
//        catch(Exception ex) {
//        }
//    }

}

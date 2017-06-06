package family.datascience;

import java.sql.*;

/**
 * Created by albertxu on 6/5/17.
 */
public class mysql_conn_test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/test1", "axu", "12345"
            );
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from name");
            while(rs.next())
                System.out.println(rs.getInt(1) + " "+rs.getString(2)+" "+rs.getString(3));
            conn.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

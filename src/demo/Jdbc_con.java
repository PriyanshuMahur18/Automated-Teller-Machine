package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc_con {
    public static Object s;
	//public static final String conn = null;
	Statement smt;  // Declare smt as an instance variable

    public Jdbc_con() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "DEEPU";
            String psw = "oracle";
            Connection con = DriverManager.getConnection(url, user, psw);
            smt = con.createStatement();  // Initialize smt here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


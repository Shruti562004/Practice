package storedProcedure;

import java.sql.*;
import java.util.Scanner;

public class StoredProcedure {
public static void main(String[] args) throws Exception {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/advJava",
        "root",
        "shruti5"
    );

    CallableStatement cs =
        con.prepareCall("{call getComp(?, ?, ?)}");

    // IN parameter
    cs.setInt(1, 1);

    // OUT parameter
    cs.registerOutParameter(2, Types.VARCHAR);

    // INOUT parameter
    cs.setInt(3, 0);
    cs.registerOutParameter(3, Types.INTEGER);

    // Execute procedure
    cs.execute();

    // Get output values
    String name = cs.getString(2);
    int age = cs.getInt(3);

    System.out.println("Name: " + name);
    System.out.println("Age: " + age);

    cs.close();
    con.close();
}


}

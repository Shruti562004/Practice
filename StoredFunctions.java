package storedFunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class StoredFunctions {
public static void main(String[] args) throws Exception {

System.out.println("hjhjhj");
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/advjava",
        "root",
        "shruti5"
    );

    CallableStatement cs =
        con.prepareCall("{? = call com_function(?)}");

    cs.registerOutParameter(1, Types.INTEGER); //registerOutParameter() output receive karne ke liye hota hai, jabki setInt() input value bhejne ke liye hota hai.

    cs.setInt(2, 25);

    cs.execute();

    int result = cs.getInt(1);

    System.out.println("New Age: " + result);

    cs.close();
    con.close();
}


}

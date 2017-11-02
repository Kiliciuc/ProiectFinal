import java.sql.*;
public class Main {
    static int jucatorcount = 1;
    public static void main(String[] args) {
        // Main
        String dbUrl = "jdbc:postgresql:jucator";
        String user = "postgres";
        String password = "Premium150";

        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            if (myStmt == null) {
                System.out.println("    -> MAIN CLASS: myStmt = null");
            } else {
                System.out.println("    -> MAIN CLASS: statement: " + myStmt);
            }
//            ResultSet myRs = myStmt.executeQuery("select * from numejucator");
            //while (myRs.next())
            //jucatorcount++;
           new PaginaPrincipala(myStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

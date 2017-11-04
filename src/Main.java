import java.sql.*;
//Main
public class Main {
    public static void main(String[] args) {
        // Conectare la DB
        String dbUrl = "jdbc:postgresql:jucator";
        String user = "postgres";
        String password = "Premium150";

        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
           new PaginaPrincipala(myStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

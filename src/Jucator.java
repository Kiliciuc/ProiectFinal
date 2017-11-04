import java.sql.SQLException;
import java.sql.Statement;

public class Jucator {
        String nume;

        public Jucator(String Nume) {
            this.nume = nume;
        }
        //inserare in DB
        public void saveJucator(Statement myStmt) {
            String insertDb = "insert into numejucator"
                    + "(nume)"
                    + "values ("
                    + nume + ")";
            try {
                myStmt.executeUpdate(insertDb);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

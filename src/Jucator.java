import java.sql.SQLException;
import java.sql.Statement;

public class Jucator {
        String Nume;

        public Jucator(String Nume) {
            this.Nume = Nume;
        }

        public void saveJucator(Statement myStmt,String numejucator) {
            String insertDb = "insert into nume"
                    + "(nume)"
                    + "values ("
                    + this.Nume + ")";
            try {
                myStmt.executeUpdate(insertDb);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

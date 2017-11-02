import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ListaScor extends JFrame {

    JButton exitButton, backButton;
    Statement myStmt;
    Vector data, row, columnNames;

    public ListaScor(Statement myStmt) {
        this.myStmt = myStmt;
        // Seteaza fereastra Register: titlu, mod de inchidere, dimensiuni si pozitia
        this.setTitle("Student Registration System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,400);
        this.setLocationRelativeTo(null);
        // Creaza main panel panel principal care contine toate celelalte elemente
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.CYAN);

        JPanel listPanel = new JPanel();
        columnNames = new Vector();
        columnNames.add("Nume");
        columnNames.add("Scor");

        try {
            ResultSet myRs = myStmt.executeQuery("select * from numejucator order by scor desc");
            data = new Vector();
            while (myRs.next()) {
                row = new Vector();
                row.add(myRs.getString(1));
                row.add(myRs.getString(2));
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        // Creaza tabel
        JTable jTable = new JTable(data, columnNames);
        jTable.setRowHeight(jTable.getRowHeight() + 10);
        jTable.setFont(new Font("Arial", Font.PLAIN, 18));
        JTableHeader header = jTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 18));
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        listPanel.add(scrollPane);
        mainPanel.add(listPanel,BorderLayout.CENTER);


        // Creaza buttonPanel pentru butoane
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));
        // Butonul "EXIT"
        exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(150,40));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));

        // Butonul "BACK"
        backButton = new JButton("BACK");
        backButton.setPreferredSize(new Dimension(150,40));
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        // Face ca butoanele sa poata fi receptive la events
        ListenForButton listenForButton = new ListenForButton();
        exitButton.addActionListener(listenForButton);
        backButton.addActionListener(listenForButton);
        //Adauga butoane la buttonPanel
        buttonPanel.add(exitButton);
        buttonPanel.add(backButton);
        // Adauga buttonPanel la mainPanel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        // Adauga mainPanel la frame
        this.add(mainPanel);
        // Face fereastra vizibila
        this.setVisible(true);
    }
    // Pentru events
    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Sursa eventului este butonul "EXIT"
            if (e.getSource() == exitButton){
                // Inchide fereastra List
                System.exit(0);
            } else if (e.getSource() == backButton) {
                new PaginaPrincipala(myStmt);
                dispose();
            }
        }
    }






}

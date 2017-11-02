import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class PaginaStart extends  JFrame {
    JButton exitButton, startButton;
    JLabel regulajocului;
    JTextField Regulajocului;
    Statement myStmt;
    String numejucator;

    public PaginaStart(Statement myStmt, String numejucator) {
        this.myStmt = myStmt;
        this.numejucator = numejucator;
        this.setTitle("Descopera Romania");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
//field regula jocului
        JPanel regPanel = new JPanel();
        regPanel.setBackground(Color.white);
        regPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        regulajocului = new JLabel("Regula jocului:");
        regulajocului.setFont(new Font("Arial", Font.BOLD, 16));
        Regulajocului = new JTextField(30);
        Regulajocului.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(regulajocului);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        //button, add start button
        startButton = new JButton("START");
        startButton.setPreferredSize(new Dimension(150, 30));
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(startButton);

        //button, add exit button
        exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(150, 30));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(exitButton);

        //functie button
        ListenForButton1 listenForButton = new ListenForButton1();
        exitButton.addActionListener(listenForButton);
        startButton.addActionListener(listenForButton);

//make visible
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(regPanel);
        this.add(mainPanel);
        this.setVisible(true);
    }

    private class ListenForButton1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitButton) {
                dispose();
            } else if (e.getSource() == startButton) {
                System.out.println("    -> PAGINA START: statement = " + myStmt);
                new Quiz(myStmt,numejucator);
                dispose();//dispare fereastra anterioara
            }


        }
    }
}

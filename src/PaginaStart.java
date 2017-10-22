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

    public PaginaStart(Statement myStmt) {
        this.setTitle("Regula Jocului");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
//field regula jocului
        JPanel regPanel = new JPanel();
        regPanel.setBackground(Color.yellow);
        regPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        regulajocului = new JLabel("XXXXXXXXXXXXXXXX");
        regulajocului.setFont(new Font("Arial", Font.BOLD, 16));
        Regulajocului = new JTextField(30);
        Regulajocului.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(regulajocului);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        //button, add start button
        startButton = new JButton("START");
        startButton.setPreferredSize(new Dimension(150, 40));
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(startButton);

        //button, add exit button
        exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(150, 40));
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
                new Paginaintrebari(myStmt);
                dispose();//dispare fereastra anterioara
            }


        }
    }
}

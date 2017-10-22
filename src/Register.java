/* Fereastra Register */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;

public class Register extends JFrame {

    JButton exit, start;
    JLabel nume;
    JTextField numeField;
    Statement myStmt;


    public Register(Statement myStmt) {
        this.myStmt = myStmt;
        this.setTitle("XXXXXXXXXXXXXXXXXXXXXXXX");
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        //this.setBackground(Color.green);

        //Jlabel
        JLabel mainLabel = new JLabel();
        mainLabel.setSize(900, 600);
        mainLabel.setLayout(new BorderLayout());

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\imi\\Desktop\\Batman.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setContentPane(new JLabel(new ImageIcon(img)));

        Image dimg = img.getScaledInstance(mainLabel.getWidth(), mainLabel.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);
        //Adauga imaginea de fond la mainLabel
        mainLabel.setIcon(imageIcon);
        mainLabel.setLayout(new BorderLayout());
        this.setContentPane(mainLabel);


        //panel
        JPanel text = new JPanel();
        text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
        text.add(Box.createRigidArea(new Dimension(0, 20)));
        //text.add(Box.createVerticalGlue());
        JPanel mainPanel = new JPanel();
        this.setBackground(Color.green);
        mainPanel.setLayout(new BorderLayout());

        //buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 45, 35));

        //LoginPanel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 45, 35));

        //Welcomelabel
        JLabel welcome = new JLabel("XXXXXXXXXXXXXXXXXXXXXXXX");
        welcome.setOpaque(true);
        welcome.setFont(new Font("Arial", Font.BOLD, 28));

        //label
        nume = new JLabel("Nume");
        nume.setFont(new Font("Arial", Font.BOLD, 16));

        //JTextField
        numeField = new JTextField(20);
        numeField.setFont(new Font("Arial", Font.BOLD, 16));

        //button
        exit = new JButton("EXIT");
        exit.setPreferredSize(new Dimension(180, 40));
        exit.setFont(new Font("Arial", Font.PLAIN, 18));

        //button
        start = new JButton("START");
        start.setPreferredSize(new Dimension(180, 40));
        start.setFont(new Font("Arial", Font.PLAIN, 18));

        //listener
        ListenforButton listenforButton = new ListenforButton();
        exit.addActionListener(listenforButton);
        start.addActionListener(listenforButton);


        text.add(welcome);

        mainLabel.add(text, BorderLayout.NORTH);
        loginPanel.add(nume);
        loginPanel.add(numeField);
        loginPanel.add(start);
        mainLabel.add(loginPanel);
        buttonPanel.add(exit);
        //buttonPanel.add(start);
        mainLabel.add(buttonPanel, BorderLayout.SOUTH);

        //this.add(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private class ListenforButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == start) {
                Jucator jucator = new Jucator(numeField.getText());
                jucator.saveJucator(myStmt);
                new PaginaStart(myStmt);
                dispose();
            } else if (e.getSource() == exit) {
                System.exit(0);

            }
        }
    }
}
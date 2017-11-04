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
    BufferedImage img;

    public Register(Statement myStmt) {
        this.myStmt = myStmt;
        // Titlul ferestrei
        this.setTitle("Descopera Romania");
        // Modalitatea de inchidere a ferestrei
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Marimea ferestrei
        this.setSize(900, 600);
        // Pozitioneaza fereastra in centrul ecranului
        this.setLocationRelativeTo(null);

        // Creaza mainPanel - panel principal si introduce poza de fundal
        JLabel mainLabel = new JLabel();
        mainLabel.setSize(900, 600);
        try {
            img = ImageIO.read(new File("C:\\Users\\imi\\IdeaProjects\\ProiectFinal\\src\\romania1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Modifica dimensiunile la imaginea de fundal
        Image dimg = img.getScaledInstance(mainLabel.getWidth(), mainLabel.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        // Adauga imaginea de fond la mainLabel
        mainLabel.setIcon(imageIcon);
        mainLabel.setLayout(new BorderLayout());
        this.setContentPane(mainLabel);
        //Creaza JPanel
        JPanel text = new JPanel();
        text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
        text.add(Box.createRigidArea(new Dimension(50, 20)));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainLabel.setOpaque(false);

        //Creaza buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 45, 25));
        buttonPanel.setOpaque(false);

        //Creaza LoginPanel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 25));
        loginPanel.setOpaque(false);

        //Creaza JLabel Welcome

        JLabel welcome = new JLabel("Te rog sa introduci numele tau");
        welcome.setLayout(new FlowLayout(FlowLayout.TRAILING, 25, 25));
        welcome.setOpaque(false);
        welcome.setFont(new Font("Arial", Font.BOLD, 22));

        //Creaza JLabel
        nume = new JLabel("Nume");
        nume.setFont(new Font("Arial", Font.BOLD, 20));
        nume.setForeground( Color.WHITE );
        nume.setOpaque(false);

        //Creaza JTextField
        numeField = new JTextField(20);
        numeField.setFont(new Font("Arial", Font.BOLD, 16));

        //Creaza button "EXIT"
        exit = new JButton("EXIT");
        exit.setPreferredSize(new Dimension(150, 30));
        exit.setFont(new Font("Arial", Font.PLAIN, 18));

        //Creaza button "START"
        start = new JButton("START");
        start.setPreferredSize(new Dimension(150, 30));
        start.setFont(new Font("Arial", Font.PLAIN, 18));

        //Creaza ActionListener
        ListenforButton listenforButton = new ListenforButton();
        exit.addActionListener(listenforButton);
        start.addActionListener(listenforButton);

        //Adauna la Panel
        text.add(welcome);
        mainLabel.add(text, BorderLayout.NORTH);
        loginPanel.add(nume);
        loginPanel.add(numeField);
        loginPanel.add(start);
        mainLabel.add(loginPanel);
        buttonPanel.add(exit);
        mainLabel.add(buttonPanel, BorderLayout.SOUTH);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private class ListenforButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                Jucator jucator = new Jucator(numeField.getText());
            new Quiz(myStmt,numeField.getText());
                dispose(); }
            }
        }


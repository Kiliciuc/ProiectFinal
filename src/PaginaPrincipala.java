import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;


public class PaginaPrincipala extends JFrame {
    JButton exitButton, startButton, scorButton;
    BufferedImage img;
    Statement myStmt;

    public PaginaPrincipala(Statement myStmt) {
        this.myStmt = myStmt;
        // Titlul ferestrei
        this.setTitle("Descopera Romania");
        // Modalitatea de inchidere a ferestrei
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Marimea ferestrei
        this.setSize(900, 600);
        // Pozitioneaza fereastra in centrul ecranului
        this.setLocationRelativeTo(null);
        // Creaza mainPanel - panel principal care include toate elementele
        JLabel mainLabel = new JLabel();
        mainLabel.setSize(900, 600);
        try {
            img = ImageIO.read(new File("C:\\Users\\imi\\IdeaProjects\\ProiectFinal\\src\\romania1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Modifica dimensiunile la imaginea de background
        Image dimg = img.getScaledInstance(mainLabel.getWidth(), mainLabel.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        // Adauga imaginea de fond la mainLabel
        mainLabel.setIcon(imageIcon);
        mainLabel.setLayout(new BorderLayout());
        this.setContentPane(mainLabel);

       //creare JPanel
        JPanel buttonPanel = new JPanel();
        // Precizeaza layout pentru buttonPanel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 100, -1));
        buttonPanel.setOpaque( false );
        // Butonul exit
        exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(150, 40));
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setOpaque( false );
        //Butonul start
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(150, 40));
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setOpaque( false );
        //Butonul List scor
        scorButton = new JButton("Scor");
        scorButton.setPreferredSize(new Dimension(150, 40));
        scorButton.setFont(new Font("Arial", Font.BOLD, 18));
        scorButton.setOpaque( false );

        // Face ca butoanele sa poata fi receptive la events
        ListenForButton listenForButton = new ListenForButton();
        exitButton.addActionListener(listenForButton);
        startButton.addActionListener(listenForButton);
        scorButton.addActionListener( listenForButton );

        // Adauga butoanele la buttonPanel
        buttonPanel.add(exitButton);
        buttonPanel.add(startButton);
        buttonPanel.add(scorButton);
        mainLabel.add(buttonPanel, BorderLayout.SOUTH);
        //mainLabel.add(welcomeLabel);
        // Face fereastra vizibila
        this.pack();
        this.setVisible(true);
    }

    // Creare de evenimente
    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitButton) {
                // Inchide fereastra PaginaPrincipala
                System.exit(0);

            }// Sursa eventului este butonul "Start"
            else if (e.getSource() == startButton) {
                // Deschide fereastra Register
                new Register(myStmt);
                // Inchide fereastra Welcome
                dispose();
                //Deschide fereatra
            } else if (e.getSource() == scorButton) {
                new ListaScor(myStmt);
                dispose();
            }
        }
    }
}


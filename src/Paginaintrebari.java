import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class Paginaintrebari extends JFrame {
    JButton nextButton;
    JLabel Intrebare, IntrebareField;
    Statement myStmt;
    JRadioButton r1,r2,r3,r4;

    public Paginaintrebari(Statement myStmt) {
        this.myStmt = myStmt;

        this.setTitle( "XXXXXXXXXXXXXXXXXXXXX" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( 600, 400 );
        this.setLocationRelativeTo( null );
        // Creaza main panel panel principal care contine toate celelalte elemente
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout( new BorderLayout() );
        mainPanel.setBackground( Color.CYAN );
        // Creaza regPanel pentru elementele principale din fereastra
        JPanel regPanel = new JPanel();
        regPanel.setBackground( Color.CYAN );
        regPanel.setLayout( new FlowLayout( FlowLayout.LEFT, 15, 20 ) );
        // Creaza textul "Intrebare"
        Intrebare = new JLabel( "Intrebare" );
        Intrebare.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( Intrebare );
        IntrebareField = new JLabel( "Care este resedinta de judet pentru judetul Cluj?" );
        regPanel.add( IntrebareField );
        mainPanel.add( regPanel, BorderLayout.CENTER );
        // Creaza buttonPanel pentru butoane
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout( new FlowLayout( FlowLayout.CENTER, 10, 20 ) );
        // Butonul "NEXT"
        nextButton = new JButton( "NEXT" );
        nextButton.setPreferredSize( new Dimension( 150, 40 ) );
        nextButton.setFont(new Font("Arial", Font.PLAIN, 18));
        //nextButton.addActionListener(listenForButton);
        // Adauga butoanele la buttonPanel
        buttonPanel.add( nextButton );
        // adauga buttonPanel la mainPanel
        mainPanel.add( buttonPanel, BorderLayout.SOUTH );
        // Adauga mainPanel la Frame
        this.add( mainPanel );
        // Face fereastra vizibila
        this.setVisible( true );

        //o varinata cu care am incercat sa fac 4 radiobutton
       /* JRadioButton r1 =new JRadioButton();
        r1.setText("Cluj-Napoca");
        JRadioButton r2 =new JRadioButton("Cluj-Napoca");
        JRadioButton r3 =  new JRadioButton();
        r3.setText("Huedin");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);


        mainPanel.add(r1, BorderLayout.CENTER);
        mainPanel.add(r2,BorderLayout.CENTER);
        mainPanel.add(r3,BorderLayout.CENTER);*/

       // this.getContentPane(add(mainPanel));
        //this.add(  )


// o alta varianta in care am incercat sa fac 4 radiobutton
    /*public class Radio extends JFrame{

        public Radio() {
            r1 = new JRadioButton( "Cluj-Napoca" );
            r2 = new JRadioButton( "Alba-Iulia" );
            r3 = new JRadioButton( "Zalau" );
            r4 = new JRadioButton( "Satu Mare" );
            ButtonGroup ButtonGroup = new ButtonGroup();

            ButtonGroup.add( r1 );
            ButtonGroup.add( r2 );
            ButtonGroup.add( r3 );
            ButtonGroup.add( r4 );


            setLayout( new FlowLayout() );
            setVisible( true );
            setSize( 400, 400 );
            setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        }*/


    }

    // Pentru events
    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Sursa eventului este butonul "NEXT"
            if (e.getSource() == nextButton) {
                //mai trebe creat o alta pagina
            }
        }
    }
}



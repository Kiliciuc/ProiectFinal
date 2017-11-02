
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
class  Quiz extends JFrame implements ActionListener {
    JPanel panel;
    JPanel panelresult;
    JRadioButton choice1;
    JRadioButton choice2;
    JRadioButton choice3;
    JRadioButton choice4;
    ButtonGroup bg;
    JLabel lblmess;
    JButton btnext;
    String[][] qpa;
    String[][] qca;
    int qaid;
    HashMap<Integer, String> map;
    Statement myStmt;
    String numejucator;

    Quiz(Statement myStmt, String numejucator) {
        this.myStmt = myStmt;
        this.numejucator = numejucator;
        initializedata();
        setTitle( "Descopera Romania" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setSize( 900, 600 );
        setLocation( 300, 100 );
        setResizable( false );
        Container cont = getContentPane();
        cont.setLayout( new BorderLayout() );
        cont.setBackground( Color.GRAY );
        bg = new ButtonGroup();
        choice1 = new JRadioButton( "Choice1", false );
        choice1.setFont( new Font( "Arial", Font.BOLD, 18 ) );
        choice2 = new JRadioButton( "Choice2", false );
        choice2.setFont( new Font( "Arial", Font.BOLD, 18 ) );
        choice3 = new JRadioButton( "Choice3", false );
        choice3.setFont( new Font( "Arial", Font.BOLD, 18 ) );
        choice4 = new JRadioButton( "Choice4", false );
        choice4.setFont( new Font( "Arial", Font.BOLD, 18 ) );
        bg.add( choice1 );
        bg.add( choice2 );
        bg.add( choice3 );
        bg.add( choice4 );
        lblmess = new JLabel( "Alege raspunsul corect" );
        lblmess.setForeground( Color.BLACK );
        lblmess.setFont( new Font( "Arial", Font.BOLD, 22 ) );
        btnext = new JButton( "Urmatoarea intrebare" );
        btnext.setForeground( Color.BLACK );
        btnext.setFont( new Font( "Arial", Font.BOLD, 20 ) );
        btnext.addActionListener( this );
        panel = new JPanel();
        panel.setBackground( Color.white );
        panel.setLocation( 10, 10 );
        panel.setSize( 900, 600 );
        panel.setLayout( new GridLayout( 6, 2 ) );
        panel.add( lblmess );
        panel.add( choice1 );
        panel.add( choice2 );
        panel.add( choice3 );
        panel.add( choice4 );
        panel.add( btnext );
        cont.add( panel );
        setVisible( true );
        qaid = 0;
        readqa( qaid );

    }

    public void actionPerformed(ActionEvent e) {

        if (btnext.getText().equals( "Urmatoarea intrebare" )) {
            if (qaid < 9) {

                map.put( qaid, getSelection() );
                qaid++;
                readqa( qaid );
            } else {
                map.put( qaid, getSelection() );
                btnext.setText( "Afiseaza rezultatul" );

            }
        } else if (btnext.getText().equals( "Afiseaza rezultatul" )) {
            new Report();
            dispose();

        }

    }


    public void initializedata() {
        //qpa stores pairs of question and its possible answers
        qpa = new String[10][5];

        qpa[0][0] = "Care este resedinta de judet pentru judetul Cluj?";
        qpa[0][1] = "Cluj-Napoca";
        qpa[0][2] = "Targu Mures";
        qpa[0][3] = "Turda";
        qpa[0][4] = "Huedin";

        qpa[1][0] = "Cel mai inalt varf muntos din Romania este?";
        qpa[1][1] = "Vf.Mare";
        qpa[1][2] = "Vf.Moldoveanu";
        qpa[1][3] = "Vf.Stoinița";
        qpa[1][4] = "Vf.Bucura";

        qpa[2][0] = "Care este tara cu care se invecineza Romania la Nord?";
        qpa[2][1] = "Marea Neaga";
        qpa[2][2] = "Republica Moldova";
        qpa[2][3] = "Ucraina";
        qpa[2][4] = "Ungaria";

        qpa[3][0] = "In ce an a aderat Romania la UE?";
        qpa[3][1] = "2000";
        qpa[3][2] = "2005";
        qpa[3][3] = "2006";
        qpa[3][4] = "2007";

        qpa[4][0] = "Ce semnifica ziua de 1 Decembrie pentru Romania?";
        qpa[4][1] = "prima zi din luna Decembrie";
        qpa[4][2] = "ziua lui M.Eminescu";
        qpa[4][3] = "ziua nationala a Romaniei";
        qpa[4][4] = "prima zi de iarna in Romania";

        qpa[5][0] = "Mihai Eminescu este considerat?";
        qpa[5][1] = "cel mai mare luptator din istoria Romaniei";
        qpa[5][2] = "cel mai mare conducator din tara Moldovei";
        qpa[5][3] = "cel mai competent presedinte a Romaniei";
        qpa[5][4] = "cel mai mare poet a Romaniei";

        qpa[6][0] = "Care este populatia Romaniei(conform recesamantului din 2011)?";
        qpa[6][1] = "15.589.475";
        qpa[6][2] = "20.121.641";
        qpa[6][3] = "19.968.002";
        qpa[6][4] = "85.254.975";

        qpa[7][0] = "Cum se numeste lantul muntos care se afla pe teritoriul Romaniei?";
        qpa[7][1] = "Alpi";
        qpa[7][2] = "Carpati";
        qpa[7][3] = "Balcani";
        qpa[7][4] = "Romanasi";

        qpa[8][0] = "Cand s-a nascut Regele Mihai I?";
        qpa[8][1] = "25.10.1921";
        qpa[8][2] = "25.10.1922";
        qpa[8][3] = "25.10.1923";
        qpa[8][4] = "25.10.1924";

        qpa[9][0] = "Ce-a mai mare cladire din Romania este?";
        qpa[9][1] = "Casa Poporului";
        qpa[9][2] = "Palatul Poporului";
        qpa[9][3] = "Conacul lui Mircea Eliade";
        qpa[9][4] = "Castelul Romanilor";


        //qca stores pairs of question and its correct answer
        qca = new String[10][2];

        qca[0][0] = "Care este resedinta de judet pentru judetul Cluj?";
        qca[0][1] = "Cluj-Napoca";

        qca[1][0] = "Cel mai inalt varf muntos din Romania este?";
        qca[1][1] = "Vf.Moldoveanu";

        qca[2][0] = "Care este tara cu care se invecineza Romania la Nord?";
        qca[2][1] = "Ucraina";

        qca[3][0] = "In ce an a aderat Romania la UE?";
        qca[3][1] = "2007";


        qca[4][0] = "Ce semnifica ziua de 1 Decembrie pentru Romania?";
        qca[4][1] = "ziua nationala a Romaniei";

        qca[5][0] = "Mihai Eminescu este considerat?";
        qca[5][1] = "cel mai mare poet a Romaniei";

        qca[6][0] = "Care este populatia Romaniei(conform recesamantului din 2011)?";
        qca[6][1] = "20.212.641";

        qca[7][0] = "Cum se numeste lantul muntos care se afla pe teritoriul Romaniei?";
        qca[7][1] = "Carpati";

        qca[8][0] = "Cand s-a nascut Regele Mihai I?";
        qca[8][1] = "25.10.1921";

        qca[9][0] = "Ce-a mai mare cladire din Romania este?";
        qca[9][1] = "Casa Poporului";


        //create a map object to store pairs of question and selected answer
        map = new HashMap<Integer, String>();

    }

    public String getSelection() {
        String selectedChoice = null;
        Enumeration<AbstractButton> buttons = bg.getElements();
        while (buttons.hasMoreElements()) {
            JRadioButton temp = (JRadioButton) buttons.nextElement();
            if (temp.isSelected()) {
                selectedChoice = temp.getText();
            }
        }
        return (selectedChoice);
    }


    public void readqa(int qid) {
        lblmess.setText( "  " + qpa[qid][0] );
        choice1.setText( qpa[qid][1] );
        choice2.setText( qpa[qid][2] );
        choice3.setText( qpa[qid][3] );
        choice4.setText( qpa[qid][4] );
        choice1.setSelected( false );
    }

    public void reset() {
        qaid = 0;
        map.clear();
        readqa( qaid );
        //btnext.setText("xxxxxxxxxx");
    }

    public int calCorrectAnswer() {
        int qnum = 10;
        int count = 1;
        for (int qid = 0; qid < qnum; qid++)
            if (qca[qid][1].equals( map.get( qid ) )) count++;
        return count;
    }

    public class Report extends JFrame {
        Report() {
            setTitle( "Rezultat" );
            setSize( 1000, 550 );
            setBackground( Color.WHITE );
            this.setLocationRelativeTo( null );
            addWindowListener( new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
//                    System.exit( 0 ); // ------>
                    new PaginaPrincipala( myStmt );
                    reset();
                }
            } );
            Draw d = new Draw();
            add( d );
            setVisible( true );
        }

        class Draw extends Canvas {
            public void paint(Graphics g) {
                int qnum = 10;
                int x = 10;
                int y = 20;
                for (int i = 0; i < qnum; i++) {
                    //print the 1st column
                    g.setFont( new Font( "Arial", Font.BOLD, 14 ) );
                    g.drawString( i + 1 + ". " + qca[i][0], x, y );
                    y += 30;
                    g.setFont( new Font( "Arial", Font.PLAIN, 14 ) );
                    g.drawString( "      Raspunsul corect:" + qca[i][1], x, y );
                    y += 30;
                    g.drawString( "      Raspunsul tau:" + map.get( i ), x, y );
                    y += 30;

                    //print the 2nd column
                    if (y > 400) {
                        y = 20;
                        x = 450;
                    }

                }
                //Show number of correct answers
                int scor = calCorrectAnswer();
                g.setColor( Color.BLUE );
                g.setFont( new Font( "Arial", Font.BOLD, 14 ) );
                g.drawString( "Numarul raspunsurilor corecte:" + scor, 300, 500 );
                //////////////////////
                String insertDb = "insert into numejucator(nume,scor) values ('" + numejucator + "'," + scor + ")";
                //String insertDb = "insert into numejucator" + "(nume)" + "values ('" + numejucator + ")";
               //String insertDb2 ="insert into numejucator (nume) values ('cthrth')";
                System.out.println(insertDb);
                try {
                    System.out.println("    -> BEFORE execute update");

                    System.out.println("    -> QUIZ: statement = " + myStmt);
                    myStmt.executeUpdate(insertDb);
                    System.out.println("    -> AFTER execute update");
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        }
    }
}





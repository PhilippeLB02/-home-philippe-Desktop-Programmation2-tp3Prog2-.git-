import javax.swing.*;

public class FenetreFaireTests {

    private final static int LARGEUX_FENTRE = 550;
    private final static int HAUTEUR_FENETRE = 540;
    private final static int LARG_BTN = 50;
    private final static int HAUT_BTN = 30;
    private final static int LARG_BTN_CORR = 150;


    private JFrame fenetreFaireTest;

    private JLabel nomDuTest;

    private JButton boutonPrecedent;
    private JButton boutonSuivant;
    private JButton boutonCorrection;

    public FenetreFaireTests(String nomTest){
        init(nomTest);
    }

    private void init(String nomTest){

        fenetreFaireTest = new JFrame("Faire un test");
        fenetreFaireTest.setBounds(400,300,LARGEUX_FENTRE,HAUTEUR_FENETRE);
        fenetreFaireTest.setResizable(false);
        fenetreFaireTest.setLocationRelativeTo(null);

        fenetreFaireTest.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetreFaireTest.setLayout(null);

        //nom du test a faire
        nomDuTest = new JLabel(nomTest);

        nomDuTest.setBounds(fenetreFaireTest.getWidth() / 12, fenetreFaireTest.getHeight() / 13 - HAUT_BTN,
                LARG_BTN_CORR, HAUT_BTN);
        fenetreFaireTest.getContentPane().add(nomDuTest);

        //Boutons
        boutonPrecedent = new JButton("<");
        boutonSuivant = new JButton(">");
        boutonCorrection = new JButton("Corriger le test");

        boutonPrecedent.setBounds(fenetreFaireTest.getWidth() / 12 * 5 - LARG_BTN / 2, fenetreFaireTest.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonSuivant.setBounds(fenetreFaireTest.getWidth() / 12 * 7 - LARG_BTN / 2, fenetreFaireTest.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonCorrection.setBounds(fenetreFaireTest.getWidth() / 2 - LARG_BTN_CORR / 2 - 4, fenetreFaireTest.getHeight() / 13 * 12 - HAUT_BTN,
                LARG_BTN_CORR, HAUT_BTN);

        fenetreFaireTest.getContentPane().add(boutonPrecedent);
        fenetreFaireTest.getContentPane().add(boutonSuivant);
        fenetreFaireTest.getContentPane().add(boutonCorrection);


        fenetreFaireTest.setVisible(true);
    }
}

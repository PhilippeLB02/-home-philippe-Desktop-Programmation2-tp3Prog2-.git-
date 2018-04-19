import javax.swing.*;

public class FenetreFaireTests {

    private final static int LARGEUX_FENTRE = 550;
    private final static int HAUTEUR_FENETRE = 540;
    private final static int LARG_BTN = 50;
    private final static int HAUT_BTN = 30;
    private final static int LARG_BTN_CORR = 150;


    private JFrame fenetreFaireTest;


    private JLabel nomDuTest;
    private JTextField nomTests;

    //JPANEL
    private JPanel panneauDesQuestion;


    private JButton boutonPrecedent;
    private JButton boutonSuivant;
    private JButton boutonCorrection;

    //Enoncé
    private JLabel QUESTION;
    private int numeroQuestion = 1;
    private JLabel enoncer;
    private JTextArea question;

    //Reponse
    private JLabel reponse;
    private JLabel reponse1;
    private JLabel reponse2;
    private JLabel reponse3;
    private JLabel reponse4;
    private JTextField reponseUn;
    private JTextField reponseDeux;
    private JTextField reponseTrois;
    private JTextField reponseQuatre;

    //Boutons radio
    private JRadioButton repBout1;
    private JRadioButton repBout2;
    private JRadioButton repBout3;
    private JRadioButton repBout4;

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


        //Titre test
        nomDuTest = new JLabel("Nom du test ");
        nomTests = new JTextField();

        nomDuTest.setBounds(fenetreFaireTest.getWidth() / 12 , fenetreFaireTest.getHeight() / 13 - HAUT_BTN, 200, HAUT_BTN);
        nomTests.setBounds(fenetreFaireTest.getWidth() / 12 * 3, fenetreFaireTest.getHeight() / 13 - HAUT_BTN, 350, HAUT_BTN);

        fenetreFaireTest.getContentPane().add(nomDuTest);
        fenetreFaireTest.getContentPane().add(nomTests);


        //Enoncer
        QUESTION = new JLabel("Question " + numeroQuestion);
        QUESTION.setBounds(10, 10, 200, HAUT_BTN);
        enoncer = new JLabel("Énoncé ");
        enoncer.setBounds(25, 40, 200, HAUT_BTN);
        question = new JTextArea();
        question.setLineWrap(true);
        question.setEditable(true);
        question.setBounds(25, 80, 400, HAUT_BTN * 2);


        panneauDesQuestion = new JPanel();
        panneauDesQuestion.setBounds(50,50, 450, 350);
        panneauDesQuestion.setOpaque(true);
        panneauDesQuestion.setLayout(null);


        QUESTION = new JLabel("Question " + numeroQuestion);
        QUESTION.setBounds(10, 10, 200, HAUT_BTN);
        enoncer = new JLabel("Énoncé ");
        enoncer.setBounds(25, 40, 200, HAUT_BTN);
        question = new JTextArea();
        question.setLineWrap(true);
        question.setEditable(true);
        question.setBounds(25, 80, 400, HAUT_BTN * 2);

        panneauDesQuestion.add(QUESTION);
        panneauDesQuestion.add(enoncer);
        panneauDesQuestion.add(question);

        //Reponse
        reponse = new JLabel("Choix de réponses (Cocher la bonne réponse) ");
        reponse.setBounds(10, 150, 400, HAUT_BTN);
        reponse1 = new JLabel("1) ");
        reponse1.setBounds(10, 190, LARG_BTN, HAUT_BTN);
        reponse2 = new JLabel("2) ");
        reponse2.setBounds(10, 230, LARG_BTN, HAUT_BTN);
        reponse3 = new JLabel("3) ");
        reponse3.setBounds(10, 270, LARG_BTN, HAUT_BTN);
        reponse4 = new JLabel("4) ");
        reponse4.setBounds(10, 310, LARG_BTN, HAUT_BTN);
        reponseUn = new JTextField(35);
        reponseUn.setBounds(70, 190, 310, HAUT_BTN);
        reponseDeux = new JTextField(35);
        reponseDeux.setBounds(70, 230, 310, HAUT_BTN);
        reponseTrois = new JTextField(35);
        reponseTrois.setBounds(70, 270, 310, HAUT_BTN);
        reponseQuatre = new JTextField(35);
        reponseQuatre.setBounds(70, 310, 310, HAUT_BTN);
        repBout1 = new JRadioButton();
        repBout1.setBounds(390, 190, LARG_BTN, HAUT_BTN);
        repBout2 = new JRadioButton();
        repBout2.setBounds(390, 230, LARG_BTN, HAUT_BTN);
        repBout3 = new JRadioButton();
        repBout3.setBounds(390, 270, LARG_BTN, HAUT_BTN);
        repBout4 = new JRadioButton();
        repBout4.setBounds(390, 310, LARG_BTN,HAUT_BTN);

        panneauDesQuestion.add(reponse);
        panneauDesQuestion.add(reponse1);
        panneauDesQuestion.add(reponseUn);
        panneauDesQuestion.add(repBout1);
        panneauDesQuestion.add(reponse2);
        panneauDesQuestion.add(reponseDeux);
        panneauDesQuestion.add(repBout2);
        panneauDesQuestion.add(reponse3);
        panneauDesQuestion.add(reponseTrois);
        panneauDesQuestion.add(repBout3);
        panneauDesQuestion.add(reponse4);
        panneauDesQuestion.add(reponseQuatre);
        panneauDesQuestion.add(repBout4);




        panneauDesQuestion.add(QUESTION);
        panneauDesQuestion.add(enoncer);
        panneauDesQuestion.add(question);

        //nom du test a faire
        //nomDuTest = new JLabel(nomTest);
        nomDuTest.setBounds(fenetreFaireTest.getWidth() / 12, fenetreFaireTest.getHeight() / 13 - HAUT_BTN,
                450, HAUT_BTN);
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
        fenetreFaireTest.add(panneauDesQuestion);

        fenetreFaireTest.setVisible(true);
    }
}

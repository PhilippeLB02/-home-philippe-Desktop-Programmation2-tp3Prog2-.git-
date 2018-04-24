import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreFaireTests {

    //Atributs d'instence pour les dimension de la fenetre
    private final static int LARGEUR_FENTRE = 550;
    private final static int HAUTEUR_FENETRE = 540;
    private final static int LARG_BTN = 50;
    private final static int HAUT_BTN = 30;
    private final static int LARG_BTN_CORR = 150;

    //Nom de la fenetre pour faire un test
    private JFrame fenetreFaireTest;

    //le nom du test a faire
    private JLabel nomDuTest;
    private JTextField nomTests;

    //JPANEL
    private JPanel panneauDesQuestion;
    private JPanel encadreHaut;
    private JPanel panRes;
    private JPanel ligne;

    //JButton pour naviger dans les question
    private JButton boutonPrecedent;
    private JButton boutonSuivant;
    private JButton boutonCorrection;
    private JButton boutonRevenir;

    //Enoncé
    private JLabel lQuestion;
    private JLabel lNumeroQuestion;
    private JLabel enoncer;
    private JTextArea question;
    private JTextArea resultat;


    //Reponse
    private JLabel reponse;
    private JLabel reponse1;
    private JLabel reponse2;
    private JLabel reponse3;
    private JLabel reponse4;
    private JLabel lResult;
    private JTextField reponseUn;
    private JTextField reponseDeux;
    private JTextField reponseTrois;
    private JTextField reponseQuatre;
    private int []tabRep;

    private JScrollPane spQuestion;
    private JScrollPane spResultat;

    //Boutons radio
    private JCheckBox repBout1;
    private JCheckBox repBout2;
    private JCheckBox repBout3;
    private JCheckBox repBout4;
    private ButtonGroup groupBouton;

    //test a réaliser
    private Test testFenetre;
    private String []choixReponseTest;

    /**
     * initialise la fenetre pour faire un test
     * @param test le test a réaliser
     */
    public FenetreFaireTests(Test test){
        testFenetre = test;
        choixReponseTest = new String[4];
        tabRep  = new int[testFenetre.getNbQuestion()];
        init(testFenetre);
    }

    /**
     * créer la fenetre du test a faire et met les question et les choix de reponse dans la fenetre
     * @param test le test qui va etre réaliser
     */
    private void init(Test test){

        //Dimension et position de la fenetre
        fenetreFaireTest = new JFrame("Passer un test");
        fenetreFaireTest.setBounds(400,300,LARGEUR_FENTRE,HAUTEUR_FENETRE);
        fenetreFaireTest.setResizable(false);
        fenetreFaireTest.setLocationRelativeTo(null);
        fenetreFaireTest.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetreFaireTest.setLayout(null);

        //Titre test
        nomDuTest = new JLabel("Nom du test ");
        nomTests = new JTextField();

        nomDuTest.setBounds(20 , fenetreFaireTest.getHeight() / 13 -20, 200, HAUT_BTN);
        nomTests.setBounds(fenetreFaireTest.getWidth() / 12 * 3, fenetreFaireTest.getHeight() / 13 - 20, 350, HAUT_BTN);
        nomTests.setText(testFenetre.getName());
        nomTests.setEditable(false);
        fenetreFaireTest.getContentPane().add(nomDuTest);
        fenetreFaireTest.getContentPane().add(nomTests);


        //Enoncer
        lQuestion = new JLabel("QUESTION");
        lQuestion.setBounds(30, 80, 200, HAUT_BTN);
        lQuestion.setFont(new Font(lQuestion.getFont().getFamily(),Font.PLAIN,15));

        lNumeroQuestion = new JLabel("0");
        lNumeroQuestion.setBounds(130, 80, 200, HAUT_BTN);
        lNumeroQuestion.setFont(new Font(lQuestion.getFont().getFamily(),Font.BOLD,15));

        enoncer = new JLabel("Énoncé ");
        enoncer.setBounds(20, 4, 200, HAUT_BTN);
        question = new JTextArea();
        question.setLineWrap(true);
        question.setEditable(false);
        testFenetre.setQuestionCourante(0);
        question.setText(testFenetre.getQuestion().get(testFenetre.getQuestionCourante()));
        question.setWrapStyleWord(true);
        question.setLineWrap(true);

        spQuestion = new JScrollPane(question);
        spQuestion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spQuestion.setBounds(20, 35, 480, HAUT_BTN * 2);

        resultat = new JTextArea();
        resultat.setEditable(false);

        spResultat = new JScrollPane(resultat);
        spResultat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spResultat.setBounds(30,120,490,310);
        spResultat.setBorder(BorderFactory.createLineBorder(Color.black,1));
        spResultat.setVisible(false);

        panneauDesQuestion = new JPanel();
        panneauDesQuestion.setBounds(20,110, 510, 285);
        panneauDesQuestion.setLayout(null);
        panneauDesQuestion.setBorder(BorderFactory.createLineBorder(Color.black,1));


        panneauDesQuestion.add(enoncer);
        panneauDesQuestion.add(spQuestion);

        panRes = new JPanel();
        panRes.setBounds(20,110, 510, 330);
        panRes.setBorder(BorderFactory.createLineBorder(Color.black,1));
        panRes.setVisible(false);

        ligne = new JPanel();
        encadreHaut = new JPanel();

        lResult = new JLabel("RÉSULTAT DU TEST");
        lResult.setFont(new Font(lQuestion.getFont().getFamily(),Font.BOLD,15));
        encadreHaut.setBounds(20,80,510,250);
        encadreHaut.setBorder(BorderFactory.createLineBorder(Color.black,1));
        encadreHaut.add(lResult);
        lResult.setBounds(encadreHaut.getWidth()/2,80,100,20);
        lResult.setVisible(false);

        //Reponse
        reponse = new JLabel("Choix de réponses (cochez la bonne réponse) ");
        reponse.setBounds(20, 100, 400, HAUT_BTN);
        reponse1 = new JLabel("1) ");
        reponse1.setBounds(30, 137, LARG_BTN, HAUT_BTN);
        reponse2 = new JLabel("2) ");
        reponse2.setBounds(30, 167, LARG_BTN, HAUT_BTN);
        reponse3 = new JLabel("3) ");
        reponse3.setBounds(30, 197, LARG_BTN, HAUT_BTN);
        reponse4 = new JLabel("4) ");
        reponse4.setBounds(30, 227, LARG_BTN, HAUT_BTN);
        reponseUn = new JTextField(35);
        reponseUn.setBounds(50, 139, 365, 25);
        reponseUn.setEditable(false);
        reponseDeux = new JTextField(35);
        reponseDeux.setBounds(50, 169, 365, 25);
        reponseDeux.setEditable(false);
        reponseTrois = new JTextField(35);
        reponseTrois.setBounds(50, 199, 365, 25);
        reponseTrois.setEditable(false);
        reponseQuatre = new JTextField(35);
        reponseQuatre.setEditable(false);
        reponseQuatre.setBounds(50, 229, 365, 25);
        repBout1 = new JCheckBox();
        repBout1.setBounds(420, 137, LARG_BTN, HAUT_BTN);
        repBout2 = new JCheckBox();
        repBout2.setBounds(420, 167, LARG_BTN, HAUT_BTN);
        repBout3 = new JCheckBox();
        repBout3.setBounds(420, 197, LARG_BTN, HAUT_BTN);
        repBout4 = new JCheckBox();
        repBout4.setBounds(420, 227, LARG_BTN,HAUT_BTN);
        groupBouton = new ButtonGroup();
        groupBouton.add(repBout1);
        groupBouton.add(repBout2);
        groupBouton.add(repBout3);
        groupBouton.add(repBout4);

        afficherQuestion(0);

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


        fenetreFaireTest.getContentPane().add(nomDuTest);

        //Boutons
        boutonPrecedent = new JButton("<");
        boutonSuivant = new JButton(">");
        boutonPrecedent.setEnabled(false);
        boutonCorrection = new JButton("Corriger le test");
        boutonRevenir = new JButton("Revenir au test");


        boutonPrecedent.setBounds((fenetreFaireTest.getWidth() / 12 * 5 - LARG_BTN / 2 )-10, fenetreFaireTest.getHeight() / 13 * 11 - 45,
                80, HAUT_BTN);
        boutonSuivant.setBounds((fenetreFaireTest.getWidth() / 12 * 7 - LARG_BTN / 2)-10, fenetreFaireTest.getHeight() / 13 * 11 - 45,
                80, HAUT_BTN);
        boutonCorrection.setBounds(fenetreFaireTest.getWidth() / 2 - LARG_BTN_CORR / 2 - 4, fenetreFaireTest.getHeight() / 13 * 12 - HAUT_BTN,
                LARG_BTN_CORR, HAUT_BTN);
        boutonRevenir.setBounds(fenetreFaireTest.getWidth() / 2 - LARG_BTN_CORR / 2 - 4, fenetreFaireTest.getHeight() / 13 * 12 - HAUT_BTN,
                LARG_BTN_CORR, HAUT_BTN);

        boutonRevenir.setVisible(false);

        boutonCorrection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String strRes = "\n", strQuestion = "                        ";
                double resTotal = 0;
                int bonneRep = 0;
                for (int i = 0; i < tabRep.length; i++) {
                    if (tabRep[i] == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Vous n'avez pas répondu à la question no " + (i + 1) + " !",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                for(int j=0;j<testFenetre.getNbQuestion();j++){
                    if(j > 8)
                        strQuestion += "QUESTION "+ (j+1)+"      :    ";
                    else
                        strQuestion += "QUESTION "+ (j+1)+"      :      ";

                    if(tabRep[j]-1 == testFenetre.getReponses().get(j)) {
                        strQuestion+= "            1/1\n                        ";
                        bonneRep++;
                    }else{
                        strQuestion+= "            0/1\n                        ";
                    }
                }
                strQuestion+="\n                        TOTAL              :                   "+bonneRep+"/"+testFenetre.getNbQuestion();
                resTotal = (bonneRep * 1.0 /testFenetre.getNbQuestion())*100;

                strRes+="      NOTE  FINALE  : "+ (int)resTotal+ " %\n\n";
                strRes += strQuestion;
                resultat.setText(strRes);
                cacherComposantQuestion();
                afficherComposantResultat();

            }
        });
        boutonRevenir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cacherComposantResultat();
                afficherComposantQuestion();
            }
        });
        boutonSuivant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(repBout1.isSelected() || repBout2.isSelected() || repBout3.isSelected() || repBout4.isSelected()){

                    if(testFenetre.getQuestionCourante() + 1 != testFenetre.getNbQuestion())
                        testFenetre.setQuestionCourante(testFenetre.getQuestionCourante() + 1);
                    if(repBout1.isSelected()){
                        tabRep[testFenetre.getQuestionCourante()-1]=1;
                    }
                    if(repBout2.isSelected()){
                        tabRep[testFenetre.getQuestionCourante()-1]=2;
                    }
                    if(repBout3.isSelected()){
                        tabRep[testFenetre.getQuestionCourante()-1]=3;
                    }
                    if(repBout4.isSelected()){
                        tabRep[testFenetre.getQuestionCourante()-1]=4;
                    }
                    if(!boutonPrecedent.isEnabled())
                        boutonPrecedent.setEnabled(true);
                    if(testFenetre.getQuestionCourante() + 1 == testFenetre.getNbQuestion())
                        boutonSuivant.setEnabled(false);
                    afficherQuestion(testFenetre.getQuestionCourante());
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Vous n'avez pas répondu à cette question !\n Cochez une des réponses.",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        boutonPrecedent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(repBout1.isSelected() || repBout2.isSelected() || repBout3.isSelected() || repBout4.isSelected()){

                    if (!(testFenetre.getQuestionCourante() -1 < 0) )
                        testFenetre.setQuestionCourante(testFenetre.getQuestionCourante()-1);

                    if(tabRep[testFenetre.getQuestionCourante()+1] == 0) {
                        if (repBout1.isSelected()) {
                            tabRep[testFenetre.getQuestionCourante() + 1] = 1;
                        }
                        if (repBout2.isSelected()) {
                            tabRep[testFenetre.getQuestionCourante() + 1] = 2;
                        }
                        if (repBout3.isSelected()) {
                            tabRep[testFenetre.getQuestionCourante() + 1] = 3;
                        }
                        if (repBout4.isSelected()) {
                            tabRep[testFenetre.getQuestionCourante() + 1] = 4;
                        }
                    }
                    if(!boutonSuivant.isEnabled())
                        boutonSuivant.setEnabled(true);
                    if(testFenetre.getQuestionCourante() -1  < 0)
                        boutonPrecedent.setEnabled(false);
                    afficherQuestion(testFenetre.getQuestionCourante());
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Vous n'avez pas répondu à cette question !\n Cochez une des réponses.",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        repBout1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabRep[testFenetre.getQuestionCourante()] = 1;
            }
        });
        repBout2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabRep[testFenetre.getQuestionCourante()] = 2;
            }
        });
        repBout3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabRep[testFenetre.getQuestionCourante()] = 3;
            }
        });
        repBout4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabRep[testFenetre.getQuestionCourante()] = 4;
            }
        });
        fenetreFaireTest.getContentPane().add(spResultat);
        fenetreFaireTest.getContentPane().add(panRes);
        fenetreFaireTest.getContentPane().add(boutonPrecedent);
        fenetreFaireTest.getContentPane().add(boutonSuivant);
        fenetreFaireTest.getContentPane().add(boutonCorrection);
        fenetreFaireTest.getContentPane().add(boutonRevenir);
        fenetreFaireTest.getContentPane().add(lQuestion);
        fenetreFaireTest.getContentPane().add(lNumeroQuestion);
        fenetreFaireTest.getContentPane().add(panneauDesQuestion);
        fenetreFaireTest.getContentPane().add(encadreHaut);

        fenetreFaireTest.setVisible(true);
    }

    /**
     * Permet d'afficher la question
     * @param numeroQuestion le numero de la question ou ils sont rendu
     */
    private void afficherQuestion(int numeroQuestion){
        groupBouton.clearSelection();
        lNumeroQuestion.setText(""+ (testFenetre.getQuestionCourante()+1));
        question.setText(testFenetre.getQuestion(numeroQuestion));
        choixReponseTest = testFenetre.getChoixReponse().get(numeroQuestion).split("<>");
        reponseUn.setText(choixReponseTest[0]);
        reponseDeux.setText(choixReponseTest[1]);
        reponseTrois.setText(choixReponseTest[2]);
        reponseQuatre.setText(choixReponseTest[3]);
        if(tabRep[numeroQuestion] == 1)
            repBout1.setSelected(true);
        if(tabRep[numeroQuestion] == 2)
            repBout2.setSelected(true);
        if(tabRep[numeroQuestion] == 3)
            repBout3.setSelected(true);
        if(tabRep[numeroQuestion] == 4)
            repBout4.setSelected(true);
    }

    /**
     * Cache certaines composantes de la question courrente
     */
    private void cacherComposantQuestion(){
        panneauDesQuestion.setVisible(false);
        lQuestion.setVisible(false);
        spQuestion.setVisible(false);
        lNumeroQuestion.setVisible(false);
        boutonCorrection.setVisible(false);
    }

    /**
     * Affiche certaines composantes de la question courente
     */
    private void afficherComposantQuestion(){
        panneauDesQuestion.setVisible(true);
        lQuestion.setVisible(true);
        spQuestion.setVisible(true);
        lNumeroQuestion.setVisible(true);
        boutonCorrection.setVisible(true);
    }

    /**
     * Cache les composantes de la reponse de la question courente
     */
    private void cacherComposantResultat(){
        spResultat.setVisible(false);
        panRes.setVisible(false);
        lResult.setVisible(false);
        boutonRevenir.setVisible(false);
    }

    /**
     * Affiche les composantes de la reponse de la question courente
     */
    private void afficherComposantResultat(){
        spResultat.setVisible(true);
        panRes.setVisible(true);
        lResult.setVisible(true);
        boutonRevenir.setVisible(true);
    }

}

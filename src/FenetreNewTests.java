import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class FenetreNewTests {

    //Atribut d'instance
    private final static int LARGEUX_FENTRE = 550;
    private final static int HAUTEUR_FENETRE = 540;
    private final static int LARG_BTN = 50;
    private final static int LARG_BTN_SAVE = 140;
    private final static int HAUT_BTN = 30;

    //fenetreNewTests
    private JFrame fenetreNewTests;

    //Titre test
    private JLabel nomTest;
    private JTextField nomTests;

    //JPANEL
    private JPanel panneauDesQuestion;
    private JPanel cadreSuperieur;
    private JPanel cadreInferieur;


    //Enoncer
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

    //Boutons
    private JButton buttonPrecedent;
    private JButton boutonAjoutQuestion;
    private JButton boutonSuppQuestion;
    private JButton boutonSuivant;
    private JButton boutonSave;

    //Ecouteur
    private ActionListener ecouteur;

    //sauvegarde des fichier
    private Test sauvegarde(){
        Test test = new Test();
        ArrayList questions = new ArrayList();
        ArrayList listeReponse = new ArrayList();
        ArrayList<Integer> reponse = new ArrayList<>();
        int conteurDeQuestion = 1;

        test.setName(nomTests.getText().trim());
        questions.add(question.getText().trim());
        test.setQuestion(questions);
        listeReponse.add(listeReponse.size(), reponseUn.getText().trim());
        listeReponse.add(listeReponse.size(), reponseDeux.getText().trim());
        listeReponse.add(listeReponse.size(), reponseTrois.getText().trim());
        listeReponse.add(listeReponse.size(), reponseQuatre.getText().trim());
        test.setChoixReponse(listeReponse);
        if (repBout1.isSelected()) {
            reponse.add(reponse.size(), 1);
        } else if (repBout2.isSelected()) {
            reponse.add(reponse.size(), 2);
        } else if (repBout3.isSelected()) {
            reponse.add(reponse.size(), 3);
        } else if (repBout4.isSelected()){
            reponse.add(reponse.size(), 4);
        }
        test.setReponses(reponse);
        test.setNbQuestion(conteurDeQuestion ++);
        test.setQuestionCourante(test.getQuestion().size() - 1);

        return  test;
    }

    /**
     * Contructeur qui initialise la fenetre de creation
     */
    public FenetreNewTests(){
        init();
    }

    private void init() {

        fenetreNewTests = new JFrame("Créer un nouveau test");

        //Dimention et position de la fenetre
        fenetreNewTests.setSize(LARGEUX_FENTRE,HAUTEUR_FENETRE);
        fenetreNewTests.setLocationRelativeTo(null);
        fenetreNewTests.setResizable(false);

        fenetreNewTests.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetreNewTests.setLayout(null);

        //JPANEL
        panneauDesQuestion = new JPanel();
        panneauDesQuestion.setBounds(50,50, 450, 350);
        panneauDesQuestion.setOpaque(true);
        panneauDesQuestion.setLayout(null);

        cadreSuperieur = new JPanel();
        cadreInferieur = new JPanel();

        cadreSuperieur.setBounds(50,40,300,1);

                //Titre test
        nomTest = new JLabel("Nom du test ");
        nomTests = new JTextField();

        nomTest.setBounds(fenetreNewTests.getWidth() / 12 , fenetreNewTests.getHeight() / 13 - HAUT_BTN, 200, HAUT_BTN);
        nomTests.setBounds(fenetreNewTests.getWidth() / 12 * 3, fenetreNewTests.getHeight() / 13 - HAUT_BTN, 200, HAUT_BTN);

        fenetreNewTests.getContentPane().add(nomTest);
        fenetreNewTests.getContentPane().add(nomTests);


        //Enoncer
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

        //Boutons
        buttonPrecedent = new JButton("<");
        boutonAjoutQuestion = new JButton("+");
        boutonSuppQuestion = new JButton("-");
        boutonSuivant = new JButton(">");
        boutonSave = new JButton("Sauvegarder");

        buttonPrecedent.setBounds(fenetreNewTests.getWidth() / 12 * 3 - LARG_BTN / 2, fenetreNewTests.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonAjoutQuestion.setBounds(fenetreNewTests.getWidth() / 12 * 5 - LARG_BTN / 2, fenetreNewTests.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonSuppQuestion.setBounds(fenetreNewTests.getWidth() / 12 * 7 - LARG_BTN / 2, fenetreNewTests.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonSuivant.setBounds(fenetreNewTests.getWidth() / 12 * 9 - LARG_BTN / 2, fenetreNewTests.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonSave.setBounds(fenetreNewTests.getWidth() / 2 - LARG_BTN_SAVE / 2 -4, fenetreNewTests.getHeight() / 13 * 12 - HAUT_BTN,
                LARG_BTN_SAVE, HAUT_BTN);

        fenetreNewTests.getContentPane().add(buttonPrecedent);
        fenetreNewTests.getContentPane().add(boutonAjoutQuestion);
        fenetreNewTests.getContentPane().add(boutonSuppQuestion);
        fenetreNewTests.getContentPane().add(boutonSuivant);
        fenetreNewTests.getContentPane().add(boutonSave);

        //Ecouteur
        ecouteur = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evenement) {

                Test test = new Test();
                ArrayList<Test> arrayListTest = new ArrayList<>();
                int questionCouante = test.getQuestionCourante();

                if (evenement.getSource() == buttonPrecedent){
                    if (questionCouante != 0){
                        questionCouante --;
                    }

                } else if (evenement.getSource() == boutonAjoutQuestion){

                    if (nomTests.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erreur votre test doit avoir un nom.");
                    } else if (question.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erreur énoucé invalide.");
                    } else if (reponseUn.getText().trim().isEmpty() && reponseDeux.getText().trim().isEmpty() && reponseTrois.getText().isEmpty() && reponseQuatre.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erreur reponse invalide.");
                    } else if (repBout1.isSelected() && repBout2.isSelected() && repBout3.isSelected() && repBout4.isSelected()){
                        JOptionPane.showMessageDialog(null, "Erreur aucune bonne reponse de selectionner.");
                    } else {
                        arrayListTest.add(arrayListTest.size(), sauvegarde());
                        numeroQuestion ++;
                        questionCouante ++;
                        ajouterQuestion();
                    }

                } else if (evenement.getSource() == boutonSuppQuestion){
                    if (questionCouante != 0){
                        questionCouante --;
                    }
                    test.setQuestionCourante(questionCouante);
                    test.getQuestion().remove(questionCouante);
                    numeroQuestion --;


                } else if (evenement.getSource() == boutonSuivant){
                    if (questionCouante < test.getQuestion().size()){
                        questionCouante ++;
                    }

                } else if (evenement.getSource() == boutonSave){

                    if (nomTests.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erreur votre test doit avoir un nom.");
                    } else if (question.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erreur énoucé invalide.");
                    } else if (reponseUn.getText().trim().isEmpty() && reponseDeux.getText().trim().isEmpty() && reponseTrois.getText().isEmpty() && reponseQuatre.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erreur reponse invalide.");
                    } else if (repBout1.isSelected() && repBout2.isSelected() && repBout3.isSelected() && repBout4.isSelected()){
                        JOptionPane.showMessageDialog(null, "Erreur aucune bonne reponse de selectionner.");
                    } else {
                        if (test.getNbQuestion() == null){
                            arrayListTest.add(arrayListTest.size(), sauvegarde());
                        } else if (question.getText().trim() != test.getQuestion(test.getQuestionCourante())){
                            arrayListTest.add(arrayListTest.size(), sauvegarde());
                        }

                        try {
                            for (int i = 0; i < arrayListTest.size(); i ++) {
                                test = arrayListTest.get(i);
                                LectureEtEcritureFichier.ecriture(test);
                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        fenetreNewTests.dispose();
                    }

                }
            }
        };

        buttonPrecedent.addActionListener(ecouteur);
        boutonAjoutQuestion.addActionListener(ecouteur);
        boutonSuppQuestion.addActionListener(ecouteur);
        boutonSuivant.addActionListener(ecouteur);
        boutonSave.addActionListener(ecouteur);

        fenetreNewTests.add(panneauDesQuestion);
        fenetreNewTests.add(cadreSuperieur);

        fenetreNewTests.setVisible(true);
    }

    private void ajouterQuestion(){

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

        fenetreNewTests.add(panneauDesQuestion);
        panneauDesQuestion.revalidate();
        panneauDesQuestion.repaint();

    }
}

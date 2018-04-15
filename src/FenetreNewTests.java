import javax.swing.*;
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

    //Enoncer
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
        } else {
            reponse.add(reponse.size(), 4);
        }
        test.setRepones(reponse);
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
        fenetreNewTests.setBounds(400,300,LARGEUX_FENTRE,HAUTEUR_FENETRE);
        fenetreNewTests.setResizable(false);

        fenetreNewTests.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetreNewTests.setLayout(null);

        //Titre test
        nomTest = new JLabel("Nom du test");
        nomTests = new JTextField("");

        nomTest.setBounds(fenetreNewTests.getWidth() / 12 , fenetreNewTests.getHeight() / 13 - HAUT_BTN, 200, HAUT_BTN);
        nomTests.setBounds(fenetreNewTests.getWidth() / 12 * 3, fenetreNewTests.getHeight() / 13 - HAUT_BTN, 200, HAUT_BTN);

        fenetreNewTests.getContentPane().add(nomTest);
        fenetreNewTests.getContentPane().add(nomTests);

        //Enoncer
        enoncer = new JLabel("Énoncé");
        question = new JTextArea("");
        question.setLineWrap(true);
        question.setEditable(true);

        enoncer.setBounds(fenetreNewTests.getWidth() / 12 , fenetreNewTests.getHeight() / 13 * 2 - HAUT_BTN, 200, HAUT_BTN);
        question.setBounds(fenetreNewTests.getWidth() / 12 , fenetreNewTests.getHeight() / 13 *3 - HAUT_BTN, 450, HAUT_BTN * 2);

        fenetreNewTests.getContentPane().add(enoncer);
        fenetreNewTests.getContentPane().add(question);

        //Reponse
        reponse = new JLabel("Choix de réponses (Cocher la bonne réponse)");
        reponse1 = new JLabel("1)");
        reponse2 = new JLabel("2)");
        reponse3 = new JLabel("3)");
        reponse4 = new JLabel("4)");
        reponseUn = new JTextField();
        reponseDeux = new JTextField();
        reponseTrois = new JTextField();
        reponseQuatre = new JTextField();
        repBout1 = new JRadioButton();
        repBout2 = new JRadioButton();
        repBout3 = new JRadioButton();
        repBout4 = new JRadioButton();

        reponse.setBounds(fenetreNewTests.getWidth() / 12, fenetreNewTests.getHeight() / 13 * 5 - HAUT_BTN, 450, HAUT_BTN);
        reponse1.setBounds(fenetreNewTests.getWidth() / 12, fenetreNewTests.getHeight() / 13 * 6 - HAUT_BTN, LARG_BTN, HAUT_BTN);
        reponseUn.setBounds(fenetreNewTests.getWidth() / 12 * 2, fenetreNewTests.getHeight() / 13 * 6 - HAUT_BTN, 400, HAUT_BTN);
        repBout1.setBounds(fenetreNewTests.getWidth() / 12 * 11, fenetreNewTests.getHeight() / 13 * 6 - HAUT_BTN, LARG_BTN, HAUT_BTN);
        reponse2.setBounds(fenetreNewTests.getWidth() / 12, fenetreNewTests.getHeight() / 13 * 7 - HAUT_BTN, LARG_BTN, HAUT_BTN);
        reponseDeux.setBounds(fenetreNewTests.getWidth() / 12 *2, fenetreNewTests.getHeight() / 13 * 7 - HAUT_BTN, 400, HAUT_BTN);
        repBout2.setBounds(fenetreNewTests.getWidth() / 12 * 11, fenetreNewTests.getHeight() / 13 * 7 - HAUT_BTN, LARG_BTN,HAUT_BTN);
        reponse3.setBounds(fenetreNewTests.getWidth() / 12, fenetreNewTests.getHeight() / 13 * 8 - HAUT_BTN, LARG_BTN, HAUT_BTN);
        reponseTrois.setBounds(fenetreNewTests.getWidth() / 12 * 2, fenetreNewTests.getHeight() / 13 *8 - HAUT_BTN, 400, HAUT_BTN);
        repBout3.setBounds(fenetreNewTests.getWidth() / 12 * 11, fenetreNewTests.getHeight() / 13 * 8 - HAUT_BTN, LARG_BTN,HAUT_BTN);
        reponse4.setBounds(fenetreNewTests.getWidth() / 12, fenetreNewTests.getHeight() / 13 * 9 - HAUT_BTN, LARG_BTN, HAUT_BTN);
        reponseQuatre.setBounds(fenetreNewTests.getWidth() / 12 * 2, fenetreNewTests.getHeight() /13 * 9 - HAUT_BTN, 400, HAUT_BTN);
        repBout4.setBounds(fenetreNewTests.getWidth() / 12 * 11, fenetreNewTests.getHeight() / 13 * 9 - HAUT_BTN, LARG_BTN,HAUT_BTN);

        fenetreNewTests.getContentPane().add(reponse);
        fenetreNewTests.getContentPane().add(reponse1);
        fenetreNewTests.getContentPane().add(reponseUn);
        fenetreNewTests.getContentPane().add(repBout1);
        fenetreNewTests.getContentPane().add(reponse2);
        fenetreNewTests.getContentPane().add(reponseDeux);
        fenetreNewTests.getContentPane().add(repBout2);
        fenetreNewTests.getContentPane().add(reponse3);
        fenetreNewTests.getContentPane().add(reponseTrois);
        fenetreNewTests.getContentPane().add(repBout3);
        fenetreNewTests.getContentPane().add(reponse4);
        fenetreNewTests.getContentPane().add(reponseQuatre);
        fenetreNewTests.getContentPane().add(repBout4);

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
                ArrayList questions = new ArrayList();
                ArrayList listeReponse = new ArrayList();
                ArrayList<Integer> reponse = new ArrayList<>();
                int conteurDeQuestion = 1;

                if (evenement.getSource() == boutonAjoutQuestion){

                    //TODO sauvegarder les info des tests .
                    if (nomTests.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erreur votre test doit avoir un nom.");
                    } else if (question.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erreur énoucé invalide.");
                    } else if (reponseUn.getText().trim().isEmpty() && reponseDeux.getText().trim().isEmpty() && reponseTrois.getText().isEmpty() && reponseQuatre.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erreur reponse invalide.");
                    } else if (repBout1.isSelected() && repBout2.isSelected() && repBout3.isSelected() && repBout4.isSelected()){
                        JOptionPane.showMessageDialog(null, "Erreur aucune bonne reponse de selectionner.");
                    } else {
                        //TODO éventuellement le metre dans une méthode a par.
                        test = sauvegarde();
                    }
                }
                if (evenement.getSource() == boutonSave){

                    //TODO prendre la arraylist et la sauvegarder dans le fichier.
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
                            test = sauvegarde();
                        } else if (question.getText().trim() != test.getQuestion(test.getQuestionCourante())){
                            //TODO éventuellement le metre dans une méthode a par.
                            test = sauvegarde();
                        }

                        try {
                            LectureEtEcritureFichier.ecriture(test);
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

        fenetreNewTests.setVisible(true);
    }
}

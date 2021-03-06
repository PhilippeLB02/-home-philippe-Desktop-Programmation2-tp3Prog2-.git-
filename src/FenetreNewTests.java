import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FenetreNewTests {

    //Atribut d'instance pour la fenetre de creation de test
    private final static int LARGEUX_FENTRE = 550;
    private final static int HAUTEUR_FENETRE = 540;
    private final static int LARG_BTN = 50;
    private final static int LARG_BTN_SAVE = 140;
    private final static int HAUT_BTN = 30;
    private static final String SÉPARATEUR_CHOIX_REPONSES = "<>";

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
    private JLabel lQuestion;
    private int numeroQuestion = 1;
    private JLabel enoncer;
    private JTextArea question;
    private JScrollPane spQuestion;

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
    private JCheckBox repBout1;
    private JCheckBox repBout2;
    private JCheckBox repBout3;
    private JCheckBox repBout4;
    private ButtonGroup btnGroup;

    //Boutons
    private JButton boutonPrecedent;
    private JButton boutonAjoutQuestion;
    private JButton boutonSuppQuestion;
    private JButton boutonSuivant;
    private JButton boutonSave;

    //test
    private Test testNouveau;
    private Test testTemp;
    private String[] choixReponseTest;

    //Ecouteur
    private ActionListener ecouteur;

    /**
     * Contructeur qui initialise la fenetre de creation
     */
    public FenetreNewTests() {
        testNouveau = new Test();
        testNouveau.setQuestionCourante(0);
        testNouveau.setNbQuestion(0);
        testTemp = new Test();
        testTemp.setQuestionCourante(0);
        testTemp.setNbQuestion(0);
        init();
    }

    /**
     * Construteur de la fenetre de creation de test
     */
    private void init() {

        fenetreNewTests = new JFrame("Créer un nouveau test");

        //Dimention et position de la fenetre
        fenetreNewTests.setSize(LARGEUX_FENTRE, HAUTEUR_FENETRE);
        fenetreNewTests.setLocationRelativeTo(null);
        fenetreNewTests.setResizable(false);

        fenetreNewTests.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetreNewTests.setLayout(null);

        //JPANEL
        panneauDesQuestion = new JPanel();
        panneauDesQuestion.setBounds(50, 50, 450, 350);
        panneauDesQuestion.setOpaque(true);
        panneauDesQuestion.setLayout(null);
        panneauDesQuestion.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        cadreSuperieur = new JPanel();
        cadreInferieur = new JPanel();

        cadreSuperieur.setBounds(50, 40, 300, 1);

        //Titre test
        nomTest = new JLabel("Nom du test ");
        nomTests = new JTextField();

        nomTest.setBounds(fenetreNewTests.getWidth() / 12, fenetreNewTests.getHeight() / 13 - HAUT_BTN, 200, HAUT_BTN);
        nomTests.setBounds(fenetreNewTests.getWidth() / 12 * 3, fenetreNewTests.getHeight() / 13 - HAUT_BTN, 200, HAUT_BTN);

        fenetreNewTests.getContentPane().add(nomTest);
        fenetreNewTests.getContentPane().add(nomTests);


        //Enoncer
        lQuestion = new JLabel("Question " + numeroQuestion);
        lQuestion.setBounds(10, 5, 200, HAUT_BTN);
        lQuestion.setFont(new Font(lQuestion.getFont().getFamily(), Font.BOLD, 15));
        enoncer = new JLabel("Énoncé ");
        enoncer.setBounds(25, 35, 200, HAUT_BTN);
        question = new JTextArea();
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setEditable(true);
        question.setBounds(25, 75, 385, HAUT_BTN * 2);

        spQuestion = new JScrollPane(question);
        spQuestion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spQuestion.setBounds(24, 74, 403, HAUT_BTN * 2 + 3);

        panneauDesQuestion.add(lQuestion);
        panneauDesQuestion.add(enoncer);
        panneauDesQuestion.add(question);
        panneauDesQuestion.add(spQuestion);

        //Reponse
        reponse = new JLabel("Choix de réponses (Cocher la bonne réponse) ");
        reponse.setBounds(10, 145, 400, HAUT_BTN);
        reponse1 = new JLabel("1) ");
        reponse1.setBounds(10, 185, LARG_BTN, HAUT_BTN);
        reponse2 = new JLabel("2) ");
        reponse2.setBounds(10, 225, LARG_BTN, HAUT_BTN);
        reponse3 = new JLabel("3) ");
        reponse3.setBounds(10, 265, LARG_BTN, HAUT_BTN);
        reponse4 = new JLabel("4) ");
        reponse4.setBounds(10, 305, LARG_BTN, HAUT_BTN);
        reponseUn = new JTextField(35);
        reponseUn.setBounds(70, 185, 310, HAUT_BTN);
        reponseDeux = new JTextField(35);
        reponseDeux.setBounds(70, 225, 310, HAUT_BTN);
        reponseTrois = new JTextField(35);
        reponseTrois.setBounds(70, 265, 310, HAUT_BTN);
        reponseQuatre = new JTextField(35);
        reponseQuatre.setBounds(70, 305, 310, HAUT_BTN);
        repBout1 = new JCheckBox();
        repBout1.setBounds(390, 185, LARG_BTN, HAUT_BTN);
        repBout2 = new JCheckBox();
        repBout2.setBounds(390, 225, LARG_BTN, HAUT_BTN);
        repBout3 = new JCheckBox();
        repBout3.setBounds(390, 265, LARG_BTN, HAUT_BTN);
        repBout4 = new JCheckBox();
        repBout4.setBounds(390, 305, LARG_BTN, HAUT_BTN);

        btnGroup = new ButtonGroup();
        btnGroup.add(repBout1);
        btnGroup.add(repBout2);
        btnGroup.add(repBout3);
        btnGroup.add(repBout4);

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
        boutonPrecedent = new JButton("<");
        boutonAjoutQuestion = new JButton("+");
        boutonSuppQuestion = new JButton("-");
        boutonSuivant = new JButton(">");
        boutonSave = new JButton("Sauvegarder");

        boutonPrecedent.setBounds(fenetreNewTests.getWidth() / 12 * 3 - LARG_BTN / 2, fenetreNewTests.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonAjoutQuestion.setBounds(fenetreNewTests.getWidth() / 12 * 5 - LARG_BTN / 2, fenetreNewTests.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonSuppQuestion.setBounds(fenetreNewTests.getWidth() / 12 * 7 - LARG_BTN / 2, fenetreNewTests.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonSuivant.setBounds(fenetreNewTests.getWidth() / 12 * 9 - LARG_BTN / 2, fenetreNewTests.getHeight() / 13 * 11 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonSave.setBounds(fenetreNewTests.getWidth() / 2 - LARG_BTN_SAVE / 2 - 4, fenetreNewTests.getHeight() / 13 * 12 - HAUT_BTN,
                LARG_BTN_SAVE, HAUT_BTN);

        boutonPrecedent.setEnabled(false);
        boutonSuivant.setEnabled(false);
        boutonSuppQuestion.setEnabled(false);

        fenetreNewTests.getContentPane().add(boutonPrecedent);
        fenetreNewTests.getContentPane().add(boutonAjoutQuestion);
        fenetreNewTests.getContentPane().add(boutonSuppQuestion);
        fenetreNewTests.getContentPane().add(boutonSuivant);
        fenetreNewTests.getContentPane().add(boutonSave);

        //Ecouteur
        ecouteur = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evenement) {


                if (evenement.getSource() == boutonPrecedent) {
                    if (question.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n L'énoncé de la question doit contenir entre 1 et 500 caractères.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (reponseUn.getText().trim().isEmpty() || reponseDeux.getText().trim().isEmpty() || reponseTrois.getText().isEmpty() || reponseQuatre.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n Chacun des choix doit contenir entre 1 et 50 caractères.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (!repBout1.isSelected() && !repBout2.isSelected() && !repBout3.isSelected() && !repBout4.isSelected()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n La bonne réponse doit être cochée dans les choix de réponses.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (testNouveau.getQuestionCourante() - 1 >= 0) {
                            if (testNouveau.getQuestionCourante() == testNouveau.getQuestion().size()) {
                                testNouveau.getQuestion().add(question.getText());
                                testNouveau.getChoixReponse().add(reponseUn.getText() + "<>" + reponseDeux.getText() + "<>" + reponseTrois.getText() + "<>" + reponseQuatre.getText());
                                if (repBout1.isSelected())
                                    testNouveau.getReponses().add(0);
                                if (repBout2.isSelected())
                                    testNouveau.getReponses().add(1);
                                if (repBout3.isSelected())
                                    testNouveau.getReponses().add(2);
                                if (repBout4.isSelected())
                                    testNouveau.getReponses().add(3);
                            }
                            modifierQuestionCourante(testNouveau.getQuestionCourante());
                            testNouveau.setQuestionCourante(testNouveau.getQuestionCourante() - 1);
                            afficherQuestion();
                            boutonSuivant.setEnabled(true);
                            lQuestion.setText("QUESTION " + (testNouveau.getQuestionCourante() + 1));
                        }
                        if (testNouveau.getQuestionCourante() == 0)
                            boutonPrecedent.setEnabled(false);
                    }
                } else if (evenement.getSource() == boutonSuivant) {
                    if (question.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n L'énoncé de la question doit contenir entre 1 et 500 caractères.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (reponseUn.getText().trim().isEmpty() || reponseDeux.getText().trim().isEmpty() || reponseTrois.getText().isEmpty() || reponseQuatre.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n Chacun des choix doit contenir entre 1 et 50 caractères.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (!repBout1.isSelected() && !repBout2.isSelected() && !repBout3.isSelected() && !repBout4.isSelected()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n La bonne réponse doit être cochée dans les choix de réponses.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    }else {
                        if (testNouveau.getQuestionCourante() + 1 <= testNouveau.getQuestion().size()) {
                            modifierQuestionCourante(testNouveau.getQuestionCourante());
                            testNouveau.setQuestionCourante(testNouveau.getQuestionCourante() + 1);
                            afficherQuestion();
                            lQuestion.setText("QUESTION " + (testNouveau.getQuestionCourante() + 1));
                            boutonPrecedent.setEnabled(true);
                        }
                        if (testNouveau.getQuestionCourante() + 1 >= testNouveau.getQuestion().size())
                            boutonSuivant.setEnabled(false);
                    }
                } else if (evenement.getSource() == boutonAjoutQuestion) {
                    if (question.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n L'énoncé de la question doit contenir entre 1 et 500 caractères.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (reponseUn.getText().trim().isEmpty() || reponseDeux.getText().trim().isEmpty() || reponseTrois.getText().isEmpty() || reponseQuatre.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n Chacun des choix doit contenir entre 1 et 50 caractères.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (!repBout1.isSelected() && !repBout2.isSelected() && !repBout3.isSelected() && !repBout4.isSelected()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n La bonne réponse doit être cochée dans les choix de réponses.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    }else {
                            if (testNouveau.getQuestion().size() == 0)
                                ajouterQuestion();
                            else {
                                testNouveau.getQuestion().subList(testNouveau.getQuestionCourante(), testNouveau.getQuestion().size()).clear();
                                testNouveau.getChoixReponse().subList(testNouveau.getQuestionCourante(), testNouveau.getChoixReponse().size()).clear();
                                testNouveau.getReponses().subList(testNouveau.getQuestionCourante(), testNouveau.getReponses().size()).clear();
                                ajouterQuestion();
                            }
                            boutonSuivant.setEnabled(false);
                    }
                } else if (evenement.getSource() == boutonSuppQuestion) {

                    if (testNouveau.getQuestionCourante() == 0) {
                        JOptionPane.showMessageDialog(null, "Aucune question a supprimer.");
                    } else {
                        testNouveau.getQuestion().remove(testNouveau.getQuestionCourante());
                        testNouveau.getChoixReponse().remove(testNouveau.getQuestionCourante());
                        testNouveau.getReponses().remove(testNouveau.getQuestionCourante());
                        testNouveau.setQuestionCourante(testNouveau.getQuestionCourante() - 1);
                        afficherQuestion();
                    }

                } else if (evenement.getSource() == boutonSave) {
                    if (nomTests.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Ce test est invalide et ne peut pas être enregistré !\n Le nom du test doit contenir entre 1 et 50 caractères.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (question.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n L'énoncé de la question doit contenir entre 1 et 500 caractères.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (reponseUn.getText().trim().isEmpty() || reponseDeux.getText().trim().isEmpty() || reponseTrois.getText().isEmpty() || reponseQuatre.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n Chacun des choix doit contenir entre 1 et 50 caractères.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (!repBout1.isSelected() && !repBout2.isSelected() && !repBout3.isSelected() && !repBout4.isSelected()) {
                        JOptionPane.showMessageDialog(null,
                                "La question courante n'est pas valide !\n La bonne réponse doit être cochée dans les choix de réponses.",
                                "ERREUR",
                                JOptionPane.ERROR_MESSAGE);
                    }else {
                        if (nomTests.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Erreur votre test doit avoir un nom.");
                        } else if (question.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Erreur énoucé invalide.");
                        } else if (reponseUn.getText().trim().isEmpty() && reponseDeux.getText().trim().isEmpty() && reponseTrois.getText().isEmpty() && reponseQuatre.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Erreur reponse invalide.");
                        } else if (!repBout1.isSelected() && !repBout2.isSelected() && !repBout3.isSelected() && !repBout4.isSelected()) {
                            JOptionPane.showMessageDialog(null, "Erreur aucune bonne reponse de selectionner.");
                        } else {

                            if (testNouveau.getNbQuestion() < 1)
                                testNouveau.setNbQuestion(testNouveau.getQuestion().size());

                            try {
                                testNouveau.setName(nomTests.getText().trim());
                                if (testNouveau.getQuestionCourante() == testNouveau.getQuestion().size()) {
                                    ajouterQuestion();
                                } else {
                                    modifierQuestionCourante(testNouveau.getQuestionCourante());
                                }
                                LectureEtEcritureFichier.ecriture(testNouveau);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            fenetreNewTests.dispose();
                        }
                    }
                }
            }
        };

        boutonPrecedent.addActionListener(ecouteur);
        boutonAjoutQuestion.addActionListener(ecouteur);
        boutonSuppQuestion.addActionListener(ecouteur);
        boutonSuivant.addActionListener(ecouteur);
        boutonSave.addActionListener(ecouteur);

        fenetreNewTests.add(panneauDesQuestion);
        fenetreNewTests.add(cadreSuperieur);

        fenetreNewTests.setVisible(true);
    }

    /**
     * permet d'afficher les questions
     */
    private void afficherQuestion() {

        lQuestion.setText("Question " + (testNouveau.getQuestionCourante() + 1));
        question.setText(testNouveau.getQuestion(testNouveau.getQuestionCourante()));
        choixReponseTest = testNouveau.getChoixReponse().get(testNouveau.getQuestionCourante()).split(SÉPARATEUR_CHOIX_REPONSES);
        reponseUn.setText(choixReponseTest[0]);
        reponseDeux.setText(choixReponseTest[1]);
        reponseTrois.setText(choixReponseTest[2]);
        reponseQuatre.setText(choixReponseTest[3]);

        if (testNouveau.getReponses().get(testNouveau.getQuestionCourante()) == 0)
            repBout1.setSelected(true);
        if (testNouveau.getReponses().get(testNouveau.getQuestionCourante()) == 1)
            repBout2.setSelected(true);
        if (testNouveau.getReponses().get(testNouveau.getQuestionCourante()) == 2)
            repBout3.setSelected(true);
        if (testNouveau.getReponses().get(testNouveau.getQuestionCourante()) == 3)
            repBout4.setSelected(true);
    }

    /**
     * permet d'ajouter une question
     */
    private void ajouterQuestion() {

        testNouveau.getQuestion().add(question.getText());
        testNouveau.getChoixReponse().add(reponseUn.getText() + SÉPARATEUR_CHOIX_REPONSES + reponseDeux.getText() + SÉPARATEUR_CHOIX_REPONSES
                + reponseTrois.getText() + SÉPARATEUR_CHOIX_REPONSES + reponseQuatre.getText());
        if (repBout1.isSelected())
            testNouveau.getReponses().add(0);
        if (repBout2.isSelected())
            testNouveau.getReponses().add(1);
        if (repBout3.isSelected())
            testNouveau.getReponses().add(2);
        if (repBout4.isSelected())
            testNouveau.getReponses().add(3);
        testNouveau.setQuestionCourante(testNouveau.getQuestionCourante() + 1);
        boutonPrecedent.setEnabled(true);
        boutonSuppQuestion.setEnabled(true);
        lQuestion.setText("QUESTION " + (testNouveau.getQuestionCourante() + 1));

        reponseDeux.setText("");
        reponseQuatre.setText("");
        reponseTrois.setText("");
        reponseUn.setText("");
        question.setText("");
        btnGroup.clearSelection();
    }

    /**
     * permet de modifier une question courante a la ieme position
     *
     * @param iemeQuestion l'index ou changer la question
     */
    private void modifierQuestionCourante(int iemeQuestion) {
        testNouveau.getQuestion().set(iemeQuestion, question.getText());

        testNouveau.getChoixReponse().set(iemeQuestion, reponseUn.getText() + SÉPARATEUR_CHOIX_REPONSES + reponseDeux.getText() + SÉPARATEUR_CHOIX_REPONSES
                + reponseTrois.getText() + SÉPARATEUR_CHOIX_REPONSES + reponseQuatre.getText());
        if (repBout1.isSelected())
            testNouveau.getReponses().set(iemeQuestion, 0);
        if (repBout2.isSelected())
            testNouveau.getReponses().set(iemeQuestion, 1);
        if (repBout3.isSelected())
            testNouveau.getReponses().set(iemeQuestion, 2);
        if (repBout4.isSelected())
            testNouveau.getReponses().set(iemeQuestion, 3);
    }

}

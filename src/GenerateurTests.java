/**
 * Kismony Ladouceur LADK03119402
 * Philippe Lemay-Bourbeau LEMP02119605
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateurTests {

    //Atribut d'instance de la fenetre principale
    private final static int LARGEUX_FENTRE = 380;
    private final static int HAUTEUR_FENETRE = 360;
    private final static int LARG_BTN = 300;
    private final static int HAUT_BTN = 30;

    //Fenetre principale
    private JFrame fenetre;
    private JPanel  ligne;

    //Boutons
    private JButton boutonNewTests;
    private JButton boutonFaireTests;
    private JButton boutonSuppTests;

    //Liste deroulante
    private JComboBox listeTests;

    //liste des tests du fichier
    private ArrayList<Test> lTests;

    //Ecouteur
    private ActionListener ecouteur;



    /**
     * Constructeur qui initialise la fenetre
     */
    public GenerateurTests() {
        initMenu();
    }

    /**
     * Créer la fenetre principale
     */
    private void initMenu()  {

        fenetre = new JFrame("Générateur de tests");
        ligne   = new JPanel();
//        jboard.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        ligne.setBorder(BorderFactory.createLineBorder(Color.black,6));
        ligne.setBounds(10,100,360,1);
        ligne.setOpaque(false);

        //Dimention et position de la fenetre
        fenetre.setSize(LARGEUX_FENTRE,HAUTEUR_FENETRE);
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(null);

        //Boutons
        boutonNewTests = new JButton("Créer un nouveau test");
        boutonFaireTests = new JButton("Passer le test sélectionné");
        boutonSuppTests = new JButton("Supprimer le test sélectionné");

        boutonNewTests.setBounds(fenetre.getWidth() / 2 - LARG_BTN / 2, fenetre.getHeight() / 7 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonFaireTests.setBounds(fenetre.getWidth() / 2 - LARG_BTN / 2, fenetre.getHeight() / 7 * 5 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        boutonSuppTests.setBounds(fenetre.getWidth() / 2 - LARG_BTN / 2, fenetre.getHeight() / 7 * 6 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);

        fenetre.getContentPane().add(boutonNewTests);
        fenetre.getContentPane().add(boutonFaireTests);
        fenetre.getContentPane().add(boutonSuppTests);


        try {
            lTests = LectureEtEcritureFichier.lecture();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Liste deroulante
        listeTests = new JComboBox();
        listeTests.setBounds(fenetre.getWidth() / 2 - LARG_BTN / 2, fenetre.getHeight() / 7 * 3 - HAUT_BTN,
                LARG_BTN, HAUT_BTN);
        for(int i=0;i<lTests.size();i++){
            String item="";
            item = lTests.get(i).getName();
            if(lTests.get(i).getNbQuestion() > 1)
                item += " ("+lTests.get(i).getNbQuestion() + " questions)";
            else
                item += " ("+lTests.get(i).getNbQuestion() + " question)";

            listeTests.addItem(item);
        }

        fenetre.getContentPane().add(listeTests);
        fenetre.getContentPane().add(ligne);



        //Ecouteur
        ecouteur = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evenement) {

                if (evenement.getSource() == boutonNewTests){
                    new FenetreNewTests();
                }else if (evenement.getSource() == boutonFaireTests){
                    Object selected = listeTests.getSelectedItem();
                    if (selected != null) {
                        String testChoisi = selected.toString().substring(0,selected.toString().lastIndexOf('(')-1);
                        for (int i=0;i< lTests.size();i++){
                            if(lTests.get(i).getName().equals(testChoisi)){
                                new FenetreFaireTests(lTests.get(i));
                                break;
                            }

                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Aucun test sélectionner!");
                    }
                }else if (evenement.getSource() == boutonSuppTests){
                    Object selected = listeTests.getSelectedItem();
                    listeTests.removeItem(selected);
                    if (selected != null){
                        String testChoisi = selected.toString().substring(0,selected.toString().lastIndexOf('(')-1);
                        for (int i=0;i< lTests.size();i++){
                            if(lTests.get(i).getName().equals(testChoisi)){
                                lTests.remove(i);
                                LectureEtEcritureFichier.getSAUVEGARDETEST().delete();
                                break;
                            }
                        }

                        try {
                            for (int i = 0; i < lTests.size(); i++) {
                                if (lTests.get(i) != null) {
                                    LectureEtEcritureFichier.ecriture(lTests.get(i));
                                }
                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun test sélectionner!");
                    }
                }
            }
        };

        boutonNewTests.addActionListener(ecouteur);
        boutonFaireTests.addActionListener(ecouteur);
        boutonSuppTests.addActionListener(ecouteur);

        fenetre.setVisible(true);
    }

    public static void main (String[]args){
        new GenerateurTests();
    }
}
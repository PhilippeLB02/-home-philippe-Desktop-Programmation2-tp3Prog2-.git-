import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class LectureEtEcritureFichier {

    //Atribut d'instence pour écrire les tests
    private static final String SÉPARATEUR_TESTS = "=====";
    private static final String SÉPARATEUR_QUESTIONS = "-----";

    //nom du fichier a utiliser
    private static File SAUVEGARDETEST = new File(GenerateurTests.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "tests.txt");

    /**
     * getters pour aller chercher le nom du fichier
     * @return le nom du fichier
     */
    public static File getSAUVEGARDETEST() {
        return SAUVEGARDETEST;
    }

    /**
     * Methode qui ecrit tout les informations d'un test dans tests.txt
     * @param test prend en parametre un test
     * @throws IOException si le fichier est introuvable
     */
    public static void ecriture(Test test) throws IOException {

        if (!SAUVEGARDETEST.exists()) {
            SAUVEGARDETEST.createNewFile();
        }
        FileWriter fw = new FileWriter(SAUVEGARDETEST, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        String nomTest = test.getName();
        pw.println(nomTest);
        int nbQuestion = test.getNbQuestion();
        pw.println(nbQuestion);
        pw.println(SÉPARATEUR_QUESTIONS);
        String question;
        String choixReponse;
        int reponse;

        //boucle for print question et choix de reponses
        for (int i = 0; i < test.getQuestion().size(); i ++) {
            question = test.getQuestion().get(i);
            pw.println(question);
            pw.println(SÉPARATEUR_QUESTIONS);
            choixReponse = test.getChoixReponse().get(i);
            pw.println(choixReponse);
            pw.println(SÉPARATEUR_QUESTIONS);
            reponse = test.getReponses().get(i);
            pw.println(reponse);
            if (test.getQuestion().size() == i + 1){
                pw.println(SÉPARATEUR_TESTS);
            }else {
                pw.println(SÉPARATEUR_QUESTIONS);
            }
        }


        pw.close();

    }

    /**
     * Lit le fichier txt et retourne tous les tests qui si trouve
     * @return tous les tests dans une arrayliste de tests.
     * @throws IOException lance l'exception s'il n'y a pas de fichier s'il ne peut pas l'ouvrire
     */
    public static ArrayList<Test> lecture() throws IOException {

        String tests = GenerateurTests.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "tests.txt";
        String line="";
        String tempStr=line;

        ArrayList<Test> listeTests= new ArrayList<>();

        try{
            FileReader fileReader =
                    new FileReader(tests);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            //lit une série de test
            while (line != null) {
                listeTests.add(new Test());
                //lire un test a la fois
                line = bufferedReader.readLine();

                if (line != null && !line.isEmpty()) {
                    listeTests.get(listeTests.size() - 1).setName(line);
                }else{
                    listeTests.remove(listeTests.size() - 1);
                    break;
                }


                line = bufferedReader.readLine();
                if (line != null) {
                    listeTests.get(listeTests.size() - 1).setNbQuestion(Integer.parseInt(line));
                }
                line = bufferedReader.readLine(); // --
                for (int i = 0; i < listeTests.get(listeTests.size() - 1).getNbQuestion(); i++) {
                    line = bufferedReader.readLine(); // enonce
                    while (!line.equals(SÉPARATEUR_QUESTIONS)) {
                        if(line.isEmpty())
                            tempStr += "\n\n";
                        else
                            tempStr += line;

                        line = bufferedReader.readLine();
                    }
                    listeTests.get(listeTests.size() - 1).getQuestion().add(tempStr);
                    tempStr = "";
                    line = bufferedReader.readLine();
                    listeTests.get(listeTests.size() - 1).getChoixReponse().add(line);
                    line = bufferedReader.readLine();// ----
                    line = bufferedReader.readLine();//reponse
                    listeTests.get(listeTests.size() - 1).getReponses().add(Integer.parseInt(line));
                    line = bufferedReader.readLine();
                }

            }
        }catch(FileNotFoundException ex) {
            System.out.println(
                    "impossible d'ouvrir le fichier'" +
                            tests + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Erreur en lisant le fichier'"
                            + tests + "'");

        }

        return listeTests;
    }

    public static void main(String[]args){
        Path p1 = Paths.get(SAUVEGARDETEST.toURI());
        System.out.println(p1);
    }
}

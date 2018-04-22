import java.io.*;
import java.util.ArrayList;


public class LectureEtEcritureFichier {

    //Écriture de fichier
    private static final String SÉPARATEUR_TESTS = "=====";
    private static final String SÉPARATEUR_QUESTIONS = "-----";
    private static final String SÉPARATEUR_CHOIX_REPONSES = "<>";
    private static File SAUVEGARDETEST = new File("/home/philippe/Desktop/Programmation2/tp3Prog2/src/tests.txt");

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
        //TODO Enoncer n'est jamais utilisier
        //String enoncer = test.getEnonce();
        //pw.println(enoncer);
        //pw.println(SÉPARATEUR_QUESTIONS);
        String question;
        String choixReponse;
        int reponse;

        //boucle for print question et choix de reponses
        int j = 0;
        int y = 0;
        int x = 4;
        int z = 1;
        for (int i = 0; i < test.getQuestion().size(); i ++) {
            question = test.getQuestion().get(i);
            pw.println(question);
            pw.println(SÉPARATEUR_QUESTIONS);
            while (j < x) {
                choixReponse = test.getChoixReponse().get(j);
                pw.print(choixReponse);
                if (j + 1 < x) {
                    pw.print(SÉPARATEUR_CHOIX_REPONSES);
                } else if (j + 1 == x){
                    pw.println();
                }
                j ++;
            }
            x = x + 4;
            pw.println(SÉPARATEUR_QUESTIONS);
            while (y < z) {
                reponse = test.getReponses().get(y);
                pw.println(reponse);
                if (test.getReponses().size() - 1 != y) {
                    pw.println(SÉPARATEUR_QUESTIONS);
                } else {
                    pw.println(SÉPARATEUR_TESTS);
                }
                y ++;
            }
            z ++;
        }


        pw.close();

    }

    //Lecture des fichiers
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

    public static void main(String[] args) throws IOException {
        lecture();
    }
}

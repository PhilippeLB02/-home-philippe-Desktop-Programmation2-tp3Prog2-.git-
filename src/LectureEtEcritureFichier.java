import java.io.*;
import java.util.ArrayList;


public class LectureEtEcritureFichier {

    //Écriture de fichier
    private static final String SÉPARATEUR_TESTS = "=====";
    private static final String SÉPARATEUR_QUESTIONS = "-----";
    private static final String SÉPARATEUR_CHOIX_REPONSES = "<>";
    private static File SAUVEGARDETEST = new File("/home/philippe/Desktop/Programmation2/tp3Prog2/src/tests2.txt");

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
        int z = 1;
        for (int i = 0; i < test.getQuestion().size(); i ++) {
            question = test.getQuestion().get(i);
            pw.println(question);
            pw.println(SÉPARATEUR_QUESTIONS);
            while (j < z) {
                choixReponse = test.getChoixReponse().get(y);
                pw.println(choixReponse);
                pw.println(SÉPARATEUR_QUESTIONS);
                j ++;
            }
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
        // FileReader reads text files in the default encoding.
        FileReader fileReader =
                new FileReader(tests);
        // Always wrap FileReader in BufferedReader.
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
            //System.out.println("????? "+line);
            if (line != null) {
                listeTests.get(listeTests.size() - 1).setNbQuestion(Integer.parseInt(line));
            }
            line = bufferedReader.readLine(); // --
            for (int i = 0; i < listeTests.get(listeTests.size() - 1).getNbQuestion(); i++) {
                line = bufferedReader.readLine(); // enonce
                while (!line.equals(SÉPARATEUR_QUESTIONS)) {
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

            System.out.println("line? "+line);
            //System.out.println("reponses " + listeTests.get(listeTests.size() - 1).getRepones().get(1));
            //System.out.println("questions " + listeTests.get(listeTests.size() - 1).getQuestion().get(1));
            //System.out.println("chx " + listeTests.get(listeTests.size() - 1).getChoixReponse());
            //System.out.println("titre " + listeTests.get(listeTests.size() - 1).getName());

        }
        System.out.println("FIN "+listeTests.size());
    }catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            tests + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + tests + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        return listeTests;
    }

    public static void main(String[] args) throws IOException {
        lecture();
    }
}

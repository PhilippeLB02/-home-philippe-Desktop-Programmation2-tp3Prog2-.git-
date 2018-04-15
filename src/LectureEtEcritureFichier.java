import java.io.*;


public class LectureEtEcritureFichier {

    //Écriture de fichier
    private static final String SÉPARATEUR_TESTS = "=====";
    private static final String SÉPARATEUR_QUESTIONS = "-----";
    private static final String SÉPARATEUR_CHOIX_REPONSES = "<>";
    private static File SAUVEGARDETEST = new File("/home/philippe/Desktop/Programmation2/tp3Prog2/src/SauvegardeDeTest.txt");


    public static void ecriture(Test test) throws IOException{

        if (!SAUVEGARDETEST.exists()){
            SAUVEGARDETEST.createNewFile();
        }

        FileWriter fw = new FileWriter(SAUVEGARDETEST, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println(SÉPARATEUR_TESTS);
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
        for (int i = 0; i < test.getQuestion().size(); i ++ ){
            question = test.getQuestion().get(i);
            pw.println(question);
            pw.println(SÉPARATEUR_QUESTIONS);
            while (j < x){
                choixReponse = test.getChoixReponse().get(j);
                pw.print(choixReponse);
                if (j != test.getChoixReponse().size() -1) {
                    pw.print(SÉPARATEUR_CHOIX_REPONSES);
                } else {
                    pw.println();
                    pw.println(SÉPARATEUR_QUESTIONS);
                }
                j ++;
            }
            x = x + 4;
            while (y < z){
                reponse = test.getRepones().get(y);
                pw.println(reponse);
                pw.println(SÉPARATEUR_QUESTIONS);
                y ++;
            }
            z ++;
        }


        pw.close();

    }

    //Lecture des fichiers
    //TODO arrenger la lecture pour quelle la totaliter du fichier
    //elle lit juste le premier test.
    public static Test lecture() throws IOException{

        String tests = GenerateurTests.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "tests.txt";
        String line;
        Test listeTests = new Test();

        // FileReader reads text files in the default encoding.
        FileReader fileReader =
                new FileReader(tests);
        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader =
                new BufferedReader(fileReader);

        while (bufferedReader.ready()) {
            //lire un test a la fois
            line = bufferedReader.readLine();
            if (line != null) {
                listeTests.setName(line);
            }
            line = bufferedReader.readLine();
            if (line != null) {
                listeTests.setNbQuestion(Integer.parseInt(line));
            }
            line = bufferedReader.readLine(); // ----
            line = bufferedReader.readLine();
            listeTests.setEnonce(line);


            line = bufferedReader.readLine();

            if (line.isEmpty()) {
                line = bufferedReader.readLine();
            }
            int nbLigneTest = 6 * listeTests.getNbQuestion();

            int ligneLu = 1;
            for (int j = 1; j <= nbLigneTest; j++) {
                /*if(line != null){
                    listeTests.getQuestion().add(line);
                }
                line = bufferedReader.readLine();
                if(line != null){
                    listeTests.getChoixReponse().add(line);
                }
                line = bufferedReader.readLine();
                if(line != null){
                    listeTests.getRepones().add(Integer.parseInt(line));
                }*/
                switch (ligneLu) {
                    case 1:
                        if (line != null) {
                            listeTests.getQuestion().add(line);
                        }
                        break;
                    case 3:
                        if (line != null) {
                            listeTests.getChoixReponse().add(line);
                        }
                        break;
                    case 5:
                        if (line != null) {
                            listeTests.getRepones().add(Integer.parseInt(line));
                        }
                        break;
                    case 6:
                        ligneLu = 0;
                        break;
                }
                line = bufferedReader.readLine();
                ligneLu++;

            }
            // Always close files.
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //TODO doit etre placer dans une liste ou arrayliste
            System.out.println("enonces "+listeTests.getEnonce());
            System.out.println("reponses "+listeTests.getRepones());
            System.out.println("questions "+listeTests.getQuestion());

        }

        return listeTests;
    }

}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GenerateurTests {

    public static void main (String[]args){
        final String SÉPARATEUR_TESTS = "=====";
        final String SÉPARATEUR_QUESTIONS = "-----";
        final String SÉPARATEUR_CHOIX_REPONSES = "<>";

        Test v = new Test();

        String tests = GenerateurTests.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"tests2.txt";
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(tests);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            //lire un test a la fois
            line = bufferedReader.readLine();
            if(line != null){
                v.setName(line);
            }
            line = bufferedReader.readLine();
            if(line != null){
                v.setNbQuestion(Integer.parseInt(line));
            }
            line = bufferedReader.readLine(); // ----
            line = bufferedReader.readLine();
            v.setEnonce(line);


            line = bufferedReader.readLine();

            if(line.isEmpty()){
                line = bufferedReader.readLine();
            }
            int nbLigneTest = 6* v.getNbQuestion();

            int ligneLu = 1;
            for(int j=1; j<=nbLigneTest;j++){
                /*if(line != null){
                    v.getQuestion().add(line);
                }
                line = bufferedReader.readLine();
                if(line != null){
                    v.getChoixReponse().add(line);
                }
                line = bufferedReader.readLine();
                if(line != null){
                    v.getRepones().add(Integer.parseInt(line));
                }*/
                switch (ligneLu) {
                    case 1:     if(line != null){v.getQuestion().add(line);}
                        break;
                    case 3:     if(line != null){v.getChoixReponse().add(line);}
                        break;
                    case 5:     if(line != null){v.getRepones().add(Integer.parseInt(line));}
                        break;
                    case 6:     ligneLu = 0;
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
        }
        catch(FileNotFoundException ex) {
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

        System.out.println("enonces "+v.getEnonce());
        System.out.println("reponses "+v.getRepones());
        System.out.println("questions "+v.getQuestion());
        //new FenetreMenu();
    }
}
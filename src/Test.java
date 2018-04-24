//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.ArrayList;

public class Test {

    //Atribut d'instance de l'objet test
    private String name;
    private Integer nbQuestion;
    private ArrayList<String> question = new ArrayList();
    private ArrayList<String> choixReponse = new ArrayList();
    private ArrayList<Integer> reponses = new ArrayList();
    private int questionCourante;

    /**
     * Constructeur vide de test
     */
    public Test() {
    }

    /**
     * getters pour aler chercher la reponse
     * @return la reponse d'un question
     */
    public ArrayList<Integer> getReponses() {
        return reponses;
    }

    /**
     * setters pour reinitialser la reponse
     * @param reponses changement de valeur
     */
    public void setReponses(ArrayList<Integer> reponses) {
        this.reponses = reponses;
    }

    /**
     * getters pour aller chercher le nom du test
     * @return le nom du test
     */
    public String getName() {
        return this.name;
    }

    /**
     * setters pour changer la valeur du nom du test
     * @param name le nouveau nom du test
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getters pour aller chercher le nombre de question dans le test
     * @return le nombre de question dans le test
     */
    public Integer getNbQuestion() {
        return this.nbQuestion;
    }

    /**
     * setters pour changer le nombre de question dans le test
     * @param nbQuestion le nouveau nombre de question dans le test
     */
    public void setNbQuestion(Integer nbQuestion) {
        this.nbQuestion = nbQuestion;
    }

    /**
     * getters pour aller chercher toutes les question dans le test
     * @return une array liste de questions
     */
    public ArrayList<String> getQuestion() {
        return this.question;
    }

    /**
     * getters pour aller chercher une question a un index précis
     * @param i index ou aller chercher la question
     * @return la question a index i.
     */
    public String getQuestion(int i){
        return question.get(i);
    }

    /**
     * setters pour changer les questions d'un test
     * @param question les nouvelles questions a chenger
     */
    public void setQuestion(ArrayList<String> question) {
        this.question = question;
    }

    /**
     * getters pour aller chercher les choix de reponse
     * @return les choix de reponses dans un array liste
     */
    public ArrayList<String> getChoixReponse() {
        return this.choixReponse;
    }

    /**
     * setters pour changer les choix de reponse des questions
     * @param choixReponse les nouvelles questions qui sont a changer
     */
    public void setChoixReponse(ArrayList<String> choixReponse) {
        this.choixReponse = choixReponse;
    }

    /**
     * getters pour aller chercher la question courante
     * @return la question courante du test
     */
    public int getQuestionCourante() {
        return this.questionCourante;
    }

    /**
     * setters pour changer la question courante d'un test
     * @param questionCourante l'index pour la nouvelle question courante
     */
    public void setQuestionCourante(int questionCourante) {
        this.questionCourante = questionCourante;
    }
}


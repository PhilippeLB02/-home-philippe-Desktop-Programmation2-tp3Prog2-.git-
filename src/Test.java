//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.ArrayList;

public class Test {
    private String name;
    private Integer nbQuestion;
    private String enonce;
    private ArrayList<String> question = new ArrayList();
    private ArrayList<String> choixReponse = new ArrayList();
    private ArrayList<Integer> repones = new ArrayList();
    private int questionCourante;

    public Test() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNbQuestion() {
        return this.nbQuestion;
    }

    public void setNbQuestion(Integer nbQuestion) {
        this.nbQuestion = nbQuestion;
    }

    public String getEnonce() {
        return this.enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public ArrayList<String> getQuestion() {
        return this.question;
    }

    public void setQuestion(ArrayList<String> question) {
        this.question = question;
    }

    public ArrayList<String> getChoixReponse() {
        return this.choixReponse;
    }

    public void setChoixReponse(ArrayList<String> choixReponse) {
        this.choixReponse = choixReponse;
    }

    public ArrayList<Integer> getRepones() {
        return this.repones;
    }

    public void setRepones(ArrayList<Integer> repones) {
        this.repones = repones;
    }

    public int getQuestionCourante() {
        return this.questionCourante;
    }

    public void setQuestionCourante(int questionCourante) {
        this.questionCourante = questionCourante;
    }
}

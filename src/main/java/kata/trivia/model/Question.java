package kata.trivia.model;

/**
 * Created by joy12 on 2017/12/9.
 */
public class Question {
    private String q;
    private String a;

    public Question() {
    }

    public Question(String q, String a) {
        this.q = q;
        this.a = a;
    }

    public Question(String msg){
        q = msg;
        a = "";
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public boolean isCorrectAnswer(String ans){
        return a.equals(ans);
    }
}

package hu.huzsi.IPFQuiz;

public class KerdesValasz {
    private String question; // Kérdés
    private String answer_a; // A) válasz
    private String answer_b; // B) válasz
    private String answer_c; // C) válasz
    private String solution; // Eredmény

    // Kontsruktor
    public KerdesValasz(String sor) {
        String[] s = sor.split(";");
        this.question = s[0];
        this.answer_a = s[1];
        this.answer_b = s[2];
        this.answer_c = s[3];
        this.solution = s[4];
    }

    public String getQuestion(){ // Kérdés getter
        return question;
    }
    public String getAnswer_a(){ // A) válasz getter
        return answer_a;
    }
    public String getAnswer_b(){ // B) válasz getter
        return answer_b;
    }
    public String getAnswer_c(){ // C) válasz getter
        return answer_c;
    }
    public String getSolution(){ // Eredmény getter
        return solution;
    }

}

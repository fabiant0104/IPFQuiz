package hu.huzsi.validipfquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;
import java.io.*;

public class HelloController {
    // The FÁÁJL
    public List<KerdesValasz> adatok = readFile("kerdesek_javitott.txt");
    public static List<String> valasz = new ArrayList<>();
    public int questionIndex = 0;
    public static int count = 0;

    @FXML // Eredmény Label
    private Label eredmenyLabel;

    @FXML // Kérdések "Label"
    private TextArea questionsLabel;

    @FXML // Válasz gombok
    private Button answ1, answ2, answ3;

    public void answ1BtnStart(ActionEvent event)    { /* A) Gomb */
        if (questionIndex != adatok.size())
            valasz.add("a");
        loadQuestion();
    }

    public void answ2BtnStart(ActionEvent event) { /* B) Gomb */
        if (questionIndex != adatok.size())
            valasz.add("b");
        loadQuestion();
    }

    public void answ3BtnStart(ActionEvent event) { /* C) Gomb */
        if (questionIndex != adatok.size())
            valasz.add("c");
        loadQuestion();
    }


    public void loadQuestion(){ /* Kérdések betöltése */
        if (questionIndex != adatok.size()){
            questionsLabel.setText(adatok.get(questionIndex).getQuestion());
            answ1.setText(adatok.get(questionIndex).getAnswer_a());
            answ2.setText(adatok.get(questionIndex).getAnswer_b());
            answ3.setText(adatok.get(questionIndex).getAnswer_c());
            questionIndex++;

        } else{
            for (int i = 0; i < valasz.size(); i++) {
                if(valasz.get(i).equalsIgnoreCase(adatok.get(i).getSolution())){
                    count++;
                }

            }
            valasz.clear();
            eredmenyLabel.setText(String.format("Eredményed: %.2f%%", ellenorzes()));
        }


    }
    public double ellenorzes(){ /* Eredmény */
        return ((double) count/adatok.size())*100;
    }
    public static List<KerdesValasz> readFile(String filename){ /* Fájlbekérés */
        List<KerdesValasz> adatok = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine()) != null){
                KerdesValasz t = new KerdesValasz(line.trim());
                adatok.add(t);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return adatok;
    }
}
module hu.huzsi.IPFQuiz {
    requires javafx.controls;
    requires javafx.fxml;


    opens hu.huzsi.IPFQuiz to javafx.fxml;
    exports hu.huzsi.IPFQuiz;
}
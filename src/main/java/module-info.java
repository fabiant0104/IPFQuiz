module hu.huzsi.IPFQuiz {
    requires javafx.controls;
    requires javafx.fxml;


    opens hu.huzsi.validipfquiz to javafx.fxml;
    exports hu.huzsi.validipfquiz;
}
module com.example.calcolatrice_esame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calcolatrice_esame to javafx.fxml;
    exports com.example.calcolatrice_esame;
}
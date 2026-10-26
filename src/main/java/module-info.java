module com.example.fx_5_codealong {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fx_5_codealong to javafx.fxml;
    exports com.example.fx_5_codealong;
}
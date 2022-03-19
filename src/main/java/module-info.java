module Congress.main {

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires javafx.controls;
    requires javafx.fxml;
    opens com.congress;
    exports com.congress;
    exports com.userinterface;

}
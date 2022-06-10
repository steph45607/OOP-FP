module com.oopfp.focustime {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.google.gson;
    requires java.sql;
    // requires gson;

//    to open the application and be accessible by gson module
//    so can access the private attributes in the application
    opens com.oopfp.focustime to gson;
    exports com.oopfp.focustime;
}
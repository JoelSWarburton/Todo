module com.joelwarburton.todo {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.joelwarburton.todo.core;
    opens com.joelwarburton.todo.core to javafx.fxml;
    exports com.joelwarburton.todo.gui;
    opens com.joelwarburton.todo.gui to javafx.fxml;
}
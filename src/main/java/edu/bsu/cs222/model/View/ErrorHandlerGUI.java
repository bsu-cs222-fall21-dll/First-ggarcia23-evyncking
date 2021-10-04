package edu.bsu.cs222.model.View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ErrorHandlerGUI {
    public void getError() {
        VBox parent = new VBox();
        parent.setAlignment(Pos.TOP_CENTER);
        parent.setSpacing(8);
        parent.getChildren().add(new Label("WARNING"));
        parent.getChildren().add(new Label(""));
    }
}

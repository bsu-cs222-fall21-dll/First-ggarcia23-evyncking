package edu.bsu.cs222.model.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WikipediaGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox parent = new VBox();
        parent.setAlignment(Pos.BASELINE_CENTER);
        parent.setSpacing(8);
        parent.getChildren().add(new Label("ONS Wikipedia Revision Parser"));

        HBox urlArea = new HBox(new Label("Article Name: "));
        urlArea.setAlignment(Pos.BASELINE_CENTER);
        TextField textField = new TextField();
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);

        Button button = new Button("Search Wikipedia");
        button.setOnAction(event -> System.out.println("I would access a class" + textField.getText() + " here"));
        parent.getChildren().add(button);

        primaryStage.setTitle("ONS Wikipedia Revision");
        primaryStage.setScene(new Scene(parent, 350, 300));
        primaryStage.show();
    }
}

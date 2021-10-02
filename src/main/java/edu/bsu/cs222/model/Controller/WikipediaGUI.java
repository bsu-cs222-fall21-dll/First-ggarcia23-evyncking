package edu.bsu.cs222.model.Controller;

import edu.bsu.cs222.model.Model.InputParser;
import edu.bsu.cs222.model.View.UserInterface;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;


public class WikipediaGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox parent = new VBox();
        parent.setAlignment(Pos.BASELINE_CENTER);
        parent.setSpacing(8);
        parent.getChildren().add(new Label("ONS Wikipedia Revision Parser"));

        HBox urlArea = new HBox(new Label("Article Name: "));
        urlArea.setAlignment(Pos.BASELINE_CENTER);

        TextField inputTextField = new TextField();
        urlArea.getChildren().add(inputTextField);

        TextField outputField = new TextField();
        outputField.setPrefSize(10,10);

        parent.getChildren().add(urlArea);

        Button button = new Button("Search");
        button.setOnAction(event -> {

            if (inputTextField.getText().equals("") || inputTextField.getText().equals("\n")){
                outputField.setText("Missing input...");
                //System.exit(1);
            } else {
                outputField.setText("This is where the revisions of " + inputTextField.getText() + " would go");
            }
        });

        parent.getChildren().add(button);
        parent.getChildren().add(outputField);

        primaryStage.setTitle("ONS Wikipedia Revision");
        primaryStage.setScene(new Scene(parent, 350, 250));
        primaryStage.show();
    }
}

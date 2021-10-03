package edu.bsu.cs222.model.Controller;

import edu.bsu.cs222.model.Model.InputParser;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;


public class WikipediaGUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox parent = new VBox();
        parent.setAlignment(Pos.TOP_CENTER);
        parent.setSpacing(8);
        parent.getChildren().add(new Label("ONS Wikipedia Revision Parser"));

        HBox urlArea = new HBox(new Label("Article Name: "));
        urlArea.setAlignment(Pos.TOP_CENTER);

        TextField inputTextField = new TextField();
        urlArea.getChildren().add(inputTextField);

        TextArea outputField = new TextArea();
        outputField.setPrefSize(350,400);
        outputField.setMaxSize(1000,1000);


        parent.getChildren().add(urlArea);

        Button search = new Button("Search");
        search.setOnAction(event -> {

            UserInterfaceFormatter userInterfaceFormatter = new UserInterfaceFormatter();
            InputManager inputManager = new InputManager();
            InputParser jsonInputParser = new InputParser();

            InputStream inputStream = null;
            try {
                inputStream = inputManager.getArticle(inputTextField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONArray jsonInput = null;
            try {
                jsonInput = jsonInputParser.parseJSON(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            outputField.setText(String.valueOf(jsonInput));
            outputField.setText(userInterfaceFormatter.getRedirectInfo(jsonInput) +
                    "\n" + userInterfaceFormatter.formatRevisions(jsonInput));

        });

        Button exit = new Button("Exit");
        exit.setOnAction(event -> {
            System.exit(0);
        });

        parent.getChildren().add(search);
        parent.getChildren().add(exit);
        parent.getChildren().add(outputField);

        primaryStage.setTitle("ONS Wikipedia Revision");
        primaryStage.setScene(new Scene(parent, 370, 425));
        primaryStage.show();
    }
}

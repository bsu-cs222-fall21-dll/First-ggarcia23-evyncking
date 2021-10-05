package edu.bsu.cs222.model.View;

import edu.bsu.cs222.model.Controller.UserInterfaceFormatter;
import edu.bsu.cs222.model.Controller.GUISearchButton;
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

public class GUIBuilder extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
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
            GUISearchButton guiSearchButton = new GUISearchButton();
            UserInterfaceFormatter userInterfaceFormatter = new UserInterfaceFormatter();
            JSONArray jsonArray = null;

            try {
                jsonArray = guiSearchButton.getParseJSON(inputTextField);
            } catch (IOException e) {
                e.printStackTrace();
            }

            outputField.setText(String.valueOf(jsonArray));
            outputField.setText(userInterfaceFormatter.getRedirectInfo(jsonArray) +
                    "\n" + userInterfaceFormatter.formatRevisions(jsonArray));
        });

        Button exit = new Button("Exit");
        exit.setOnAction(event -> {
            System.exit(0);
        });

        parent.getChildren().addAll(search, exit, outputField);

        primaryStage.setScene(new Scene(parent, 370, 425));
        primaryStage.show();
    }
}

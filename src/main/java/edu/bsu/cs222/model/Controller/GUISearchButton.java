package edu.bsu.cs222.model.Controller;

import edu.bsu.cs222.model.Model.InputParser;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;


public class GUISearchButton {
    public JSONArray getParseJSON(TextField input) throws IOException {
        InputParser jsonInputParser = new InputParser();
        JSONArray jsonArray;

        jsonArray = jsonInputParser.parseJSON(searchButton(input));

        if (Objects.equals(input.getText(), "")) {
            Alert inputAlert = new Alert(Alert.AlertType.ERROR);
            inputAlert.setHeaderText("Error Code 1");
            inputAlert.setContentText("Input Not Found: Error Code 1");
            inputAlert.showAndWait();
            System.exit(1);
        }

        if (!jsonInputParser.checkIfArticleExists(jsonArray)) {
            Alert articleAlert = new Alert(Alert.AlertType.ERROR);
            articleAlert.setHeaderText("Error Code 2");
            articleAlert.setContentText("Article Not Found: Error Code 2");
            articleAlert.showAndWait();
            System.exit(2);
        }

        return jsonArray;
    }

    private InputStream searchButton(TextField input) throws IOException {
        InputManager inputManager = new InputManager();
        InputStream inputStream;

        inputStream = inputManager.getArticle(input.getText());
        return inputStream;
    }

}

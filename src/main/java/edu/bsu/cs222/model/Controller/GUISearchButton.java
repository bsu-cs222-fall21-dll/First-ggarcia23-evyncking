package edu.bsu.cs222.model.Controller;

import edu.bsu.cs222.model.Model.InputParser;
import javafx.scene.control.TextField;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;


public class GUISearchButton {
    public JSONArray getParseJSON(TextField input) throws IOException {
        InputParser jsonInputParser = new InputParser();
        JSONArray jsonArray;

        jsonArray = jsonInputParser.parseJSON(searchButton(input));
        return jsonArray;
    }

    private InputStream searchButton(TextField input) throws IOException {
        InputManager inputManager = new InputManager();
        InputStream inputStream;

        inputStream = inputManager.getArticle(input.getText());
        return inputStream;
    }
}

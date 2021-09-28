package edu.bsu.cs222.model.Controller;

import edu.bsu.cs222.model.Model.InputParser;
import edu.bsu.cs222.model.View.UserInterface;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;

public class WikiController {
    public void runProgram() throws IOException {
        UserInterface userInterface = new UserInterface();
        UserInterfaceFormatter userInterfaceFormatter = new UserInterfaceFormatter();
        InputManager inputManager = new InputManager();
        InputParser jsonInputParser = new InputParser();

        System.out.println(userInterface.wikiUI());
        InputStream inputStream = inputManager.getArticle();

        JSONArray jsonInput = jsonInputParser.parseJSON(inputStream);

        userInterface.printMessage(userInterfaceFormatter.getRedirectInfo(jsonInput));
        userInterface.printMessage(userInterfaceFormatter.formatRevisions(jsonInput));
    }
}

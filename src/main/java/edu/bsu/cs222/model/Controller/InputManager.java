package edu.bsu.cs222.model.Controller;

import edu.bsu.cs222.model.Model.URLFormatter;
import edu.bsu.cs222.model.View.UserInput;

import java.io.IOException;
import java.io.InputStream;

public class InputManager {
    private String getUserInput(){
        UserInput userInput = new UserInput();
        return userInput.getTitle();


    }

    public InputStream getArticle() throws IOException {
        String title = getUserInput();
        URLFormatter urlFormatter = new URLFormatter(title);
        return urlFormatter.makeConnectionToURL();
    }

}

package edu.bsu.cs222.model.Controller;

import edu.bsu.cs222.model.Model.URLFormatter;
import edu.bsu.cs222.model.View.UserInput;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class InputManager {

    public InputStream getArticle() throws IOException {
        UserInput userInput = new UserInput();
        String title = modifyInput(userInput.getTitle());
        URLFormatter urlFormatter = new URLFormatter();
        return urlFormatter.makeConnectionToURL(title);
    }

    public String modifyInput(String userInput) {
        String articleString = null;
        try {
            articleString = URLEncoder.encode(userInput, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return articleString;
    }

}

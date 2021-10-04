package edu.bsu.cs222.model;

import edu.bsu.cs222.model.Controller.UserInterfaceFormatter;
import edu.bsu.cs222.model.Controller.WikipediaGUI;
import edu.bsu.cs222.model.Model.InputParser;
import javafx.stage.Stage;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class GUIRedirectionTest {
    @Test
    public void GUIRedirection() throws IOException {
        InputStream sampleFileInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        InputParser inputParser = new InputParser();
        UserInterfaceFormatter userInterfaceFormatterTest = new UserInterfaceFormatter();
        JSONArray jsonArray = inputParser.parseJSON(sampleFileInputStream);
        String testRedirectInfo = userInterfaceFormatterTest.getRedirectInfo(testInput());


        String redirectionString = "Redirected to Frank Zappa";

        Assertions.assertEquals(redirectionString, testRedirectInfo);
    }

    private JSONArray testInput() throws IOException {
        InputParser inputParser = new InputParser();
        InputStream sampleFileInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        return inputParser.parseJSON(sampleFileInputStream);
    }

}

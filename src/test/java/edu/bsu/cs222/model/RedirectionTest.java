package edu.bsu.cs222.model;

import edu.bsu.cs222.model.Controller.UserInterfaceFormatter;
import edu.bsu.cs222.model.Model.InputParser;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RedirectionTest {
    @Test
    public void redirectionTest() throws IOException {
        UserInterfaceFormatter userInterfaceFormatterTest = new UserInterfaceFormatter();
        String testRedirectInfo = userInterfaceFormatterTest.getRedirectInfo(testInput());
        Assertions.assertEquals("Redirected to Frank Zappa.",testRedirectInfo);
    }

    private JSONArray testInput() throws IOException {
        InputParser inputParser = new InputParser();
        InputStream sampleFileInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        return inputParser.parseJSON(sampleFileInputStream);
    }

}

package edu.bsu.cs222.model;

import edu.bsu.cs222.model.Controller.UserInterfaceFormatter;
import edu.bsu.cs222.model.Model.InputParser;
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

    @Test
    public void revisionsTest() throws IOException {
        InputStream sampleFileInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        InputParser inputParser = new InputParser();
        UserInterfaceFormatter userInterfaceFormatterTest = new UserInterfaceFormatter();

        JSONArray jsonArray = inputParser.parseJSON(sampleFileInputStream);

        String testRevision = userInterfaceFormatterTest.formatRevisions(testInput());
        Assertions.assertEquals(revisionStringTest(), testRevision);

    }

    private String revisionStringTest() {
        return String.format("09/19/2021 01:09:23 75.172.213.218%n" +
                "09/19/2021 00:54:29 75.172.213.218%n" +
                "09/18/2021 23:53:23 MusikBot II%n" +
                "09/18/2021 12:33:00 Anon423%n");
    }

}

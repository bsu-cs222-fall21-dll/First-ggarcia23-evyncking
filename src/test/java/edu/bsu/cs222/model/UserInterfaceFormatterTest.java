package edu.bsu.cs222.model;

import edu.bsu.cs222.model.Controller.UserInterfaceFormatter;
import edu.bsu.cs222.model.Model.InputParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;

public class UserInterfaceFormatterTest {

    @Test
    public void revisionFormatTest() throws IOException {
        InputParser inputParser = new InputParser();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        UserInterfaceFormatter userInterfaceFormatter = new UserInterfaceFormatter();
        String redirectInformationTest = userInterfaceFormatter.formatRevisions(inputParser.parseJSON(inputStream));
        Assertions.assertEquals( testRevisionsString(), redirectInformationTest);
    }

    private String testRevisionsString(){

        return String.format("09/19/2021 01:09:23 75.172.213.218%n" +
                "09/19/2021 00:54:29 75.172.213.218%n" +
                "09/18/2021 23:53:23 MusikBot II%n" +
                "09/18/2021 12:33:00 Anon423%n");
    }

}

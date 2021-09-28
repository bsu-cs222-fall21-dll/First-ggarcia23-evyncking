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

        return String.format("2021-09-19T01:09:23Z 75.172.213.218%n" +
                "2021-09-19T00:54:29Z 75.172.213.218%n" +
                "2021-09-18T23:53:23Z MusikBot II%n" +
                "2021-09-18T12:33:00Z Anon423%n");
    }

}

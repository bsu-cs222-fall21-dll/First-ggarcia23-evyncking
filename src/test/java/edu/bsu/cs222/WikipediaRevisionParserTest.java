package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParserTest {

    @Test
    public void testParse() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamp =  parser.parse(testDataStream);
        Assertions.assertEquals("2021-09-19T01:09:23Z", timestamp);
    }

    @Test
    public void testFindName() throws IOException {
        WikipediaUsernameParser parser = new WikipediaUsernameParser();
        InputStream testDataStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String user = parser.parse(testDataStream);
        Assertions.assertEquals("MusikBot II", user);
    }
}

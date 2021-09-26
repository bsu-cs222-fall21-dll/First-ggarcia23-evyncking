package edu.bsu.cs222.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaTimestampParserTest {

    @Test
    public void getTimestampRevisionAtIndex() throws IOException {
        WikipediaRevisionParser revisionParser = new WikipediaRevisionParser();
        InputStream testInput = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("test.json");

        WikipediaRevision revisionTest = revisionParser.parse(testInput).get(2);
        Assertions.assertEquals("2021-09-18T23:53:23Z", revisionTest.getTimeStamp());
    }

}

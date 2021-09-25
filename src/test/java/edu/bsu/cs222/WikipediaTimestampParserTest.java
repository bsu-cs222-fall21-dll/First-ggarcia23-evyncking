package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaTimestampParserTest {
    @Test
    public void testTimestampParse() throws IOException {
        WikipediaTimestampParser parser = new WikipediaTimestampParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamp = parser.parse(testDataStream);
        Assertions.assertEquals("2021-09-19T01:09:23Z 2021-09-19T00:54:29Z 2021-09-18T23:53:23Z 2021-09-18T12:33:00Z "
                , timestamp);
    }
}

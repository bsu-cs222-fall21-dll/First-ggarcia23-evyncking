package edu.bsu.cs222.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParserAtIndex {
    @Test
    public void TimestampAtFirstIndex() throws IOException {
        WikipediaRevisionParser revisionParser = new WikipediaRevisionParser();
        InputStream testInput = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision revision = revisionParser.parse(testInput).get(0);
        Assertions.assertEquals("2021-09-19T01:09:23Z", revision.getTimeStamp());
    }
}

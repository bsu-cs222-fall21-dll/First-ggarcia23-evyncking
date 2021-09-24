package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class FindNameTest {
    @Test
    public void testFindName() throws IOException {
        WikipediaUsernameParser parser = new WikipediaUsernameParser();
        InputStream testDataStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String user = parser.parse(testDataStream);
        Assertions.assertEquals("75.172.213.218", user);
    }
}

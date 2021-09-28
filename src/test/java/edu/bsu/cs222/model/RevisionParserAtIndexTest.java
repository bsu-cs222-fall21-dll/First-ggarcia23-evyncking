package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParserAtIndexTest {
    @Test
    public void getTimestampAtIndexTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray timestamp = JsonPath.read(inputStream, "$..timestamp");
        Assertions.assertEquals("2021-09-19T01:09:23Z", timestamp.get(0).toString());
    }

    @Test
    public void getUserAtIndexTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray username = JsonPath.read(inputStream, "$..user");
        Assertions.assertEquals("75.172.213.218", username.get(0).toString());
    }

    @Test
    public void getTimestampAtIndexThreeTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray timestamp = JsonPath.read(inputStream, "$..timestamp");
        Assertions.assertEquals("2021-09-18T12:33:00Z", timestamp.get(3).toString());
    }

    @Test
    public void getUsernameAtIndexTwoTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray username = JsonPath.read(inputStream, "$..user");
        Assertions.assertEquals("MusikBot II", username.get(2).toString());
    }


}

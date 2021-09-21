package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaUsernameParser {
    public String parse(InputStream  testDataStream) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(testDataStream, "$..user");
        return result.get(2).toString();
    }
}

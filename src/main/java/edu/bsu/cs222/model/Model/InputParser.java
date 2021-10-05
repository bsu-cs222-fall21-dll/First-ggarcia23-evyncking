package edu.bsu.cs222.model.Model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;


import java.io.IOException;
import java.io.InputStream;

public class InputParser {
    public JSONArray parseJSON(InputStream dataStream) throws IOException {
        JSONArray jsonInput = JsonPath.read(dataStream, "$..query");
        checkArticleExists(jsonInput);
        return jsonInput;
    }

    public void checkArticleExists(JSONArray jsonInput) {
        JSONArray jsonArray = JsonPath.read(jsonInput, "$..missing");
        System.err.println("Article Not Found");
        System.exit(2);
    }
}


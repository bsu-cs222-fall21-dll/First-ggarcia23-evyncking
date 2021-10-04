package edu.bsu.cs222.model.Model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;


import java.io.IOException;
import java.io.InputStream;

public class InputParser {
    public JSONArray parseJSON(InputStream dataStream) throws IOException {
        JSONArray jsonInput = JsonPath.read(dataStream, "$..query");
        checkIfArticleExists(jsonInput);
        return jsonInput;
    }

    private void checkIfArticleExists(JSONArray jsonInput){
        JSONArray jsonArray = JsonPath.read(jsonInput, "$..user");

        if (jsonArray.size() <= 0) {
            System.out.println("Article Does Not Exist...");
            System.exit(2);
        }

    }
}

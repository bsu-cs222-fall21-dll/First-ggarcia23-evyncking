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

    public Boolean checkIfArticleExists(JSONArray inputJson){
        JSONArray checkingArray = JsonPath.read(inputJson,"$..user");
        if (checkingArray.size()<=0){
            System.err.println("Article Not Found: Error Code 2");
            return false;
        }
        return true;
    }
}


package edu.bsu.cs222.model.Model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class InputParser {
    public JSONArray parseJSON(InputStream dataStream) throws IOException {

        return JsonPath.read(dataStream, "$..query");
    }
}

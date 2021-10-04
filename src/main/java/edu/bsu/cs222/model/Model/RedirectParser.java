package edu.bsu.cs222.model.Model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class RedirectParser {

    public String checkForRedirect(JSONArray jsonArray) {
        try {
            JSONArray result = JsonPath.read(jsonArray,"$..redirects");
            JSONArray redirection = JsonPath.read(result,"$..to");
            return String.format("Redirected to %s", redirection.get(0).toString());
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){
            return "";
        }
    }
}


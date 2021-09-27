package edu.bsu.cs222.model.Model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class RedirectParser {
    List<JSONArray> jsonArrays;

    public RedirectParser(JSONArray dataStream) {
        this.jsonArrays = JsonPath.read(dataStream, "$..*");
    }

    public String parseRedirects() {
        List<Redirect> redirectList = redirectList();
        StringBuilder redirectString = new StringBuilder();
        for (Redirect redirect : redirectList) {
            String to = redirect.getTo();
            redirectString.append("Redirected to ").append(to).append(" ");
        }
        return redirectString.toString();
    }

    public List<Redirect> redirectList(){
        return makeRedirectList(jsonArrays);
    }


    public List<Redirect> makeRedirectList(List<JSONArray> inputStream){
        List<Redirect> list = new ArrayList<>();
        JSONArray redirect = JsonPath.read(inputStream, "$..redirects[*]");
        for (Object r : redirect) {
            String from = JsonPath.read(r, "from");
            String to = JsonPath.read(r, "to");
            list.add(new Redirect(from,to));
        }
        return list;
    }
}

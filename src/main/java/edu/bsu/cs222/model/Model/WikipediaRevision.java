package edu.bsu.cs222.model.Model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikipediaRevision {
    private JSONArray revisionContents;

    public WikipediaRevision(JSONArray revisionContents) {
        this.revisionContents = revisionContents;
    }

    public String getUser(){
        JSONArray user = JsonPath.read(revisionContents,"$..user");
        return JSONArrayToString(user);
    }

    public String getTimeStamp() {
        JSONArray timestamp = JsonPath.read(revisionContents, "$..timestamp");
        return JSONArrayToString(timestamp);
    }

    private String JSONArrayToString(JSONArray jsonArray){
        char[] jsonArrayItems = jsonArray.toString().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();


        for(int i=2 ; i<=jsonArrayItems.length ; i++){
            if(jsonArrayItems[i] == '"'){
                break;
            } else {
                stringBuilder.append(jsonArrayItems[i]);
            }
        }


        return stringBuilder.toString();
    }

}

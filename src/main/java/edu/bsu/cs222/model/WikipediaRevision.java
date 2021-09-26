package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikipediaRevision {
    private JSONArray revisionContents;

    public WikipediaRevision(JSONArray revisionContents) {
        this.revisionContents = revisionContents;
    }

    public String getUser(){
        JSONArray user = JsonPath.read(revisionContents,"$..user");

        return user.get(0).toString();
    }

    public String getTimeStamp() {
        JSONArray timestamp = JsonPath.read(revisionContents, "$..timestamp");
        return timestamp.get(0).toString();
    }
}

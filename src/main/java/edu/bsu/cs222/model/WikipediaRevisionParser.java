package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParser extends LatestRevisionOfWikipedia {
    public ArrayList<WikipediaRevision> parse(InputStream jsonFile) throws IOException {

        JSONArray revisionsJSONArray = JsonPath.read(jsonFile, "$..revisions");
        return makeRevisionList(revisionsJSONArray);
    }

    private ArrayList<WikipediaRevision> makeRevisionList(JSONArray revisionJSON){
        ArrayList<WikipediaRevision> revisionsList = new ArrayList<>();

        int length = calcArraySize(revisionJSON);
        for(int i=0;i<=length;i++) {

            WikipediaRevision revision = new WikipediaRevision(JsonPath.read(revisionJSON,String.format("$..[%d]",i)));
            revisionsList.add(revision);
        }

        return revisionsList;
    }

    private int calcArraySize(JSONArray revisionJSON){
        JSONArray userArray = JsonPath.read(revisionJSON,"$..user");
        return userArray.size();
    }
}

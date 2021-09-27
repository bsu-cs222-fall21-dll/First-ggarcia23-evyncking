package edu.bsu.cs222.model.Model;

import com.jayway.jsonpath.JsonPath;
import edu.bsu.cs222.model.Model.WikipediaRevision;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParser{
    public ArrayList<WikipediaRevision> parse(JSONArray jsonFile) {

        JSONArray revisionsJSONArray = JsonPath.read(jsonFile, "$..revisions");
        return revisionList(revisionsJSONArray);
    }

    private ArrayList<WikipediaRevision> revisionList(JSONArray revisionJSON){
        ArrayList<WikipediaRevision> revisionsList = new ArrayList<>();

        int length = findSizeOfArray(revisionJSON);
        for(int i=0;i<=length;i++) {

            WikipediaRevision revision = new WikipediaRevision(JsonPath.read(revisionJSON,String.format("$..[%d]",i)));
            revisionsList.add(revision);
            if (i==30){
                break;
            }
        }

        return revisionsList;
    }

    private int findSizeOfArray(JSONArray revisionJSON){
        JSONArray userArray = JsonPath.read(revisionJSON,"$..user");
        return userArray.size()-1;
    }
}

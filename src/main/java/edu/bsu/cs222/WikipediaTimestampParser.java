package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaTimestampParser extends LatestRevisionOfWikipedia{
    public String parse (InputStream testDataStream) throws IOException {
        JSONArray timestamp = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
        ArrayList<String> wikipediaRevisions = new ArrayList<>();
        String timestamps = "";

        for (int i = 0; i <= timestamp.size()-1; i++) {
            wikipediaRevisions.add(timestamp.get(i).toString());
            timestamps += wikipediaRevisions.get(i) + " ";
        }
        return timestamps;
    }

}

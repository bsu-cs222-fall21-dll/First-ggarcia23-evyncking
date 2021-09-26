package edu.bsu.cs222.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class LatestRevisionOfWikipedia extends URLFormatter{

    public ArrayList<WikipediaRevision> getLatestRevisionOf(String articleTitle) throws IOException {
        try {
            URL url = new URL(URLFormatter(articleTitle));
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "WikipediaRevisionReader/0.1 (ecking@bsu.edu; gagarcia3@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            WikipediaRevisionParser parser = new WikipediaRevisionParser();
            ArrayList<WikipediaRevision> revision = parser.parse(inputStream);
            return revision;
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }

}

package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class LatestRevisionOfWikipedia {
    public String getLatestRevisionOf(String articleTitle) throws IOException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&ryprop=timestamp&rylimit=1",
                articleTitle);
        String encodedURLString = URLEncoder.encode(urlString, Charset.defaultCharset());
        try {
            URL url = new URL(encodedURLString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "WikipediaRevisionReader/0.1 (ecking@bsu.edu; gagarcia3@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            WikipediaRevisionParser parser = new WikipediaRevisionParser();
            String timestamp = parser.parse(inputStream);
            return timestamp;
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }
}

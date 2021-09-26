package edu.bsu.cs222.model;

import java.net.URLEncoder;
import java.nio.charset.Charset;

public class URLFormatter {
    public String URLFormatter(String articleTitle) {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&ryprop=timestamp&rylimit=1",
                articleTitle);
        String encodedURLString = URLEncoder.encode(urlString, Charset.defaultCharset());
        return encodedURLString;
    }
}

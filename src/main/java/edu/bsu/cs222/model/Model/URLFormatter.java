package edu.bsu.cs222.model.Model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLFormatter {

    public InputStream makeConnectionToURL(String title) throws IOException {
        try {
            URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + title +
                    "&rvprop=timestamp|user&rvlimit=30&redirects");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "gagarcia3@bsu.edu ; ecking@bsu.edu");
            return connection.getInputStream();

        } catch (IOException inputMissing) {
            System.err.println("No Network Connection");
            System.exit(3);
        }
        return null;
    }

}

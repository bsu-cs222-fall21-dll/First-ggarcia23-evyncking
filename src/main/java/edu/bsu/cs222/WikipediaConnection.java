package edu.bsu.cs222;

import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class WikipediaConnection {

        private static URLConnection setUpConnectionToWikipedia() throws IOException {
                URL url = new URL(
                        "https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=xml&rvprop=timestamp%7Cuser&rvlimit=4&titles=frank%20zappa&redirects=");
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("User-Agent", "CS222FirstProject/0.1 (gagarcia3@bsu.edu; ...)");
                connection.connect();
                return connection;
        }

}

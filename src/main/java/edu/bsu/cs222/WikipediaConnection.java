package edu.bsu.cs222;

public class WikipediaConnection {
        URL url = new URL("https://en.wikipedia.org");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
            "Revision Reporter/0.1 (ecking@bsu.edu; gagarcia3@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
}

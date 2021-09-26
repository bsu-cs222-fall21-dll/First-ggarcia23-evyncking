package edu.bsu.cs222.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WikipediaRevisionReader extends LatestRevisionOfWikipedia {

    public static void main(String[] args) {
        WikipediaRevisionReader revisionReader = new WikipediaRevisionReader();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try {
            ArrayList<WikipediaRevision> timestamp = revisionReader.getLatestRevisionOf(line);
            System.out.println(timestamp);
        } catch (IOException ioException) {
            System.err.println("Network connection problem: " + ioException.getMessage());
        }
    }

}

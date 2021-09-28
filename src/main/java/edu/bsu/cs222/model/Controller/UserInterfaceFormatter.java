package edu.bsu.cs222.model.Controller;

import edu.bsu.cs222.model.Model.RedirectParser;
import edu.bsu.cs222.model.Model.RevisionFormatter;
import edu.bsu.cs222.model.Model.WikipediaRevision;
import edu.bsu.cs222.model.Model.WikipediaRevisionParser;
import net.minidev.json.JSONArray;

import java.util.ArrayList;

public class UserInterfaceFormatter {

    public String getRedirectInfo(JSONArray jsonInput) {
        RedirectParser redirectParser = new RedirectParser();
        return redirectParser.checkForRedirect(jsonInput);
    }


    public String formatRevisions(JSONArray jsonInput) {
        RevisionFormatter revisionFormatter = new RevisionFormatter();
        WikipediaRevisionParser revisionParser = new WikipediaRevisionParser();
        StringBuilder revisionsStringBuilder = new StringBuilder();
        ArrayList<WikipediaRevision> revisionsArrayList = revisionParser.parse(jsonInput);

        for(WikipediaRevision revision : revisionsArrayList){

            revisionsStringBuilder.append(revisionFormatter.revisionFormat(revision));

        }

        return revisionsStringBuilder.toString();
    }
}

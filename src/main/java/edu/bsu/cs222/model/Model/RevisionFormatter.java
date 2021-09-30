package edu.bsu.cs222.model.Model;


public class RevisionFormatter {
    public String revisionFormat(WikipediaRevision revisionToBeFormatted) {
        return String.format("%s %s%n",
                revisionToBeFormatted.getTimeStamp(), revisionToBeFormatted.getUser());
    }

}

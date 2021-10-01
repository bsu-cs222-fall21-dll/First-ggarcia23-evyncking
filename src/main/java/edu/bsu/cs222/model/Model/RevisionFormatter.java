package edu.bsu.cs222.model.Model;


public class RevisionFormatter {
    public String revisionFormat(WikipediaRevision revisionToBeFormatted) {
        return String.format("%s %s%n",
                UTCTimestampConverter(revisionToBeFormatted.getTimeStamp()), revisionToBeFormatted.getUser());
    }

    public String UTCTimestampConverter(String timestamp) {
        String year = timestamp.substring(0,4);
        String month = timestamp.substring(5,7);
        String day = timestamp.substring(8,10);
        String time = timestamp.substring(11,19);

        return String.format("%s/%s/%s %s", month, day, year, time);
    }

}

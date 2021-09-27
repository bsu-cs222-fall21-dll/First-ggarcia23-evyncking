package edu.bsu.cs222.model.Model;

public class Redirect {
    private final String to;

    public Redirect(String from, String to) {
        this.to = to;
    }


    public String getTo(){
        return to;
    }
}

package edu.bsu.cs222.model.View;

public class UserInterface {
    public String wikiUI() {
        return String.format("Search Wikipedia for Article Page: ");
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}

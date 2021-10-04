package edu.bsu.cs222.model.Controller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WikiController wikiController = new WikiController();
        wikiController.runProgram();
        System.exit(0);
    }
}

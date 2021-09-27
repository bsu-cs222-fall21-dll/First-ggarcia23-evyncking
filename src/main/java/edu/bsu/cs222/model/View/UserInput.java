package edu.bsu.cs222.model.View;

import java.util.Scanner;

public class UserInput {
    public String getTitle()  {

        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        checkCharIsEmpty(title);

        return title;

    }

    private void checkCharIsEmpty(String title){
        title = title.trim();

        if (title.equals("") || title.equals("\n")){
            System.err.println("Name of Article is Required.");
            System.exit(1);
        }
    }

}

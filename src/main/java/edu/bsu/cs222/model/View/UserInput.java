package edu.bsu.cs222.model.View;

public class UserInput {
    public String getTitle(String userInput)  {
        checkCharIsEmpty(userInput);

        return userInput;
    }

    private void checkCharIsEmpty(String title){
        if (title.equals("") || title.equals("\n")){
            System.err.println("Missing input...");
            System.exit(1);
        }
    }

}

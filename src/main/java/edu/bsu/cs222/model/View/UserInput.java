package edu.bsu.cs222.model.View;

public class UserInput {
    public String getTitle(String userInput)  {
        checkCharIsEmpty(userInput);

        return userInput;
    }

    private boolean checkCharIsEmpty(String title){
        if (title.equals("") || title.equals("\n")){
            System.err.println("Missing Input: Error Code 1");
            return false;
        }
        return true;
    }

}

package edu.bsu.cs222.model;

import edu.bsu.cs222.model.Controller.InputManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputModifierTest {
    @Test
    public void testUserInput() {
        InputManager inputManager = new InputManager();
        String userInput = "Kobe Bryant";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        Assertions.assertEquals("Kobe+Bryant", inputManager.modifyInput(userInput));
    }
}

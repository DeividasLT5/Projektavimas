package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    PasswordChecker passwordChecker = new PasswordChecker();

    @Test
    void TestIsLongEnough(){
        assertTrue(passwordChecker.checkPassword("PasswordPassword5+"));
    }

    @Test
    void TestHasUppercase(){
        assertTrue(passwordChecker.checkPassword("Password5+"));
    }

    @Test
    void TestHasSpecialCharacter(){
        assertTrue(passwordChecker.checkPassword("Password5+"));
    }
}
package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    PasswordChecker passwordChecker = new PasswordChecker();

    @Test
    void TestPasswordIsCorrect(){
        assertTrue(passwordChecker.checkPassword("PasswordPassword5+", "+-*.><?/", 8));
    }

    @Test
    void TestPasswordIsNotEmpty(){
        assertFalse(passwordChecker.checkPassword(""));
    }

    @Test
    void TestPasswordIsNotNull(){
        assertFalse(passwordChecker.checkPassword(null));
    }

    @Test
    void TestPasswordIsLongEnough(){
        assertTrue(passwordChecker.checkPassword("passwordPassword", 8));
    }

    @Test
    void TestPasswordHasUppercase(){
        assertTrue(passwordChecker.checkPassword("Password"));
    }

    @Test
    void TestPasswordHasSpecialCharacter(){
        assertTrue(passwordChecker.checkPassword("password+", "+-*.><?/"));
    }
}
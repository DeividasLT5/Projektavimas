package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    EmailValidator emailValidator = new EmailValidator();

    @Test
    void TestHasAtSymbol(){
        assertTrue(emailValidator.validateEmail("Email@google.com"));
    }

    @Test
    void TestHasBannedSymbol(){
        assertTrue(emailValidator.validateEmail("Email@google.com©"));
    }

    @Test
    void TestHasCorrectDomain(){
        assertTrue(emailValidator.validateEmail("Email@google.com"));
    }

    @Test
    void TestHasCorrectTLD(){
        assertTrue(emailValidator.validateEmail("Email@google.com"));
    }
}
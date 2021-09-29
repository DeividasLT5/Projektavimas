package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    EmailValidator emailValidator = new EmailValidator();

    @Test
    void TestEmailIsCorrect(){
        assertTrue(emailValidator.validateEmail("Email@google.com"));
    }

    @Test
    void TestEmailIsNotEmpty(){
        assertFalse(emailValidator.validateEmail(""));
    }

    @Test
    void TestEmailIsNotNull(){
        assertFalse(emailValidator.validateEmail(null));
    }

    @Test
    void TestEmailHasAtSymbol(){
        assertTrue(emailValidator.validateEmail("Email@"));
    }

    @Test
    void TestEmailHasBannedSymbol(){
        assertTrue(emailValidator.validateEmail("©mail@google.com"));
    }

    @Test
    void TestEmailHasCorrectDomain(){
        assertTrue(emailValidator.validateEmail("Email@google.com"));
    }

    @Test
    void TestEmailHasCorrectTLD(){
        assertTrue(emailValidator.validateEmail("Email@google.com"));
    }
}
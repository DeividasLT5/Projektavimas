package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidatorTest {

    PhoneValidator phoneValidator = new PhoneValidator();

    @Test
    void TestHasNoSymbols(){
        assertFalse(phoneValidator.validatePhone("8612x4567"));
    }

    @Test
    void TestStartsWith8(){
        assertTrue(phoneValidator.validatePhone("862518456"));
    }

    @Test
    void TestCountryCode(){
        assertTrue(phoneValidator.validatePhone("+15626624600"));
    }

}
package com.authenticationtest;

import com.authentication.services.interfaces.IValidation;
import com.authentication.services.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {

    @Test
    public void SimplePasswordTest() {
        IValidation iValidation = new Validation();
        boolean a = iValidation.isPasswordValid("Aaa@");
        Assertions.assertTrue(a);

    }

    @Test
    public void SimplePasswordTestMaxLength() {
        IValidation iValidation = new Validation();
        boolean a = iValidation.isPasswordValid("Aaa@aaa");
        Assertions.assertFalse(a);

    }

    @Test
    public void SimplePasswordTestContainSymbol() {
        IValidation iValidation = new Validation();
        boolean a = iValidation.isPasswordValid("Aaa@aa");
        Assertions.assertTrue(a);

    }

    @Test
    public void SimplePasswordTestWithoutContainSymbol() {
        IValidation iValidation = new Validation();
        boolean a = iValidation.isPasswordValid("Append");
        Assertions.assertFalse(a);

    }

    @Test
    public void MaxLengthTest() {
        IValidation iValidation = new Validation();
        boolean b = iValidation.isMaxLength("aaa@");
        Assertions.assertTrue(b);

    }

    @Test
    public void ContainsSymbolTest() {
        IValidation iValidation = new Validation();
        boolean c = iValidation.isContainsSymbols("aaa@");
        Assertions.assertTrue(c);

    }

    @Test
    public void ContainsSymbolFalseTest() {
        IValidation iValidation = new Validation();
        boolean c = iValidation.isContainsSymbols("aaa");
        Assertions.assertFalse(c);

    }

    @Test
    public void ContainsUppercaseTest() {
        IValidation iValidation = new Validation();
        boolean c = iValidation.isContainsUppercaseLetter("aAaa");
        Assertions.assertTrue(c);

    }

}

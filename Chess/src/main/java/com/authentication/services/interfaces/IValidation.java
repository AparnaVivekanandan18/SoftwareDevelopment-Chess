package com.authentication.services.interfaces;
import com.authentication.model.Users;

public interface IValidation {
    boolean isPasswordValid(String password);
    boolean isLoginFieldEmptyValidation(String userId, String password);
    boolean isPasswordAndConfirmPasswordNotSame(Users userObj);
    boolean isRegisterFieldEmptyValidation(Users userObj);
    boolean isMaxLength(String password);
    boolean isContainsUppercaseLetter(String password);
    boolean isContainsSymbols(String password);

}


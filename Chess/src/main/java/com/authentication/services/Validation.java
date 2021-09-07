package com.authentication.services;
import com.authentication.services.interfaces.IValidation;
import com.authentication.model.Users;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation implements IValidation
{
    private String inputEmail;
    private String inputUserId;
    private String inputUsername;
    private String inputPassword;
    private String inputConPassword;
    private int playerLevelValue;
    private String playerLevel;

    public Validation()
    {
        inputEmail = null;
        inputUserId = null;
        inputUsername = null;
        inputPassword = null;
        inputConPassword = null;
        playerLevel = null;
        playerLevelValue = 0;
    }

    @Override
    public boolean isPasswordValid(String password) {
        List<Boolean> conditionList = new ArrayList<>();

        conditionList.add(isMaxLength(password));
        conditionList.add(isContainsUppercaseLetter(password));
        conditionList.add(isContainsSymbols(password));

        for (Boolean isConditionSatisfied : conditionList) {
            if (!isConditionSatisfied) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isLoginFieldEmptyValidation(String userId, String password) {
        return "".equals(password) || "".equals(userId);
    }

    @Override
    public boolean isRegisterFieldEmptyValidation(Users userObj)
    {
        inputEmail = userObj.getEmail();
        inputUserId = userObj.getUserId();
        inputUsername = userObj.getUsername();
        inputPassword = userObj.getPassword();
        playerLevelValue = userObj.getPlayerLevel();
        playerLevel = Integer.toString(playerLevelValue);
        inputConPassword = userObj.getConPassword();

        return "".equals(inputEmail) || "".equals(inputUserId) || "".equals(inputUsername) || "".equals(inputPassword) || "".equals(inputConPassword) || "".equals(playerLevel);
    }

    @Override
    public boolean isPasswordAndConfirmPasswordNotSame(Users userObj) {
        inputPassword = userObj.getPassword();
        inputConPassword = userObj.getConPassword();

        return !inputPassword.equals(inputConPassword);
    }

    @Override
    public boolean isMaxLength(String password) {
        int MAX_LENGTH = 6;
        if (null == password) {
            return false;
        }
        return password.length() <= MAX_LENGTH;
    }

    @Override
    public boolean isContainsUppercaseLetter(String password) {

        char tempCharacter;
        for (int i = 0; i < password.length(); i++) {
            tempCharacter = password.charAt(i);
            if (Character.isUpperCase(tempCharacter)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isContainsSymbols(String password) {
        Pattern validSymbolPattern = Pattern.compile("[^A-Za-z0-9]");

        if (null == password || password.trim().isEmpty()) {
            return false;
        }
        Matcher m = validSymbolPattern.matcher(password);
        return m.find();
    }
}

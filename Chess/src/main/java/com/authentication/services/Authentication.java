package com.authentication.services;
import com.authentication.services.interfaces.IAuthentication;
import com.authentication.services.interfaces.IPasswordEncryption;
import com.authentication.services.interfaces.IValidation;
import com.authentication.model.IUsers;
import com.authentication.model.Users;
import com.authentication.persistence.AuthenticationPersistence;
import com.authentication.persistence.interfaces.IAuthenticationPersistence;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Authentication implements IAuthentication {
    String message = null;
    IPasswordEncryption iPasswordEncryption;
    IAuthenticationPersistence authenticatePersistenceObj;
    IUsers userObject;
    IValidation iValidation;

    public Authentication() {
        iPasswordEncryption = new PasswordEncryption();
        authenticatePersistenceObj = new AuthenticationPersistence();
        userObject = new Users();
        iValidation = new Validation();
    }

    private void passwordEncryption(IUsers userObj, String inputPassword) {
        String hashPass;
        hashPass = iPasswordEncryption.encryptPassword(inputPassword);
        userObj.setPassword(hashPass);
    }

    private String validateCredentials(String inputUserId, String inputPassword, IUsers fetchedUser) throws SQLException {
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String loginTime = timeFormat.format(currentDate);
        Boolean isUserExist = (null != fetchedUser.getUserId());

        if (isUserExist) {
            Boolean isCredentialsCorrect = inputUserId.equals(fetchedUser.getUserId()) && userObject.getPassword().equals(fetchedUser.getPassword());
            if (isCredentialsCorrect) {
                String messageUpdate = authenticatePersistenceObj.updateUser(inputUserId, inputPassword, loginTime);
                return messageUpdate;
            }
        }
        return "Invalid Credentials OR User not Found";
    }

    public String userAuthentication(String inputUserId, String inputPassword) throws SQLException {
        if (iValidation.isLoginFieldEmptyValidation(inputUserId, inputPassword)) {
            return "Enter User Id or Password !";
        } else {
            passwordEncryption(userObject, inputPassword);
            IUsers fetchedUser = authenticatePersistenceObj.loadUser(inputUserId);
            message = validateCredentials(inputUserId, inputPassword, fetchedUser);
        }
        return message;
    }

    public String userLogOut(String userId) throws SQLException {
        String currentActiveUser = userId;
        message = authenticatePersistenceObj.logOut(currentActiveUser);
        return message;
    }

    public void setAuthenticatePersistenceObj(IAuthenticationPersistence authenticatePersistenceObj) {
        this.authenticatePersistenceObj = authenticatePersistenceObj;
    }

    @Override
    public List<Users> getAllUsers() throws SQLException {
        List<Users> allUsers;
        allUsers = authenticatePersistenceObj.getAllUsers();
        return allUsers;
    }
}

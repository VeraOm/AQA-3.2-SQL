package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.User;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationCodePage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginTest {

    private Connection connection;

    public LoginTest() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://192.168.99.101:3306/vera", "vera", "pass");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Test
    void successEnterTest() throws SQLException {
        LoginPage loginPage = new LoginPage();
        User user = DataHelper.getValidUserFirst(connection);
        VerificationCodePage pageVerification = loginPage.validLogin(user);
        String verificationCode = DataHelper.getLastVerificationCode(connection, user);
        pageVerification.validVerify(verificationCode);
    }

    @Test
    void passwordErrorTest() throws SQLException {
        LoginPage loginPage = new LoginPage();
        User wrongUser = DataHelper.getInvalidPasswordUser(connection);
        loginPage.invalidUser(wrongUser);
    }

    @Test
    void invalidVerificationCodeTest() throws SQLException {
        LoginPage loginPage = new LoginPage();
        User user = DataHelper.getValidUserFirst(connection);
        VerificationCodePage pageVerification = loginPage.validLogin(user);
        String verificationCode = DataHelper.getInvalidVerificationCode();
        pageVerification.invalidVerify(verificationCode);
    }

    @Test
    void fourthEnterBlockTest() throws SQLException {
        LoginPage loginPage;
        User user = DataHelper.getValidUserSecond(connection);
        String verificationCode;
        VerificationCodePage pageVerification;

        for (int i = 0; i < 3; i++) {
            loginPage = new LoginPage();
            pageVerification = loginPage.validLogin(user);
            verificationCode = DataHelper.getLastVerificationCode(connection, user);
            pageVerification.validVerify(verificationCode);
        }

        loginPage = new LoginPage();
        pageVerification = loginPage.validLogin(user);
        verificationCode = DataHelper.getLastVerificationCode(connection, user);
        pageVerification.isBlockedUser(verificationCode);
    }


}

package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.User;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorPanel = $("[data-test-id='error-notification']");

    public LoginPage() {
        open("http://localhost:9999");
    }

    public void clearInput() {
        loginField.sendKeys(Keys.LEFT_CONTROL + "a" + Keys.BACK_SPACE);
        passwordField.sendKeys(Keys.LEFT_CONTROL + "a" + Keys.BACK_SPACE);
    }

    public VerificationCodePage validLogin(User user) {
        clearInput();
        loginField.setValue(user.getLogin());
        passwordField.setValue(user.getPassword());
        loginButton.click();
        return new VerificationCodePage();
    }

    public void invalidUser(User user) {
        clearInput();
        loginField.setValue(user.getLogin());
        passwordField.setValue(user.getPassword());
        loginButton.click();
        loginButton.shouldBe(visible);
        errorPanel.shouldBe(visible).shouldHave(text("Ошибка")).shouldHave(text("Неверно указан логин или пароль"));
    }

}

package com.vois.autotask.pages;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class LogInPage {

    @NonNull
    private final WebDriver driver;
    private final By signInButton = By.id("action-oc5b26");
    private final By emailTextBox = By.name("loginfmt");
    private final By passwordTextBox = By.name("passwd");
    private final By nextButton = By.id("idSIButton9");

    public void clickSignIn() {
        driver.findElement(signInButton).click();
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }

    public void typeEmailAddress(String email) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(emailTextBox).sendKeys(email);
        driver.findElement(nextButton).click();
    }

    public InboxPage typePassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(nextButton).click();
        driver.findElement(nextButton).click();
        return new InboxPage(driver);
    }
}

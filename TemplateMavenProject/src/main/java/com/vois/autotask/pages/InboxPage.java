package com.vois.autotask.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class InboxPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By newMailButton = By.xpath("//button[@data-unique-id=\"Ribbon-588\"]");
    private final By recipientEmailTextBox = By.xpath("(//span[@class=\"fui-Input__contentAfter r1572tok _JkoO\"]//div//div)[1]");
    private final By subjectTextBox = By.cssSelector(".ZMK7F input");
    private final By bodyTextBox = By.cssSelector("#editorParent_1>div ");
    private final By attachFileButton = By.xpath("//input[@type=\"file\"][2]");
    private final By file    = By.cssSelector(".uDIro");
    private final By sendMailButton = By.id("splitButton-rr__primaryActionButton");
    private final By emptyDiv = By.cssSelector(".g_zET");

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void clickNewMail() {
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.stalenessOf(driver.findElement(newMailButton))));
        driver.findElement(newMailButton).click();

    }

    public void typeRecipientMail(String email) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(recipientEmailTextBox))));
        driver.findElement(recipientEmailTextBox).sendKeys(email);
    }

    public void typeSubject(String subject) {
        driver.findElement(subjectTextBox).sendKeys(subject);
    }

    public void typeBody(String body) {
        driver.findElement(bodyTextBox).sendKeys(body);
    }

    public void attachFile(String filePath) {
        driver.findElement(attachFileButton).sendKeys(filePath);
        wait.until(ExpectedConditions.elementToBeClickable(file));
    }

    public void clickSendButton() {
        driver.findElement(sendMailButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyDiv));
    }
}

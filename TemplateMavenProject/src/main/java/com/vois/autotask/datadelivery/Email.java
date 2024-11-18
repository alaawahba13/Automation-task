package com.vois.autotask.datadelivery;

import com.vois.autotask.pages.InboxPage;
import com.vois.autotask.pages.LogInPage;
import lombok.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String subject, body, recipientMail,attachmentFilePath;
    private static WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://outlook.live.com/");
    }

    private String[] getCredentials() {
        String[] credentials = new String[2];
        final Properties props = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("app.properties");){;
            props.load(input);
            credentials[0] = props.getProperty("email");
            credentials[1] = props.getProperty("password");
        } catch (IOException e) {
            System.out.println("Error getting credentials "+ e.getMessage());
        }
        return credentials;
    }

    private InboxPage logIn() {
        String[] credentials = getCredentials();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.clickSignIn();
        logInPage.typeEmailAddress(credentials[0]);
        return logInPage.typePassword(credentials[1]);
    }

    public void sendNewEmail() {
        InboxPage inboxPage = logIn();
        inboxPage.clickNewMail();
        inboxPage.typeRecipientMail(this.recipientMail);
        inboxPage.typeSubject(this.subject);
        inboxPage.typeBody(this.body);
        inboxPage.attachFile(this.attachmentFilePath);
        inboxPage.clickSendButton();
    }

    public void tearDown() {
        driver.quit();
    }
}

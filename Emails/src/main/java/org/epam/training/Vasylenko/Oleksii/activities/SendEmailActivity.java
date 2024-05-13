package org.epam.training.Vasylenko.Oleksii.activities;

import org.epam.training.Vasylenko.Oleksii.browser.BrowserFactory;
import org.epam.training.Vasylenko.Oleksii.model.Email;
import org.epam.training.Vasylenko.Oleksii.model.User;
import org.epam.training.Vasylenko.Oleksii.page.gmail.StartPageGmail;
import org.epam.training.Vasylenko.Oleksii.page.iua.StartPageIua;
import org.epam.training.Vasylenko.Oleksii.service.EmailFactory;
import org.epam.training.Vasylenko.Oleksii.service.UserFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
public class SendEmailActivity {
    private User sender = UserFactory.getSender();
    private User receiver = UserFactory.getReceiver();
    private Email emailToSend = EmailFactory.getTestMessage();

    //for manual start
    @BeforeTest
    public void before() {
        System.setProperty("browser", "chrome");
    }

    @Test
    public void test1() {
        String result = new StartPageIua(BrowserFactory.INSTANCE.getDriver())
                .login(sender)
                .createNewLetter()
                .sendMessage(emailToSend)
                .getResult();
        //assertEquals(result, "Лист успішно відправлено адресатам");

        boolean textExist = new StartPageGmail(BrowserFactory.INSTANCE.getDriver())
                .setLogin(receiver.getEmail())
                .setPassword(receiver.getPassword())
                .checkMail(sender.getEmail())
                .verifyMailText(emailToSend.getBody());
        assertTrue(textExist);
    }
}

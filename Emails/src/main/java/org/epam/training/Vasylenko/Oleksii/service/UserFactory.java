package org.epam.training.Vasylenko.Oleksii.service;

import com.github.javafaker.Faker;
import org.epam.training.Vasylenko.Oleksii.model.User;
import org.epam.training.Vasylenko.Oleksii.util.PropertiesUtil;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
public class UserFactory {
    private static final String senderEmail = "sender.username";
    private static final String senderPassword = "sender.password";
    private static final String receiverEmail = "receiver.username";
    private static final String receiverPassword = "receiver.password";

    public static User getSender() {
        return User.builder()
                .email(PropertiesUtil.get(senderEmail))
                .password(PropertiesUtil.get(senderPassword))
                .build();
    }

    public static User getReceiver() {
        return User.builder()
                .email(PropertiesUtil.get(receiverEmail))
                .password(PropertiesUtil.get(receiverPassword))
                .build();
    }

    public static User getRandom() {
        Faker fake = new Faker();
        return User.builder()
                .email(fake.internet().emailAddress())
                .password(fake.internet().password(8, 15, true, false, true))
                .build();
    }
}

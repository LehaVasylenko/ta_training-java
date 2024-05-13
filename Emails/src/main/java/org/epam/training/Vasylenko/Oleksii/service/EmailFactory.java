package org.epam.training.Vasylenko.Oleksii.service;

import org.epam.training.Vasylenko.Oleksii.model.Email;
import org.epam.training.Vasylenko.Oleksii.util.PropertiesUtil;
import org.epam.training.Vasylenko.Oleksii.util.SourceLoader;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
public class EmailFactory {
    private static final String receiverAddress = "receiver.username";

    public static Email getTestMessage() {
        return Email.builder()
                .receiver(PropertiesUtil.get(receiverAddress))
                .subject("Test message")
                .body(SourceLoader.INSTANCE.getTextSource())
                .build();
    }

}

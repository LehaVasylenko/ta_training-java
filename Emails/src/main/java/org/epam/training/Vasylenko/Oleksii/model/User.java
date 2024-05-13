package org.epam.training.Vasylenko.Oleksii.model;

import lombok.Builder;
import lombok.Data;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
@Data
@Builder
public class User {
    private String email;
    private String password;
}

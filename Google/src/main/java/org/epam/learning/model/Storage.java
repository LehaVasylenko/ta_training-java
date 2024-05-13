package org.epam.learning.model;

import lombok.Builder;
import lombok.Data;

/**
 * Google
 * Author: Vasylenko Oleksii
 * Date: 09.05.2024
 */
@Data
@Builder
public class Storage {
    private final String numberOfInstances;
    private final String series;
}

package org.epam.learning.service;

import lombok.Getter;
import org.epam.learning.model.Storage;
import org.epam.learning.util.PropertiesUtil;

/**
 * Google
 * Author: Vasylenko Oleksii
 * Date: 09.05.2024
 */
public enum StorageFiller {
    INSTANCE;
    @Getter
    private Storage data;
    private final String numberOfInstances = "calculator.instances";
    private final String series = "calculator.series";

    StorageFiller() {
        data = Storage.builder()
                .numberOfInstances(PropertiesUtil.get(numberOfInstances))
                .series(PropertiesUtil.get(series))
                .build();
    }

}

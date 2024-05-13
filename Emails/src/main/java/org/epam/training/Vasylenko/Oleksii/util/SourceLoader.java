package org.epam.training.Vasylenko.Oleksii.util;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */

public enum SourceLoader {
    INSTANCE;

    private final String pathSource = "source.text";

    @Getter
    private final String textSource;

    SourceLoader(){
        textSource = loadTextSource();
    }

    private String loadTextSource() {
        try{
            Path path = Paths.get(PropertiesUtil.get(this.pathSource));
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes);

        } catch (IOException e) {
            System.err.println("FAILED TO LOAD EMAIL TEXT!!!");
            throw new RuntimeException(e);
        }
    }
}

package com.geekbrains;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BaseTest {

    public String getResourceAsString(String name) throws IOException {
        return new String(
                getClass().getResourceAsStream(name)
                        .readAllBytes(),
                StandardCharsets.UTF_8
        );
    }

}
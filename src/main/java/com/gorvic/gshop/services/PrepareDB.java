package com.gorvic.gshop.services;

import org.springframework.boot.web.servlet.server.Session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrepareDB {
    public void createDB(){
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("products.sql")).collect(Collectors.joining(" "));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.hello;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Singleton
public class SimpleService {

    @Inject
    private Connection connection;
    private static Logger logger = LoggerFactory.getLogger(SimpleService.class);

    public String sayHello(String to) throws SQLException {
        logger.info("buscando usuario: " + to);
        String name;
        try (Statement stmt = connection.createStatement();) {
            ResultSet rs;
            rs = stmt.executeQuery("SELECT u.full_name FROM vdi.users u WHERE u.email = '" + to + "'");
            if (rs.next()) {
                name = rs.getString("full_name");
            } else {
                name = "not found";
            }
        }
        return "hey " + name;
    }
}

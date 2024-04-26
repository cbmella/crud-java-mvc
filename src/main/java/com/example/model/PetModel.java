package com.example.model;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;
import java.io.InputStream;

public class PetModel {
    private String url;
    private String username;
    private String password;

    public PetModel() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            // Load a properties file from class path
            prop.load(input);

            // Get the property values
            url = prop.getProperty("db.url");
            username = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Vector<Vector<Object>> getAllPets() {
        Vector<Vector<Object>> pets = new Vector<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM pets")) {

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getString("name"));
                row.add(resultSet.getString("location"));
                row.add(resultSet.getString("photo_url"));
                pets.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
}

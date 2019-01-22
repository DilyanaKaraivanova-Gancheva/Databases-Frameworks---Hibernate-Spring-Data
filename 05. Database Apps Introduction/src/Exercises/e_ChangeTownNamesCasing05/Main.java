package Exercises.e_ChangeTownNamesCasing05;

import connectors.Connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("Enter password:");
        String password = bf.readLine();

        Connector.initConnection("mysql","root",password,"localhost","3306","MinionsDB");

        try(Connection conn = Connector.getConnection()) {

            String country = bf.readLine();

            PreparedStatement stmt = conn.prepareStatement("UPDATE `towns` \n" +
                    "SET name = upper(name)\n" +
                    "WHERE country LIKE (?)");

            stmt.setString(1, country);
            int updated = stmt.executeUpdate();

            if (updated == 0) {
                System.out.println("No town names were affected.");
            } else {
                System.out.printf("%d town names were affected.%n", updated);
                stmt = conn.prepareStatement("SELECT name FROM towns WHERE country = ?");
                stmt.setString(1, country);
                ResultSet rs = stmt.executeQuery();
                List<String> towns = new ArrayList<>();

                while (rs.next()) {
                    towns.add(rs.getString("name"));
                }
                System.out.println(towns);
            }
        }
    }
}

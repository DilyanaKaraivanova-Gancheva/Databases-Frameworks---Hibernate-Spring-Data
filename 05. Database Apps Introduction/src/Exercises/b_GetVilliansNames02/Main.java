package Exercises.b_GetVilliansNames02;

import connectors.Connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("Enter password:");
        String password = bf.readLine();

        Connector.initConnection("mysql", "root", password, "localhost", "3306", "MinionsDB");
        try( Connection conn = Connector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT v.name AS `name`, count(mv.minion_id) AS `count` FROM villians AS v \n" +
                    "JOIN minions_villians AS mv ON v.id = mv.villian_id\n" +
                    "GROUP BY v.name\n" +
                    "ORDER BY `count` DESC;");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.printf("%s %s%n", rs.getString("name"), rs.getString("count"));
            }
        }
    }
}

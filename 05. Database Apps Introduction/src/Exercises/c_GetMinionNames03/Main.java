package Exercises.c_GetMinionNames03;

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

        Connector.initConnection("mysql","root",password,"localhost","3306","MinionsDB");
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT \n" +
                    "    v.name AS `villian_name`,\n" +
                    "    m.name AS `minion_name`,\n" +
                    "    m.age AS `minion_age`\n" +
                    "FROM\n" +
                    "    minions_villians AS mv\n" +
                    "        JOIN\n" +
                    "    minions AS m ON mv.minion_id = m.id\n" +
                    "       RIGHT JOIN\n" +
                    "    villians AS v ON mv.villian_id = v.id\n" +
                    "WHERE\n" +
                    "    v.id = ?");

            String villianId = bf.readLine();
            stmt.setInt(1, Integer.parseInt(villianId));

            ResultSet rs = stmt.executeQuery();

            int cnt = 0;
            if (!rs.next()) {
                System.out.printf("No villain with ID %s exists in the database.", villianId);
            }
            rs.beforeFirst();
            while (rs.next()) {
                if (cnt == 0) {
                    System.out.printf("Villain: %s%n", rs.getString("villian_name"));
                }

                if (rs.getString("minion_name") == null) {
                    System.out.println("<no minions>");
                } else {
                    System.out.printf("%d. %s %s%n", ++cnt, rs.getString("minion_name"), rs.getString("minion_age"));
                }
            }
        }
    }
}

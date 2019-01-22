package Exercises.h_IncreaseMinionsAge08;

import connectors.Connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("Enter password:");
        String password = bf.readLine();

        int[] minionsIds = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Connector.initConnection("mysql", "root", password, "localhost", "3306", "MinionsDB");
        try (Connection conn = Connector.getConnection()) {
            for (int currentId : minionsIds) {
                updateAge(conn, currentId);

                PreparedStatement stmt = conn.prepareStatement("SELECT name FROM minions WHERE id = ?");
                stmt.setInt(1, currentId);
                ResultSet rs = stmt.executeQuery();
                if (rs.isBeforeFirst()) {
                    rs.next();
                    String name = rs.getString("name");
                    nameCase(conn, currentId, name);
                }
            }
            printAllMinions(conn);

        }
    }

    private static void printAllMinions(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT name,age FROM minions");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            System.out.printf("%s %s%n",rs.getString("name"), rs.getString("age"));
        }
    }

    private static void updateAge(Connection conn, int currentId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE minions SET age = age+1 WHERE id = ?");
        stmt.setInt(1,currentId);
        stmt.executeUpdate();
    }

    private static void nameCase(Connection conn, int currentId, String name) throws SQLException {
        String[] nameSplit = name.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < nameSplit.length; j++) {
            sb.append(nameSplit[j].substring(0, 1).toUpperCase()).append(nameSplit[j].substring(1)).append(" ");
        }
        String nameCase = sb.toString().trim();
        PreparedStatement stmt = conn.prepareStatement("UPDATE minions SET name = ? WHERE id = ?");
        stmt.setString(1,nameCase);
        stmt.setInt(2,currentId);
        stmt.executeUpdate();
    }
}


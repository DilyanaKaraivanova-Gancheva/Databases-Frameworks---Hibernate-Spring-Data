package Exercises.i_IncreaseAgeStoredProcedure09;

import connectors.Connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("Enter password:");
        String password = bf.readLine();

        int minionId = Integer.parseInt(bf.readLine());

        Connector.initConnection("mysql", "root", password, "localhost", "3306", "MinionsDB");
        try (Connection conn = Connector.getConnection()) {
            updateAge(conn,minionId);
            printMinion(conn,minionId);
        }
    }

    private static void printMinion(Connection conn,int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT name,age FROM minions WHERE id = ?");
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            System.out.printf("%s %s%n",rs.getString("name"), rs.getString("age"));
        }
    }

    private static void updateAge(Connection conn, int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("CALL usp_get_older(?)");
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
}


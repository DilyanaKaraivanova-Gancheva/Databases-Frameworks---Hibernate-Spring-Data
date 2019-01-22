package Exercises.g_PrintAllMinionNames07;

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

        Connector.initConnection("mysql","root",password,"localhost","3306","MinionsDB");
        try(Connection conn = Connector.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM minions");
            PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM minions");

            ResultSet rs = stmt.executeQuery();
            ResultSet rsReversed = stmt1.executeQuery();

            rsReversed.last();

            int size = rsReversed.getRow();
            for (int i = 0; i < size / 2; i++) {
                rs.next();
                System.out.println(rs.getString("name"));
                System.out.println(rsReversed.getString("name"));
                rsReversed.previous();
            }
            if (size % 2 == 1) {
                rs.next();
                System.out.println(rs.getString("name"));
            }
        }
    }
}

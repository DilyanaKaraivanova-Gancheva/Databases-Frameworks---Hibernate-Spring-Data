package Exercises.d_AddMinion04;

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
        Connection conn = Connector.getConnection();
        try{
            conn.setAutoCommit(false);
            String[] minion = bf.readLine().split("\\s+");
            String[] villian = bf.readLine().split("\\s+");

            String minionName = minion[1];
            int minionAge = Integer.parseInt(minion[2]);
            String townName = minion[3];

            PreparedStatement stmt = conn.prepareStatement("SELECT \n" +
                    "    *\n" +
                    "FROM\n" +
                    "   towns AS t\n" +
                    "WHERE\n" +
                    "    t.name = ?");

            stmt.setString(1, townName);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                stmt = conn.prepareStatement("INSERT INTO towns(`name`) VALUES(?);\n");
                stmt.setString(1, townName);
                stmt.executeUpdate();

                stmt = conn.prepareStatement("INSERT INTO minions(`name`,`age`,`town_id`) " +
                        "VALUES(?,?,(SELECT t.town_id FROM towns AS t WHERE t.name = ?))");
                stmt.setString(1, minionName);
                stmt.setInt(2, minionAge);
                stmt.setString(3, townName);
                stmt.executeUpdate();
                conn.commit();
                System.out.printf("Town %s was added to the database.%n", townName);
            }

            stmt = conn.prepareStatement("SELECT * FROM villians AS v\n" +
                    "WHERE v.name = ?");
            String villianName = villian[1];
            stmt.setString(1, villianName);
            rs = stmt.executeQuery();

            if (!rs.next()) {
                stmt = conn.prepareStatement("INSERT INTO villians(`name`,`evilness_factor`) " +
                        "VALUES(?,\"evil\")");
                stmt.setString(1, villianName);
                stmt.executeUpdate();
                conn.commit();
                System.out.printf("Villain %s was added to the database.%n", villianName);
            }

            stmt = conn.prepareStatement("INSERT INTO minions_villians \n" +
                    "VALUES((SELECT v.id FROM villians AS v WHERE v.name = ?),(SELECT m.id FROM minions AS m WHERE m.name = ?))");
            stmt.setString(1, villianName);
            stmt.setString(2, minionName);
            stmt.executeUpdate();
            conn.commit();
            System.out.printf("Successfully added %s to be minion of %s", minionName, villianName);
        }catch (SQLException se){
            conn.rollback();
        }

    }
}

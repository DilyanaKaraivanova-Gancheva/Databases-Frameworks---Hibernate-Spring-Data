package Exercises.f_RemoveVillian06;

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
        Connection conn = Connector.getConnection();
        try{
            conn.setAutoCommit(false);
            int villianId = Integer.parseInt(bf.readLine());

            //check if villian exists
            PreparedStatement stmt =  conn.prepareStatement("SELECT * FROM villians AS v WHERE v.id = ?");
            stmt.setInt(1,villianId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                //release minions
                stmt =  conn.prepareStatement("DELETE FROM minions_villians WHERE villian_id = ?");
                stmt.setInt(1,villianId);
                int released = stmt.executeUpdate();
                conn.commit();

                //get villian's name
                stmt =  conn.prepareStatement("SELECT * FROM villians WHERE id = ?");
                stmt.setInt(1,villianId);
                rs = stmt.executeQuery();
                rs.next();
                String villianName = rs.getString("name");

                //delete villian
                stmt =  conn.prepareStatement("DELETE FROM villians WHERE id = ?");
                stmt.setInt(1,villianId);
                stmt.executeUpdate();
                conn.commit();

                System.out.printf("%s was deleted%n", villianName);
                System.out.printf("%d minions released%n", released);
            }else {
                System.out.println("No such villain was found");
            }


        }catch (SQLException se){
            conn.rollback();
        }
    }
}

package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement stmt = conn.prepareStatement("SELECT concat_ws(\" \",u.first_name, u.last_name) AS `full_name`, count(ug.game_id) AS `games` \n" +
                "FROM users AS u\n" +
                "JOIN users_games AS ug ON" +
                "1 ug.user_id = u.id\n" +
                "WHERE u.user_name = ?");

        String username = bf.readLine();

        stmt.setString(1,username);

        ResultSet rs = stmt.executeQuery();
        rs.next();
        if (!rs.getString("full_name").equalsIgnoreCase("")){
            System.out.printf("User: %s%n", username);
            System.out.printf("%s has played %s games%n", rs.getString("full_name"),rs.getString("games"));
        }
        else {
            System.out.println("No such user exists");
        }
    }
}

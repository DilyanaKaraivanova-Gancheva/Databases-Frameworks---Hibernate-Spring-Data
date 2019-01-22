package Exercises.k_OnlineRadioDatabase11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Song> radioDatabase = new ArrayList<>();

        int count = Integer.parseInt(bf.readLine());

        for (int i = 0; i < count; i++) {
            String[] line = bf.readLine().split(";");
            String[] songLength = line[2].split(":");
            try{
                Song song = new Song(line[0],line[1],Integer.parseInt(songLength[0]),Integer.parseInt(songLength[1]));
                radioDatabase.add(song);
                System.out.println("Song added.");
            }catch (NumberFormatException e) {
                System.out.println("Invalid song length.");
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

       int totalSeconds = radioDatabase.stream().mapToInt(s -> s.getMinutes() * 60 + s.getSeconds()).sum();
        int hours = totalSeconds/3600;
        int minutes = (totalSeconds - hours * 3600)/60;
        int seconds = (totalSeconds - hours * 3600)%60;

        System.out.printf("Songs added: %d%n", radioDatabase.size());
        System.out.printf("Playlist length: %dh %dm %ds", hours,minutes,seconds);


    }
}

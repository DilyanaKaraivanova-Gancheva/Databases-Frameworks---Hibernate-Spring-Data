package com.user.system.usersystem;

import com.user.system.usersystem.models.entities.User;
import com.user.system.usersystem.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private TownService townService;
    private PictureService pictureService;
    private CountryService countryService;
    private AlbumService albumService;

    @Autowired
    public ConsoleRunner(UserService userService,
                         TownService townService,
                         PictureService pictureService,
                         CountryService countryService,
                         AlbumService albumService) {
        this.userService = userService;
        this.townService = townService;
        this.pictureService = pictureService;
        this.countryService = countryService;
        this.albumService = albumService;
    }

    @Override
    public void run(String... args) throws Exception {

        //findAllByEmileProvider();
        //removeInactiveUsers();

    }

    private void removeInactiveUsers() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(reader.readLine());

        List<User> userList = this.userService.usersLastTimeLoggedInAfter(date);
        this.userService.removeAllUnActiveUsersAfterDate(date);

        if (userList.size() > 0) {
            System.out.println(userList.size() + "users has been deleted");
        } else {
            System.out.println("No users has been deleted");
        }
    }

    private void findAllByEmileProvider() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String provider = reader.readLine();

        this.userService.findAllUsersByEmailProvider(provider).forEach(u -> {
            System.out.println(u.getUsername() + " " + u.getEmail());
        });
    }
}

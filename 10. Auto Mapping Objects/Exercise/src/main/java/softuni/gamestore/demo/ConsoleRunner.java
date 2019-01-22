package softuni.gamestore.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import softuni.gamestore.demo.dtos.GameDetailsView;
import softuni.gamestore.demo.dtos.GameOwnedView;
import softuni.gamestore.demo.dtos.GameTitlePriceView;
import softuni.gamestore.demo.models.entities.Game;
import softuni.gamestore.demo.models.entities.Order;
import softuni.gamestore.demo.models.entities.User;
import softuni.gamestore.demo.services.GameService;
import softuni.gamestore.demo.services.OrderService;
import softuni.gamestore.demo.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;
    private final OrderService orderService;
    private BufferedReader reader;
    private User currentlyLoggedUser;
    private Map<String, Game> shoppingCart;

    @Autowired
    public ConsoleRunner(UserService userService, GameService gameService, OrderService orderService) {
        this.userService = userService;
        this.gameService = gameService;
        this.orderService = orderService;
        this.shoppingCart = new HashMap<>();
        this.currentlyLoggedUser = null;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        String input;
        while (!"end".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\|");
            switch (tokens[0]) {
                case "RegisterUser":
                    this.tryRegisterUser(tokens);
                    break;
                case "LoginUser":
                    this.tryLoginUser(tokens);
                    break;
                case "LogoutUser":
                    this.tryLogoutUser(tokens);
                    break;
                case "AddGame":
                    this.tryAddGame(tokens);
                    break;
                case "EditGame":
                    this.tryEditGame(tokens);
                    break;
                case "DeleteGame":
                    this.tryDeleteGame(tokens);
                    break;
                case "AllGame":
                    this.printAllGames();
                    break;
                case "DetailGame":
                    this.printGameDetails(tokens);
                    break;
                case "OwnedGame":
                    this.printOwnedGames();
                    break;
                case "AddItem":
                    this.tryAddItem(tokens);
                    break;
                case "RemoveItem":
                    this.tryRemoveItem(tokens);
                    break;
                case "BuyItem":
                    this.finalizeOrder();
                    break;
            }
        }
    }

    private void printOwnedGames() {
        if (this.currentlyLoggedUser == null){
            System.out.println("No user is currently logged in!");
            return;
        }
        List<GameOwnedView> games = this.userService.findOwnedGames(this.currentlyLoggedUser.getEmail());
        for (GameOwnedView game : games) {
            System.out.println(game);
        }
    }

    private void printGameDetails(String[] tokens) {
        if (this.currentlyLoggedUser == null){
            System.out.println("No user is currently logged in!");
            return;
        }
        GameDetailsView game = this.gameService.findGameDetails(tokens[1]);
        System.out.println(game);
    }

    private void printAllGames() {
        if (this.currentlyLoggedUser == null){
            System.out.println("No user is currently logged in!");
            return;
        }
        List<GameTitlePriceView> allGames = this.gameService.findAll();
        for (GameTitlePriceView game : allGames) {
            System.out.println(game);
        }
    }

    private void finalizeOrder() {
        if (this.currentlyLoggedUser == null) {
            System.out.println("You should log in first.");
            return;
        }
        if (this.shoppingCart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        Order order = new Order();
        order.setBuyer(this.currentlyLoggedUser);
        System.out.println("Successfully bought games:");
        for (Game game : this.shoppingCart.values()) {
            order.getGames().add(game);
            this.currentlyLoggedUser.getGames().add(game);
            System.out.println(" -" + game.getTitle());
        }
        this.orderService.add(order);
        this.currentlyLoggedUser.getOrders().add(order);
        this.userService.update(this.currentlyLoggedUser);
    }

    private void tryRemoveItem(String[] tokens) {
        Game game = this.gameService.findByTitle(tokens[1]);
        if (game == null) {
            System.out.println("Game does not exist!");
            return;
        }
        if (this.currentlyLoggedUser == null){
            System.out.println("No user is currently logged in!");
            return;
        }
        if (!this.shoppingCart.containsKey(game.getTitle())) {
            System.out.println("The game is not present in your shopping cart.");
            return;
        }
        this.shoppingCart.remove(game.getTitle());
        System.out.println(game.getTitle() + " removed from cart.");
    }

    private void tryAddItem(String[] tokens) {
        Game game = this.gameService.findByTitle(tokens[1]);
        if (game == null) {
            System.out.println("Game does not exist!");
            return;
        }
        if (this.currentlyLoggedUser == null){
            System.out.println("No user is currently logged in!");
            return;
        }
        if (this.shoppingCart.containsKey(game.getTitle())) {
            System.out.println("The game is already in your cart.");
            return;
        }
        if (userOwnsGame(game)) {
            System.out.println("You already own this game.");
            return;
        }
        this.shoppingCart.put(game.getTitle(), game);
        System.out.println(game.getTitle() + " added to cart.");
    }

    private boolean userOwnsGame(Game game) {
        for (Game game1 : this.currentlyLoggedUser.getGames()) {
            if (game.getTitle().equals(game1.getTitle())) {
                return true;
            }
        }
        return false;
    }

    private void tryDeleteGame(String[] tokens) {
        if (this.currentlyLoggedUser == null) {
            System.out.println("No user is currently logged in!");
            return;
        }
        if (!currentlyLoggedUser.isAdministrator()) {
            System.out.println("You are not authorized to do that!");
            return;
        }
        Long id = Long.parseLong(tokens[1]);
        Game game = this.gameService.findById(id);
        if (game == null) {
            System.out.println("Game does not exist!");
            return;
        }
        this.gameService.remove(game);
        System.out.println("Deleted " + game.getTitle());
    }

    private void tryEditGame(String[] tokens) {
        if (this.currentlyLoggedUser == null) {
            System.out.println("No user is currently logged in!");
            return;
        }
        if (!this.currentlyLoggedUser.isAdministrator()) {
            System.out.println("You are not authorized to do that!");
            return;
        }
        Long id = Long.parseLong(tokens[1]);
        Game game = this.gameService.findById(id);
        if (game == null) {
            System.out.println("Game does not exist!");
            return;
        }
        for (int i = 2; i < tokens.length; i++) {
            String[] values = tokens[i].split("=");
            switch (values[0]) {
                case "price":
                    game.setPrice(new BigDecimal(values[1]));
                    break;
                case "size":
                    game.setSize(Double.parseDouble(values[1]));
                    break;
                case "description":
                    game.setDescription(values[1]);
                    break;
                case "trailer":
                    game.setTrailer(values[1]);
                    break;
            }
        }
        this.gameService.update(game);
        System.out.println("Edited " + game.getTitle());
    }

    private void tryAddGame(String[] tokens) throws ParseException {
        if (this.currentlyLoggedUser == null) {
            System.out.println("No user is currently logged in!");
            return;
        }
        if (!this.currentlyLoggedUser.isAdministrator()) {
            System.out.println("You are not authorized to do that!");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Game game = new Game();
            game.setTitle(tokens[1]);
            game.setPrice(new BigDecimal(tokens[2]));
            game.setSize(Double.parseDouble(tokens[3]));
            game.setTrailer(tokens[4]);
            game.setImageThumbnail(tokens[5]);
            game.setDescription(tokens[6]);
            game.setReleaseDate(sdf.parse(tokens[7]));

            this.gameService.add(game);
            System.out.println("Added " + game.getTitle());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void tryLogoutUser(String[] tokens) {
        if (this.currentlyLoggedUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }
        System.out.println("User " + this.currentlyLoggedUser.getFullName() + " successfully logged out");
        this.currentlyLoggedUser = null;
    }

    private void tryLoginUser(String[] tokens) {
        User user = this.userService.findByEmail(tokens[1]);
        if (user == null) {
            System.out.println("User does not exist!");
            return;
        }
        if (this.currentlyLoggedUser != null) {
            if (this.currentlyLoggedUser.equals(user)) {
                System.out.println("User is already logged in!");
            }
            System.out.println("You are currently logged in with a different user! Logout first!");
            return;
        }
        if (!user.getPassword().equals(tokens[2])) {
            System.out.println("Incorrect username / password");
            return;
        }
        this.currentlyLoggedUser = user;
        System.out.println("Successfully logged in " + user.getFullName());
    }

    private void tryRegisterUser(String[] tokens) {
        try {
            User user = new User();
            user.setEmail(tokens[1]);
            user.setPassword(tokens[2]);
            user.setFullName(tokens[4]);
            String confirmPassword = tokens[3];
            if (isFirstRegisteredUser()) {
                user.setAdministrator(true);
            }

            this.userService.registerUser(user, confirmPassword);
            System.out.println(user.getFullName() + " was registered");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isFirstRegisteredUser() {
        return this.userService.getAllUsers().size() < 1;
    }
}

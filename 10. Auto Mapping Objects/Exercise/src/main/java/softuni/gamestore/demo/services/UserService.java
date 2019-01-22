package softuni.gamestore.demo.services;

import softuni.gamestore.demo.dtos.GameOwnedView;
import softuni.gamestore.demo.models.entities.User;

import java.util.List;

public interface UserService {
    void registerUser(User user, String confirmPassword);

    User findByEmail(String email);

    List<GameOwnedView> findOwnedGames(String email);

    List<User> getAllUsers();

    void update(User user);
}

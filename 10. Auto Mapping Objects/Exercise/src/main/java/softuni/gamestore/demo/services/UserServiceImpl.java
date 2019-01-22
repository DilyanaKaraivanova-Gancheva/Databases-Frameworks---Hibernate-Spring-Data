package softuni.gamestore.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.gamestore.demo.dtos.GameOwnedView;
import softuni.gamestore.demo.models.entities.Game;
import softuni.gamestore.demo.models.entities.User;
import softuni.gamestore.demo.repositories.UserRepository;
import javax.validation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public void registerUser(User user, String confirmPassword) {
        if (checkIfUserExists(user.getEmail())) {
            throw new IllegalArgumentException("Email is taken.");
        }
        if (!user.getPassword().equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match.");
        }

        if (user.getPassword().equals(confirmPassword)) {
            this.userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Violated constraints!");
        }
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public List<GameOwnedView> findOwnedGames(String email) {
        Set<Game> games = this.userRepository.findByEmail(email).getGames();
        List<GameOwnedView> gameViews = new ArrayList<>();
        for (Game game : games) {
            GameOwnedView gameView = mapper.map(game, GameOwnedView.class);
            gameViews.add(gameView);
        }
        return gameViews;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public void update(User user) {
        this.userRepository.save(user);
    }

    private boolean checkIfUserExists(String email) {
        User user = this.findByEmail(email);
        return user != null;
    }
}

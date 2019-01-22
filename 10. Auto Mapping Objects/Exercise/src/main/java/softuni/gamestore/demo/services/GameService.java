package softuni.gamestore.demo.services;

import softuni.gamestore.demo.dtos.GameDetailsView;
import softuni.gamestore.demo.dtos.GameTitlePriceView;
import softuni.gamestore.demo.models.entities.Game;

import java.util.List;

public interface GameService {
    Game findById(Long id);

    Game findByTitle(String title);

    List<GameTitlePriceView> findAll();

    GameDetailsView findGameDetails(String title);

    void add(Game game);

    void update(Game game);

    void remove(Game game);
}

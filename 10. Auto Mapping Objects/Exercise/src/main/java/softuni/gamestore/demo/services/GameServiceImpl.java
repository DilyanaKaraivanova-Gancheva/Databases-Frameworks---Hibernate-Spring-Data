package softuni.gamestore.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.gamestore.demo.dtos.GameDetailsView;
import softuni.gamestore.demo.dtos.GameTitlePriceView;
import softuni.gamestore.demo.models.entities.Game;
import softuni.gamestore.demo.repositories.GameRepository;

import javax.validation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class GameServiceImpl implements GameService{

    private final GameRepository gameRepository;
    private final ModelMapper mapper;
    private Validator validator;


    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.mapper = new ModelMapper();
        this.setValidator();
    }

    private void setValidator() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        this.validator = vf.getValidator();
    }

    @Override
    public Game findById(Long id) {
        return this.gameRepository.findById(id).orElse(null);
    }

    @Override
    public Game findByTitle(String title) {
        return this.gameRepository.findByTitle(title);
    }

    @Override
    public List<GameTitlePriceView> findAll() {
        List<Game> games =  this.gameRepository.findAll();
        List<GameTitlePriceView> gameViews = new ArrayList<>();
        for (Game game : games) {
            GameTitlePriceView gameView = mapper.map(game, GameTitlePriceView.class);
            gameViews.add(gameView);
        }
        return gameViews;
    }

    @Override
    public GameDetailsView findGameDetails(String title) {
        Game game = this.gameRepository.findByTitle(title);
        return mapper.map(game, GameDetailsView.class);
    }

    @Override
    public void add(Game game) {
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(game);
        if (constraintViolations.isEmpty()) {
            this.gameRepository.save(game);
        } else {
            throw new ConstraintViolationException("Violated constraints!", constraintViolations);
        }
        this.gameRepository.save(game);
    }

    @Override
    public void update(Game game) {
        this.add(game);
    }

    @Override
    public void remove(Game game) {
        this.gameRepository.delete(game);
    }
}

package softuni.gamestore.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.gamestore.demo.models.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game,Long>{
    Game findByTitle(String title);
}

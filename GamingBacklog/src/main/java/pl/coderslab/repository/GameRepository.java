package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByGbId(Long gbId);

}

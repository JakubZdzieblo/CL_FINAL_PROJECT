package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Game;
import pl.coderslab.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByGbId(Long gbId);
    List<Game> findAllByUsers(User user);

}

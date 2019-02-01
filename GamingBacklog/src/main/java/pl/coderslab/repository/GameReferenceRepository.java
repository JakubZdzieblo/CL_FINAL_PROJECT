package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.GameReference;

public interface GameReferenceRepository extends JpaRepository<GameReference, Long> {

    GameReference findByGbId(Long gbId);
}

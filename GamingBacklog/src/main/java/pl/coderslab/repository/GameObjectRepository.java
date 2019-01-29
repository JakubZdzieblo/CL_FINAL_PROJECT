package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.GameObject;

public interface GameObjectRepository extends JpaRepository<GameObject, Long> {
}

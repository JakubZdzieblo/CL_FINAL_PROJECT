package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

    Platform findByGbId(Long gbId);

}

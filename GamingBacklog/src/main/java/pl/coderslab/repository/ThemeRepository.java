package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}

package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}

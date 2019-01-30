package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Concept;

public interface ConceptRepository extends JpaRepository<Concept, Long> {

    Concept findByGbId(Long gbId);

}

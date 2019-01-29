package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Concept;
import pl.coderslab.repository.ConceptRepository;

public class ConceptConverter implements Converter<String, Concept> {

    @Autowired
    private ConceptRepository conceptRepository;

    @Override
    public Concept convert(String s) {
        return conceptRepository.findOne(Long.parseLong(s));
    }
}

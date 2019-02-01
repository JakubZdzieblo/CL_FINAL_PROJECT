package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.GameReference;
import pl.coderslab.repository.GameReferenceRepository;

public class GameReferenceConverter implements Converter<String, GameReference> {

    @Autowired
    GameReferenceRepository gameReferenceRepository;

    @Override
    public GameReference convert(String s) {
        return gameReferenceRepository.findOne(Long.parseLong(s));
    }
}

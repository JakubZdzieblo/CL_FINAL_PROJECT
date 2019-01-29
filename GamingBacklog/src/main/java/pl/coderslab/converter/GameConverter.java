package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Game;
import pl.coderslab.repository.GameRepository;

public class GameConverter implements Converter<String, Game> {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game convert(String s) {
        return gameRepository.findOne(Long.parseLong(s));
    }
}

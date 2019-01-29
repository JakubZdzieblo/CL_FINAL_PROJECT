package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.GameObject;
import pl.coderslab.repository.GameObjectRepository;

public class GameObjectConverter implements Converter<String, GameObject> {

    @Autowired
    private GameObjectRepository gameObjectRepository;

    @Override
    public GameObject convert(String s) {
        return gameObjectRepository.findOne(Long.parseLong(s));
    }
}

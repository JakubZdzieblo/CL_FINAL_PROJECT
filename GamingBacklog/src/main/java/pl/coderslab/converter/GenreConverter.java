package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Genre;
import pl.coderslab.repository.GenreRepository;

public class GenreConverter implements Converter<String, Genre> {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre convert(String s) {
        return genreRepository.findOne(Long.parseLong(s));
    }
}

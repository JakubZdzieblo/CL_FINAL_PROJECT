package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Theme;
import pl.coderslab.repository.ThemeRepository;

public class ThemeConverter implements Converter<String, Theme> {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public Theme convert(String s) {
        return themeRepository.findOne(Long.parseLong(s));
    }
}

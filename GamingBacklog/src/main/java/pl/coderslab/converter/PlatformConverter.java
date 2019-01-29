package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Platform;
import pl.coderslab.repository.PlatformRepository;

public class PlatformConverter implements Converter<String, Platform> {

    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public Platform convert(String s) {
        return platformRepository.findOne(Long.parseLong(s));
    }
}

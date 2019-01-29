package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Location;
import pl.coderslab.repository.LocationRepository;

public class LocationConverter implements Converter<String, Location> {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location convert(String s) {
        return locationRepository.findOne(Long.parseLong(s));
    }
}

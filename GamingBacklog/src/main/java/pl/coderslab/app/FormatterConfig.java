package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.converter.*;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class FormatterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(commentConverter());
        registry.addConverter(conceptConverter());
        registry.addConverter(gameConverter());
        registry.addConverter(gameObjectConverter());
        registry.addConverter(locationConverter());
        registry.addConverter(platformConverter());
        registry.addConverter(publisherConverter());
        registry.addConverter(themeConverter());
        registry.addConverter(userConverter());
        registry.addConverter(gameReferenceConverter());
    }

    @Bean
    public CommentConverter commentConverter(){
        return new CommentConverter();
    }

    @Bean
    public ConceptConverter conceptConverter(){
        return new ConceptConverter();
    }

    @Bean
    public GameConverter gameConverter(){
        return new GameConverter();
    }

    @Bean
    public GameObjectConverter gameObjectConverter(){
        return new GameObjectConverter();
    }

    @Bean
    public GenreConverter genreConverter(){
        return new GenreConverter();
    }

    @Bean
    public LocationConverter locationConverter(){
        return new LocationConverter();
    }

    @Bean
    public PlatformConverter platformConverter(){
        return new PlatformConverter();
    }

    @Bean
    public PublisherConverter publisherConverter(){
        return new PublisherConverter();
    }

    @Bean
    public ThemeConverter themeConverter(){
        return new ThemeConverter();
    }

    @Bean
    public UserConverter userConverter(){
        return new UserConverter();
    }

    @Bean
    public GameReferenceConverter gameReferenceConverter(){return new GameReferenceConverter();}


}

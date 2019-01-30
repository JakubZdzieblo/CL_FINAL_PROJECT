package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.dto.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ConceptRepository conceptRepository;

    @Autowired
    GameObjectRepository gameObjectRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    PlatformRepository platformRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    ThemeRepository themeRepository;

    @Autowired
    GBQuery gbQuery;

    public DBService() {
    }

    public Game getGameFromDTO(GameDetailsDTO gameDTO) {

        Game game = gameRepository.findByGbId(gameDTO.getId());

        if (game != null){
            return game;
        } else {
            game = new Game();
        }

        game.setGbId(gameDTO.getId());
        game.setName(gameDTO.getName());
        game.setDeck(gameDTO.getDeck());
        game.setDescription(gameDTO.getDescription());
        game.setIconUrl(gameDTO.getImage().getIcon_url());
        game.setImageUrl(gameDTO.getImage().getMedium_url());
        game.setComments(new ArrayList<>());
        if (gameDTO.getOriginal_release_date() != null){
        game.setOriginal_release_date(LocalDate.parse(gameDTO.getOriginal_release_date().substring(0,10)));}

        List<Concept> concepts = new ArrayList<>();
        if (gameDTO.getConcepts() != null){
        for (GameDetailsConceptsDTO el : gameDTO.getConcepts()) { 
            concepts.add(getConceptFromDTO(el));
        }}
        game.setConcepts(concepts);

        List<GameObject> objects = new ArrayList<>();
        if (gameDTO.getObjects() != null){
            for (GameDetailsObjectsDTO el : gameDTO.getObjects()) {
                objects.add(getGameObjectFromDTO(el));
            }
        }
        game.setGameObjects(objects);

        List<Genre> genres = new ArrayList<>();
        if (gameDTO.getGenres() != null){
        for (GameDetailsGenresDTO el : gameDTO.getGenres()) {
            genres.add(getGenreFromDTO(el));
        }}
        game.setGenres(genres);

        List<Location> locations = new ArrayList<>();
        if (gameDTO.getLocations() != null) {
        for (GameDetailsLocationsDTO el : gameDTO.getLocations()) {
            locations.add(getLocationFromDTO(el));
        }}
        game.setLocations(locations);

        List<Platform> platforms = new ArrayList<>();
        if (gameDTO.getPlatforms() != null){
        for (GameDetailsPlatformsDTO el : gameDTO.getPlatforms()) {
            platforms.add(getPlatformFromDTO(el));
        }}
        game.setPlatforms(platforms);

        List<Publisher> publishers = new ArrayList<>();
        if (gameDTO.getPublishers() != null) {
        for (GameDetailsPublishersDTO el : gameDTO.getPublishers()) {
            publishers.add(getPublisherFromDTO(el));
        }}
        game.setPublishers(publishers);

        List<Theme> themes = new ArrayList<>();
        if (gameDTO.getThemes() != null){
        for (GameDetailsThemesDTO el : gameDTO.getThemes()) {
            themes.add(getThemeFromDTO(el));
        }}
        game.setThemes(themes);
        
        gameRepository.save(game);

        return game;

    }

    public Concept getConceptFromDTO(GameDetailsConceptsDTO conceptDTO) {
        Concept concept = conceptRepository.findByGbId(conceptDTO.getId());
        if (concept!=null){
            return concept;
        } else {
            concept = new Concept();
        }
        concept.setGbId(conceptDTO.getId());
        concept.setName(conceptDTO.getName());
        concept.setApi_detail_url(conceptDTO.getApi_detail_url());
        concept.setSite_detail_url(conceptDTO.getSite_detail_url());
        concept.setGames(new ArrayList<>());

        conceptRepository.save(concept);

        return concept;

    }

    public GameObject getGameObjectFromDTO(GameDetailsObjectsDTO gameObjectDTO) {
        GameObject gameObject = gameObjectRepository.findByGbId(gameObjectDTO.getId());
        if (gameObject!=null){
            return gameObject;
        } else {
            gameObject = new GameObject();
        }
        gameObject.setGbId(gameObjectDTO.getId());
        gameObject.setName(gameObjectDTO.getName());
        gameObject.setApi_detail_url(gameObjectDTO.getApi_detail_url());
        gameObject.setSite_detail_url(gameObjectDTO.getSite_detail_url());
        gameObject.setGames(new ArrayList<>());

        gameObjectRepository.save(gameObject);

        return gameObject;
    }
    
    public Genre getGenreFromDTO(GameDetailsGenresDTO genreDTO) {
        Genre genre = genreRepository.findByGbId(genreDTO.getId());
        if (genre!=null){
            return genre;
        } else {
            genre = new Genre();
        }
        genre.setGbId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        genre.setApi_detail_url(genreDTO.getApi_detail_url());
        genre.setSite_detail_url(genreDTO.getSite_detail_url());
        genre.setGames(new ArrayList<>());

        genreRepository.save(genre);

        return genre;

    }

    public Location getLocationFromDTO(GameDetailsLocationsDTO locationDTO) {
        Location location = locationRepository.findByGbId(locationDTO.getId());
        if (location!=null){
            return location;
        } else {
            location = new Location();
        }
        location.setGbId(locationDTO.getId());
        location.setName(locationDTO.getName());
        location.setApi_detail_url(locationDTO.getApi_detail_url());
        location.setSite_detail_url(locationDTO.getSite_detail_url());
        location.setGames(new ArrayList<>());

        locationRepository.save(location);

        return location;

    }
    
    public Platform getPlatformFromDTO(GameDetailsPlatformsDTO platformDTO) {
        Platform platform = platformRepository.findByGbId(platformDTO.getId());
        if (platform != null) {
            return platform;
        } else {
            platform = new Platform();
        }
        platform.setGbId(platformDTO.getId());
        platform.setName(platformDTO.getName());
        platform.setApi_detail_url(platformDTO.getApi_detail_url());
        platform.setSite_detail_url(platformDTO.getSite_detail_url());
        platform.setGames(new ArrayList<>());

        platformRepository.save(platform);

        return platform;
    }

    public Publisher getPublisherFromDTO(GameDetailsPublishersDTO publisherDTO) {
        Publisher publisher = publisherRepository.findByGbId(publisherDTO.getId());
        if (publisher != null) {
            return publisher;
        } else {
            publisher = new Publisher();
        }
        publisher.setGbId(publisherDTO.getId());
        publisher.setName(publisherDTO.getName());
        publisher.setApi_detail_url(publisherDTO.getApi_detail_url());
        publisher.setSite_detail_url(publisherDTO.getSite_detail_url());
        publisher.setGames(new ArrayList<>());

        publisherRepository.save(publisher);

        return publisher;
    }

    public Theme getThemeFromDTO(GameDetailsThemesDTO themeDTO) {
        Theme theme = themeRepository.findByGbId(themeDTO.getId());
        if (theme != null) {
            return theme;
        } else {
            theme = new Theme();
        }
        theme.setGbId(themeDTO.getId());
        theme.setName(themeDTO.getName());
        theme.setApi_detail_url(themeDTO.getApi_detail_url());
        theme.setSite_detail_url(themeDTO.getSite_detail_url());
        theme.setGames(new ArrayList<>());

        themeRepository.save(theme);

        return theme;
    }
    
}

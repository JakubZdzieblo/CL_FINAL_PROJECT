package pl.coderslab.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDetailsDTO {

    Long id;
    String name;
    String deck;
    String description;
    String original_release_date;
    GameDetailsImagesDTO image;
    List<GameDetailsPlatformsDTO> platforms = new ArrayList<>();
    List<GameDetailsConceptsDTO> concepts = new ArrayList<>();
    List<GameDetailsGenresDTO> genres = new ArrayList<>();
    List<GameDetailsLocationsDTO> locations = new ArrayList<>();
    List<GameDetailsObjectsDTO> objects = new ArrayList<>();
    List<GameDetailsPublishersDTO> publishers = new ArrayList<>();
    List<GameDetailsSimilarGamesDTO> similar_games = new ArrayList<>();
    List<GameDetailsThemesDTO> themes = new ArrayList<>();

    public GameDetailsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginal_release_date() {
        return original_release_date;
    }

    public void setOriginal_release_date(String original_release_date) {
        this.original_release_date = original_release_date;
    }

    public GameDetailsImagesDTO getImage() {
        return image;
    }

    public void setImage(GameDetailsImagesDTO image) {
        this.image = image;
    }

    public List<GameDetailsPlatformsDTO> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<GameDetailsPlatformsDTO> platforms) {
        this.platforms = platforms;
    }

    public List<GameDetailsConceptsDTO> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<GameDetailsConceptsDTO> concepts) {
        this.concepts = concepts;
    }

    public List<GameDetailsGenresDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GameDetailsGenresDTO> genres) {
        this.genres = genres;
    }

    public List<GameDetailsLocationsDTO> getLocations() {
        return locations;
    }

    public void setLocations(List<GameDetailsLocationsDTO> locations) {
        this.locations = locations;
    }

    public List<GameDetailsObjectsDTO> getObjects() {
        return objects;
    }

    public void setObjects(List<GameDetailsObjectsDTO> objects) {
        this.objects = objects;
    }

    public List<GameDetailsPublishersDTO> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<GameDetailsPublishersDTO> publishers) {
        this.publishers = publishers;
    }

    public List<GameDetailsSimilarGamesDTO> getSimilar_games() {
        return similar_games;
    }

    public void setSimilar_games(List<GameDetailsSimilarGamesDTO> similar_games) {
        this.similar_games = similar_games;
    }

    public List<GameDetailsThemesDTO> getThemes() {
        return themes;
    }

    public void setThemes(List<GameDetailsThemesDTO> themes) {
        this.themes = themes;
    }
}

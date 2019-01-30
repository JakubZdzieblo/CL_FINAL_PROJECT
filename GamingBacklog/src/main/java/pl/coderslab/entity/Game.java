package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long gbId;
    @NotEmpty
    private String name;

    private String deck;
    @Lob
    private String description;

    private LocalDate original_release_date;

    private String iconUrl;

    private String imageUrl;
    @ManyToMany
    private List<Platform> platforms = new ArrayList<>();
    @ManyToMany
    private List<Concept> concepts = new ArrayList<>();
    @ManyToMany
    private List<Genre> genres = new ArrayList<>();
    @ManyToMany
    private List<Location> locations = new ArrayList<>();
    @ManyToMany
    private List<GameObject> gameObjects = new ArrayList<>();
    @ManyToMany
    private List<Publisher> publishers = new ArrayList<>();
    @ManyToMany
    private List<Game> similar_games = new ArrayList<>();
    @ManyToMany
    private List<Theme> themes = new ArrayList<>();
    @ManyToMany
    private List<User> users = new ArrayList<>();
    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGbId() {
        return gbId;
    }

    public void setGbId(Long gbId) {
        this.gbId = gbId;
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

    public LocalDate getOriginal_release_date() {
        return original_release_date;
    }

    public void setOriginal_release_date(LocalDate original_release_date) {
        this.original_release_date = original_release_date;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public List<Game> getSimilar_games() {
        return similar_games;
    }

    public void setSimilar_games(List<Game> similar_games) {
        this.similar_games = similar_games;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return gbId + " " + name;
    }
}

package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty
    @Size(min=3, max=20)
    String login;

    @Size(min=3, max=50)
    @NotEmpty
    String name;

    @Size(min=3, max=20)
    @NotEmpty
    String password;

    @NotEmpty
    @Email
    String email;

    @ManyToMany
    List<Game> games = new ArrayList<>();

    @ManyToMany
    List<Game> completedGames = new ArrayList<>();

    @OneToMany
    List<Comment> comments = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Game> getCompletedGames() {
        return completedGames;
    }

    public void setCompletedGames(List<Game> completedGames) {
        this.completedGames = completedGames;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return login;
    }
}

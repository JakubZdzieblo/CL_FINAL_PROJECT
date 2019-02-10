package pl.coderslab.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GamesSearchListElementDTO {

    Long id;
    String name;
    String deck;
    String resource_type;
    String original_release_date;

    public GamesSearchListElementDTO() {
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

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public String getOriginal_release_date() {
        return original_release_date;
    }

    public void setOriginal_release_date(String original_release_date) {
        this.original_release_date = original_release_date;
    }

    @Override
    public String toString() {
        return id + " "+ name;
    }
}

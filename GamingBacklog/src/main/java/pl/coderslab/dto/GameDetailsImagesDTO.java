package pl.coderslab.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDetailsImagesDTO {

    String icon_url;
    String medium_url;
    String screen_url;
    String screen_large_url;
    String small_url;
    String super_url;
    String thumb_url;
    String tiny_url;
    String original_url;
    String image_tags;

    public GameDetailsImagesDTO() {
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public void setMedium_url(String medium_url) {
        this.medium_url = medium_url;
    }

    public String getScreen_url() {
        return screen_url;
    }

    public void setScreen_url(String screen_url) {
        this.screen_url = screen_url;
    }

    public String getScreen_large_url() {
        return screen_large_url;
    }

    public void setScreen_large_url(String screen_large_url) {
        this.screen_large_url = screen_large_url;
    }

    public String getSmall_url() {
        return small_url;
    }

    public void setSmall_url(String small_url) {
        this.small_url = small_url;
    }

    public String getSuper_url() {
        return super_url;
    }

    public void setSuper_url(String super_url) {
        this.super_url = super_url;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getTiny_url() {
        return tiny_url;
    }

    public void setTiny_url(String tiny_url) {
        this.tiny_url = tiny_url;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public String getImage_tags() {
        return image_tags;
    }

    public void setImage_tags(String image_tags) {
        this.image_tags = image_tags;
    }
}

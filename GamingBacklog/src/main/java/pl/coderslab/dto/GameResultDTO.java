package pl.coderslab.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameResultDTO {

    String error;
    int limit;
    int offset;
    int number_of_page_results;
    int number_of_total_results;
    int status_code;
    GameDetailsDTO results;

    public GameResultDTO() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getNumber_of_page_results() {
        return number_of_page_results;
    }

    public void setNumber_of_page_results(int number_of_page_results) {
        this.number_of_page_results = number_of_page_results;
    }

    public int getNumber_of_total_results() {
        return number_of_total_results;
    }

    public void setNumber_of_total_results(int number_of_total_results) {
        this.number_of_total_results = number_of_total_results;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public GameDetailsDTO getResults() {
        return results;
    }

    public void setResults(GameDetailsDTO results) {
        this.results = results;
    }
}

package pl.coderslab.service;

import pl.coderslab.dto.GamesSearchListElementDTO;
import pl.coderslab.dto.GamesSearchResultDTO;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.codehaus.jackson.map.ObjectMapper;


public class GBQuery {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(1980,10,10);
        LocalDate date2 = LocalDate.of(1990,12,01);

        List<GamesSearchListElementDTO> res1 = gameFilterResult(94, date1, date2, 20);
        List<GamesSearchListElementDTO> res2 = gameSearchResult("Gear", 20);

        System.out.println(res1);
        System.out.println(res2);
    }

    public static List<GamesSearchListElementDTO> gameFilterResult(int platform_id, LocalDate releaseDateAfter, LocalDate releaseDateBefore, int limit) {

        String url = "https://www.giantbomb.com/api/games/?api_key=a27aa22010c29559d6fec67de238b8d50337ff34&" +
                "format=json&" +
                "filter=platforms:"+platform_id+"," +
                "original_release_date:"+releaseDateAfter+"|"+releaseDateBefore+"&" +
                "limit=" + limit + "&" +
                "field_list=id,name,deck,resource_type,original_release_date";

        return getGamesSearchListElementDTOS(url);
    }

    public static List<GamesSearchListElementDTO> gameSearchResult(String query, int limit) {

        String url = "https://www.giantbomb.com/api/search/?api_key=a27aa22010c29559d6fec67de238b8d50337ff34&" +
                "format=json&query="+query+"&" +
                "limit="+limit+"&resources=game&" +
                "field_list=id,name,deck,resource_type,original_release_date";

        return getGamesSearchListElementDTOS(url);
    }

    private static List<GamesSearchListElementDTO> getGamesSearchListElementDTOS(String url) {
        List<GamesSearchListElementDTO> resultList = new ArrayList<>();

        HttpClient client = new HttpClient();

        GetMethod method = new GetMethod();
        try {
            method.setURI(new URI(url, false));
        } catch (URIException e) {
            e.printStackTrace();
        }

        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        try {
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            byte[] responseBody = method.getResponseBody();

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = new String(responseBody);
            GamesSearchResultDTO result = mapper.readValue(jsonInString, GamesSearchResultDTO.class);

            resultList = result.getResults();


        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {

            method.releaseConnection();
        }

        return resultList;
    }


}

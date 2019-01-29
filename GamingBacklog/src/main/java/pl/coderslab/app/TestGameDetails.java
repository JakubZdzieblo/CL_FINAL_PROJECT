package pl.coderslab.app;


import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.codehaus.jackson.map.ObjectMapper;
import pl.coderslab.dto.*;

import java.io.IOException;

public class TestGameDetails {

    private static String gameUrl = "https://www.giantbomb.com/api/game/3030-31643/?api_key=a27aa22010c29559d6fec67de238b8d50337ff34&" +
            "format=json&" +
            "field_list=id,name,deck,description,image,original_release_date,concepts,genres,locations,objects,publishers,similar_games,themes";


    public static void main(String[] args) {
        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();

        // Create a method instance.
        GetMethod method = new GetMethod();
        try {
            method.setURI(new URI(gameUrl, false));
        } catch (URIException e) {
            e.printStackTrace();
        }

        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = new String(responseBody);
            GameResultDTO result = mapper.readValue(jsonInString, GameResultDTO.class);

            System.out.println(result.getError());
            System.out.println(result.getLimit());
            System.out.println(result.getOffset());
            System.out.println(result.getNumber_of_page_results());
            System.out.println(result.getNumber_of_total_results());
            System.out.println(result.getStatus_code());

            GameDetailsDTO game = result.getResults();

            System.out.println(game.getName());
            System.out.println(game.getDeck());
            System.out.println(game.getDescription());
            System.out.println(game.getOriginal_release_date());




        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
    }

}

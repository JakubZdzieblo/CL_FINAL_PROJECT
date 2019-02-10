package pl.coderslab.app;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import pl.coderslab.dto.GamesSearchListElementDTO;
import pl.coderslab.dto.GamesSearchResultDTO;

import java.io.*;

public class Test {

    private static String searchUrl = "https://www.giantbomb.com/api/search/?api_key=a27aa22010c29559d6fec67de238b8d50337ff34&" +
            "format=json&query=%22metal%22&limit=20&resources=game&" +
            "field_list=id,name,deck,resource_type,original_release_date";

    private static String listUrl = "https://www.giantbomb.com/api/games/?api_key=a27aa22010c29559d6fec67de238b8d50337ff34&" +
            "format=json&filter=platforms:146,original_release_date:2018-01-01|2018-12-31&limit=20&" +
            "field_list=id,name,deck,resource_type,original_release_date";


    public static void main(String[] args) {
        // Create an instance of HttpClient.
        //
        HttpClient client = new HttpClient();

        // Create a method instance.
        GetMethod method = new GetMethod();
        try {
            method.setURI(new URI(listUrl, false));
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
            GamesSearchResultDTO result = mapper.readValue(jsonInString, GamesSearchResultDTO.class);

            System.out.println(result.getError());
            System.out.println(result.getLimit());
            System.out.println(result.getOffset());
            System.out.println(result.getNumber_of_page_results());
            System.out.println(result.getNumber_of_total_results());
            System.out.println(result.getStatus_code());


            for (GamesSearchListElementDTO el : result.getResults()) {
                System.out.println(el.getName());
                System.out.println(el.getDeck());
                System.out.println(el.getOriginal_release_date());
            }


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

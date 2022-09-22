package vttp.ssf.MiniProj.Service;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
//helllo
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.ssf.MiniProj.Models.TrailerModel;

@Service
public class TrailerService{

    private  final String URL = "https://imdb-api.com/API/YouTubeTrailer/" ;

    @Value("${API_KEY}")
    private String key;

   public String gettrailer(String id){


    String payload;
    System.out.println("Getting Movie plot PAYLOAD FROM API >>>>");

    try {
        // Create the url with query string
        String url = UriComponentsBuilder.fromUriString(URL)
            .queryParam("apiKey", key)
            .queryParam("id", id)
            .toUriString();

           // System.out.println( url +"     "+ key);
            // Create the GET request, GET url
            RequestEntity<Void> req = RequestEntity.get(url).build();

            // Make the call to the api
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> resp;

            // Throws an exception if status code not in between 200 - 399
            resp = template.exchange(req, String.class);

            // Get the payload and do something with it
            payload = resp.getBody();
          //  System.out.println("payload: " + payload);

      
      
        } catch (Exception ex) {
            System.err.printf("Error: %s\n", ex.getMessage());
            
            return null;
        }

        Reader strReader = new StringReader(payload);
         // Create a JsonReader from Reader
        JsonReader jsonReader = Json.createReader(strReader);
    // Read the payload as Json object
        JsonObject payloadResult = jsonReader.readObject();
        JsonObject results = payloadResult.asJsonObject();
        String url = results.getString("videoUrl");

        String url1 = url.replace("watch?v=", "embed/");


        
    
    
         return url1;



    }

}

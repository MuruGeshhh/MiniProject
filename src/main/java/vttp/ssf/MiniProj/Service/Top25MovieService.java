package vttp.ssf.MiniProj.Service;

import java.io.Reader;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.lettuce.core.dynamic.annotation.Key;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.ssf.MiniProj.Models.Top25model;

@Service
public class Top25MovieService {


    
    
    private  final String URL = "https://imdb-api.com/en/API/Top250Movies/" ;

    @Value("${API_KEY}")
    private String key;

 
    
    

  //  @Autowired
    //private WeatherRepository weatherRepo;

    public List<Top25model> gettop25() {

        String payload;
        System.out.println("Getting TOP 25 PAYLOAD FROM API >>>>");
        
        try {
            // Create the url with query string
            String url = UriComponentsBuilder.fromUriString(URL)
                .queryParam("apiKey", key)
                .toUriString();

                //System.out.println( url +"     "+ key);
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
                return Collections.emptyList();
            }

            Reader strReader = new StringReader(payload);
             // Create a JsonReader from Reader
            JsonReader jsonReader = Json.createReader(strReader);
        // Read the payload as Json object
            JsonObject payloadResult = jsonReader.readObject();
            JsonArray array = payloadResult.getJsonArray("items");


            List<Top25model> list = new LinkedList<>();
           
            for (int i = 0; i < array.size(); i++) {
               
                JsonObject jo = array.getJsonObject(i);
                list.add(Top25model.create(jo));
            }
            
            return list;

  }

}
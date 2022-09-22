package vttp.ssf.MiniProj.Models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class MovieCastModel {

    private String asCharacter;
    private String name;
    private String image;
   
   
    public String getAsCharacter() {
        return asCharacter;
    }
    public void setAsCharacter(String asCharacter) {
        this.asCharacter = asCharacter;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }


    public static MovieCastModel create(JsonObject jo) {
        MovieCastModel c = new MovieCastModel();
        c.setAsCharacter(jo.getString("asCharacter"));
        c.setImage(jo.getString("image"));
        c.setName(jo.getString("name"));
       
        return c;
    }
    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("image", image)
            .add("asCharacter", asCharacter)
            .add("name", name)
            

            .build();
    }














    
}

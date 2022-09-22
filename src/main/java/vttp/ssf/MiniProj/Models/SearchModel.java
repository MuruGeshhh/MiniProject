package vttp.ssf.MiniProj.Models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class SearchModel {

    private String id;
    private String image;
    private String title;
   
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public static SearchModel create(JsonObject jo) {
        SearchModel s = new SearchModel();
        s.setId(jo.getString("id"));
        s.setTitle(jo.getString("title"));
        s.setImage(jo.getString("image"));
        return s;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("id", id)
            .add("title", title)
            .add("image", image)
            

            .build();
    }














    
    
}

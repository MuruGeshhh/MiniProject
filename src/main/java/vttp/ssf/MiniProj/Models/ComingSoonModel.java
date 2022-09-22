package vttp.ssf.MiniProj.Models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class ComingSoonModel {


    private String id;
    private String fullTitle;
    private String releaseState;
   
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFullTitle() {
        return fullTitle;
    }
    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }
    public String getReleaseState() {
        return releaseState;
    }
    public void setReleaseState(String releaseState) {
        this.releaseState = releaseState;
    }
    
    
  

    public static ComingSoonModel create(JsonObject jo) {
        ComingSoonModel u = new ComingSoonModel();
        u.setId(jo.getString("id"));
        u.setFullTitle(jo.getString("fullTitle"));
        u.setReleaseState(jo.getString("releaseState"));
        
        return u;
    }
    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("id", id)
            .add("fullTitle", fullTitle)
            .add("releaseState", releaseState)
            
            

            .build();
    }


        










    
}

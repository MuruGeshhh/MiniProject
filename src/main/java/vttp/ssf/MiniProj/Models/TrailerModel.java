package vttp.ssf.MiniProj.Models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class TrailerModel {


    private String imDbId;
    private String fullTitle;
    private String videoUrl;
   
   
    public String getImDbId() {
        return imDbId;
    }
    public void setImDbId(String imDbId) {
        this.imDbId = imDbId;
    }
    public String getFullTitle() {
        return fullTitle;
    }
    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }
    public String getVideoUrl() {
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }



    public static TrailerModel create(JsonObject jo) {
        TrailerModel t = new TrailerModel();
        t.setImDbId(jo.getString("imDbId"));
        t.setFullTitle(jo.getString("fullTitle"));
        t.setVideoUrl(jo.getString("videoUrl"));
        
        
        return t;


    }
    public JsonObject toJson() {
        return Json.createObjectBuilder()
            
            .add("fullTitle", fullTitle)
            .add("videoUrl", videoUrl)
            
            
            

            .build();
    }
    

    
}

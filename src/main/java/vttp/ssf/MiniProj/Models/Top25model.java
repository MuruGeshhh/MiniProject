package vttp.ssf.MiniProj.Models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Top25model {

    private String id;
    private String rank;
    private String title;
    private String year;
    private String image;
  
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public static Top25model create(JsonObject jo) {
        Top25model t = new Top25model();
        t.setId(jo.getString("id"));
        t.setRank(jo.getString("rank"));
        t.setTitle(jo.getString("title"));
        t.setYear(jo.getString("year"));
        t.setImage(jo.getString("image"));
        return t;
    }
    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("id", id)
            .add("rank", rank)
            .add("title", title)
            .add("year", year)
            .add("image", image)
            

            .build();
    }

    
}

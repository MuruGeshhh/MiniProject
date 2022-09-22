package vttp.ssf.MiniProj.Models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class MovieDetailModel {

    
    private String year;
    private String title;
    private String image;
    private String releaseDate;
    private String runtimeStr;
    private String plot;
    private String awards;
    private String directors;
  
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getRuntimeStr() {
        return runtimeStr;
    }
    public void setRuntimeStr(String runtimeStr) {
        this.runtimeStr = runtimeStr;
    }
    public String getPlot() {
        return plot;
    }
    public void setPlot(String plot) {
        this.plot = plot;
    }
    public String getAwards() {
        return awards;
    }
    public void setAwards(String awards) {
        this.awards = awards;
    }
    public String getDirectors() {
        return directors;
    }
    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public static MovieDetailModel create(JsonObject jo) {
        MovieDetailModel m = new MovieDetailModel();
        m.setYear(jo.getString("year"));
        m.setTitle(jo.getString("title"));
        m.setImage(jo.getString("image"));
        m.setReleaseDate(jo.getString("releaseDate"));
        m.setRuntimeStr(jo.getString("runtimeStr"));
        m.setPlot(jo.getString("plot"));
        m.setAwards(jo.getString("awards"));
        m.setDirectors(jo.getString("directors"));
        
        return m;


    }
    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("year", year)
            .add("title", title)
            .add("image", image)
            .add("releaseDate", releaseDate)
            .add("runtimeStr", runtimeStr)
            .add("plot", plot)
            .add("awards", awards)
            .add("directors", directors)
            

            .build();
    }

    








    
}

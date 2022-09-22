package vttp.ssf.MiniProj.Models;

public class Review {

    private String movietitle;
    private String name;
    private String comment;

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }


    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Review(  String movietitle, String name, String comment)
    {
        this.name = name;
        this.comment = comment;  
        this.movietitle = movietitle;  
     }







    
}

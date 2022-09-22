package vttp.ssf.MiniProj.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vttp.ssf.MiniProj.Models.Review;


@Service
public class ReviewService {

    private List<Review> reviews = new ArrayList<Review>();

    public ReviewService(){

        reviews.add(new Review("Movie Title", "Name","Comment"));
       




    }

    public List<Review> getReview(){

        return this.reviews;


    }

    public void addReview(Review r) {

        reviews.add(new Review(r.getMovietitle(),r.getName(), r.getComment()));

    }
    









}

package vttp.ssf.MiniProj.Controllers;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.ssf.MiniProj.Models.ComingSoonModel;
import vttp.ssf.MiniProj.Models.MovieCastModel;
import vttp.ssf.MiniProj.Models.MovieDetailModel;
import vttp.ssf.MiniProj.Models.Review;
import vttp.ssf.MiniProj.Models.ReviewForm;
import vttp.ssf.MiniProj.Models.SearchModel;
import vttp.ssf.MiniProj.Models.Top25model;
import vttp.ssf.MiniProj.Service.ComingSoonService;
import vttp.ssf.MiniProj.Service.MovieDetail;
import vttp.ssf.MiniProj.Service.ReviewService;
import vttp.ssf.MiniProj.Service.SearchService;
import vttp.ssf.MiniProj.Service.Top25MovieService;
import vttp.ssf.MiniProj.Service.TrailerService;

@Controller
public class MainController {

    private List<Review> review = new ArrayList<Review>();

    String test;

    @Autowired
    private ReviewService rvSvc;

    @Autowired
    private SearchService seSvc;

    @Autowired
    private Top25MovieService Top25Svc;

    @Autowired
    private MovieDetail mdSvC;

    @Autowired
    private ComingSoonService cmSvc;

    @Autowired
    private TrailerService trSVc;



    @RequestMapping(value={"/", "/accept",""," "},method=RequestMethod.GET)
    @GetMapping
    public String getE(Model model){

        
        
        return "Index";

    }


    



   
    @RequestMapping(path="/SearchResult")
    @GetMapping
    public String getExchanges(Model model, @RequestParam String input){

        List<SearchModel> sm = seSvc.getsearch(input);
        
        model.addAttribute("input", input);
        
        model.addAttribute("search",sm);
        
        return "SearchResult";

    }


    @RequestMapping(path="/ComingSoon")
    @GetMapping
    public String getcomingsoon(Model model)
    {
     List<ComingSoonModel> cm = cmSvc.getComingsoon();
     model.addAttribute("hello", cm);
     
     
     return "/ComingSoon";
    }

  
  
    @RequestMapping(path="/top250")
    @GetMapping
    public String gettop250 (Model model)
    {
     List<Top25model> tp = Top25Svc.gettop25();
     model.addAttribute("hello", tp);
     
     
     return "/top250";
    }


    @RequestMapping(path="/MovieDetail/{id}")
    @GetMapping
    public String gettop250 (Model model, @PathVariable String id)
    {

    review = rvSvc.getReview();

    List<MovieDetailModel> moviedeets = mdSvC.getMovieDeets(id);
   

    List<MovieCastModel> mcm = mdSvC.getMovieCast(id);

    System.out.println(test);
    

    
    model.addAttribute("review", review);
    model.addAttribute("movieid", id);
    model.addAttribute("cast", mcm);
    model.addAttribute("moviedetail", moviedeets);

    
   



     System.out.println(id);
    
     
     return "/MovieDetail";
    }



    @RequestMapping(path="/TrailerPage/{id}")
    @GetMapping
    public String gettrailer (Model model, @PathVariable String id)
    {

    

    String url = trSVc.gettrailer(id);

    model.addAttribute("url", url);
       return "/TrailerPage";
    }













    @RequestMapping(value="/addReview/{movieid}" , method=RequestMethod.GET)
     public String addCommentPage(Model model, @PathVariable String movieid){
      

        String title = mdSvC.gettitle(movieid);

        model.addAttribute("title", title);
        ReviewForm rform = new ReviewForm();
        model.addAttribute("ReviewForm",rform);
        model.addAttribute("movieid", movieid);
        System.out.printf("movie id in /addreview/id/ GET" + movieid + title);


        return "addReview";
     }









     @RequestMapping(value="/addReview/{movieid}", method=RequestMethod.POST)
     public String saveReview(Model model, @ModelAttribute("ReviewForm") ReviewForm reviewForm , @RequestParam String movieid , String title){



        System.out.println("MOVIE ID IN POST " + movieid);
      
        //String fmovietitle = reviewForm.getMovietitle();
        String fmovietitle = title;
        String fName = reviewForm.getName();
        String fComment = reviewForm.getComment();

    //    if(fName != null && fName.length() > 0 && fComment !=null && fComment.length()>0){

            Review newReview = new Review(fmovietitle , fName, fComment);
            rvSvc.addReview(newReview); 

            return "redirect:/MovieDetail/"+ movieid;

     //   }
 
      //  return "addReview";


    }
}









    


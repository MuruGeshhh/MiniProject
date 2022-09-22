package vttp.ssf.MiniProj.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp.ssf.MiniProj.Models.MovieDetailModel;
import vttp.ssf.MiniProj.Models.RestModel;
import vttp.ssf.MiniProj.Service.MovieDetail;
import vttp.ssf.MiniProj.Service.RestService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieRestController {


    @Autowired
	private RestService RESvc;

    

	@GetMapping(path="{movieid}")
	public ResponseEntity<String> getNews(@PathVariable(name="movieid") String movieid) {

       String opt = RESvc.getMovieDeets(movieid);
	 	
		return ResponseEntity.ok(opt);
	}
    }
    
    






    







package gft.training.MoviesTMBD.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.training.MoviesTMBD.Entities.UserMovie;
import gft.training.MoviesTMBD.Repository.UserMovieRepository;
import gft.training.MoviesTMBD.Services.MovieService;


@RestController
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	UserMovieRepository userMovieRepository;

	@GetMapping ("/configuration")
	public Object getConfiguration() {
	   var conf  = movieService.getConfig() ;
	    return conf ;
	}
	
	@GetMapping ("/movie/{movieid}")
	public Object getMovie (
	        @AuthenticationPrincipal UserDetails user ,
	        @PathVariable Integer movie_id
			) {
		UserMovie userMovie = userMovieRepository.findByUsernameAndMovie(user.getUsername(), movie_id).orElse(null);
		HashMap<String, Object> movie = movieService.getMovie(movie_id.toString());
		movie.put("Hello", "World");
		if(userMovie != null) {
			movie.put("favorite", userMovie.getFavorite());
			movie.put("personal_rating", userMovie.getPersonal_rating());
			movie.put("notes", userMovie.getNotes());
		}
		return movie;
	}
	
	
}

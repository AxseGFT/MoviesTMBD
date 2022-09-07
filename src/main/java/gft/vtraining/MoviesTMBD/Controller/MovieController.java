package gft.vtraining.MoviesTMBD.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import gft.vtraining.MoviesTMBD.Entities.CastAndCrew;
import gft.vtraining.MoviesTMBD.Entities.Genres;
import gft.vtraining.MoviesTMBD.Entities.Images;
import gft.vtraining.MoviesTMBD.Entities.Keywords;
import gft.vtraining.MoviesTMBD.Entities.Movie;
import gft.vtraining.MoviesTMBD.Services.MovieService;


@RestController
public class MovieController {
	
	 @Autowired
	    MovieService movieService;
	    @GetMapping("/api/genre/movie/list")
	    public List<Genres> getAllGenres() throws IOException {

	        return movieService.findAllGenres();
	    }
	    
	    @GetMapping("api/movie/popular")
	    public List<Movie> getPopularMovies() throws IOException {
	        return movieService.findPopularMovies();
	    }
	    
	    @GetMapping("api/movie/top_rated")
	    public List<Movie> getTopRatedMovies() throws IOException {
	        return movieService.findPopularMovies();
	    }
	    
	    @GetMapping("api/movie/{movie_id}")
	    public Movie getMoviesById(@PathVariable Integer movie_id) throws IOException {
	        return movieService.findMovieById(movie_id);
	    }
	    
	    @GetMapping("api/movie/{movie_id}/credits")
	    public CastAndCrew getCastAndCrewMovieById(@PathVariable Integer movie_id) throws IOException {
	        return movieService.findCredits(movie_id);
	    }
	    
	    @GetMapping("api/movie/{movie_id}/images")
	    public List<Images> getImagesForMovieById(@PathVariable Integer movie_id) throws IOException {
	        return movieService.findAllImagesForMovieById(movie_id);
	    }
	    
	    @GetMapping("api/movie/{movie_id}/keywords")
	    public List<Keywords> getKeywordsForMovieById(@PathVariable Integer movie_id) throws IOException {
	        return movieService.findAllKeywordsForMovieById(movie_id);
	    }
	    
	    @GetMapping("api/movie/{movie_id}/recommendations")
	    public List<Movie> getRecommendationsForMovieById(@PathVariable Integer movie_id) throws IOException {
	        return movieService.findRecommendationsForMovieById(movie_id);
	    }
	    
	    @GetMapping("api/movie/{movie_id}/similar")
	    public List<Movie> getSimilarMovieById(@PathVariable Integer movie_id) throws IOException {
	        return movieService.findSimilarMoviesById(movie_id);
	    }
	    
}

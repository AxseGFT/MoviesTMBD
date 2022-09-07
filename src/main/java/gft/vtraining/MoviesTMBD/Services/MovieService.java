package gft.vtraining.MoviesTMBD.Services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import gft.vtraining.MoviesTMBD.Entities.Backdrop;
import gft.vtraining.MoviesTMBD.Entities.Cast;
import gft.vtraining.MoviesTMBD.Entities.CastAndCrew;
import gft.vtraining.MoviesTMBD.Entities.Crew;
import gft.vtraining.MoviesTMBD.Entities.Genres;
import gft.vtraining.MoviesTMBD.Entities.Images;
import gft.vtraining.MoviesTMBD.Entities.Keywords;
import gft.vtraining.MoviesTMBD.Entities.Movie;
import gft.vtraining.MoviesTMBD.Entities.Posters;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {
    final String uri = "https://api.themoviedb.org/3/";
    final String apiKey = "2cb9386c946854bb3a092c4af0e52ef9";
    private ObjectMapper mapper;
    private StringBuilder json;

    public List<Genres> findAllGenres() throws IOException {

        StringBuilder jsonReq = getStringFromRequest("genre/movie/list?api_key=");

        Genres[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("genres").toString(),Genres[].class);

        return Arrays.asList(response);

    }

    public List<Movie> findPopularMovies() throws IOException {

        StringBuilder jsonReq = getStringFromRequest("movie/popular?api_key=");

        Movie[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("results").toString(),Movie[].class);

        return Arrays.asList(response);

    }

    public List<Movie> findTopRatedMovies() throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/top_rated?api_key=");

        Movie[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("results").toString(),Movie[].class);

        return Arrays.asList(response);

    }

    public Movie findMovieById(Integer id) throws IOException {
        System.out.println(id.toString());
        StringBuilder jsonReq = getStringFromRequest("movie/"+id.toString()+"?api_key=");

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        Movie response  = mapper.readValue(jsonReq.toString(),Movie.class);

        return response;
    }


    public CastAndCrew findCredits(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/credits?api_key=");
        Cast[] responseCast  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("cast").toString(),Cast[].class);
        Crew[] responseCrew  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("cast").toString(),Crew[].class);
        CastAndCrew response = new CastAndCrew();

        response.setCasts(Arrays.asList(responseCast));
        response.setCrews(Arrays.asList(responseCrew));

        return response;
    }
    
    public List<Images> findAllImagesForMovieById(Integer movie_id) throws IOException {
    	StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/images?api_key=");
        Backdrop[] responseBackdrop  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("backdrops").toString(),Backdrop[].class);
        Posters[] responsePosters  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("posters").toString(),Posters[].class);
        Images response = new Images();

        response.setBackdrop(Arrays.asList(responseBackdrop));
        response.setPosters(Arrays.asList(responsePosters));

        return Arrays.asList(response);
    }
    
    public List<Keywords> findAllKeywordsForMovieById(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/keywords?api_key=");
        Keywords[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("keywords").toString(),Keywords[].class);
        return Arrays.asList(response);

    }
    
    public List<Movie> findRecommendationsForMovieById(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/recommendations?api_key=");
        Movie[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }
    
    public List<Movie> findSimilarMoviesById(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/similar?api_key=");
        Movie[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }

    private StringBuilder getStringFromRequest(String req) throws IOException {
        mapper = new ObjectMapper();
        URL url = new URL(uri+req+apiKey);

        InputStream input = url.openStream();
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        json = new StringBuilder();
        int c ;
        while((c= reader.read())!=-1){
            json.append((char)c);
        }
        return json;
    }
}

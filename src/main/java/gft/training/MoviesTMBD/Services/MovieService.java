package gft.training.MoviesTMBD.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.HashMap;

@Service
@SuppressWarnings("unchecked")
public class MovieService {
	@Value("${themoviedb.api_key}")
	private String api_key;

	WebClient webClient = WebClient.create("https://api.themoviedb.org/3/");

	
	@Cacheable("Configuration")
	public HashMap<String,Object> getConfig() {
		
		HashMap<String,Object> x = webClient.get()
				.uri(UriBuilder -> UriBuilder.path("configuration")
						.queryParam("api_key", "2cb9386c946854bb3a092c4af0e52ef9")
						.build())
				.retrieve()
				.bodyToMono(HashMap.class)
				.block();
		
		return x;
	}
	
	@Cacheable("Movies")
	public HashMap<String, Object> getMovie(String movieid) {
		
		HashMap<String, Object> x = webClient.get()
				.uri(UriBuilder -> UriBuilder.path("/movie/{movieid}")
						.queryParam("api_key", api_key)
						.build(movieid))
				.retrieve()
				.bodyToMono(HashMap.class)
				.block();
		
		return x;
	}
	
	@Cacheable("Genres")
	public HashMap<String, Object> getAllGenres() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("genre/movie/list")
                        .queryParam("api_key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
	
	@Cacheable("Populars")
    public HashMap<String, Object> getPopular() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("movie/popular")
                        .queryParam("api_key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
	
	@Cacheable("Rating")
    public HashMap<String, Object> getTopRated() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("movie/top_rated")
                        .queryParam("api_key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
	
	@Cacheable("MovieFinds")
    public HashMap<String, Object> getMovieById(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("movie/"+id.toString())
                        .queryParam("api_key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
	
	@Cacheable("CastAndCrew")
    public HashMap<String, Object> getCastAndCrew(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("movie/"+id.toString()+"/credits")
                        .queryParam("api_key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
	
	@Cacheable("Images")
    public HashMap<String, Object> getAllImages(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("movie/"+id.toString()+"/images")
                        .queryParam("api_key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
	
	@Cacheable("Keywords")
    public HashMap<String, Object> getKeywords(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("movie/"+id.toString()+"/keywords")
                        .queryParam("api_key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
	
	@Cacheable("Recommendation")
    public HashMap<String, Object> getRecommendations(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("movie/"+id.toString()+"/recommendations")
                        .queryParam("api_key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
	
	@Cacheable("Similar")
    public HashMap<String, Object> getSimilarMovies(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("movie/"+id.toString()+"/similar")
                        .queryParam("api_key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
}
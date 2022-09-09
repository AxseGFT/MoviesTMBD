package gft.training.MoviesTMBD.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import gft.training.MoviesTMBD.Entities.UserMovie;
import gft.training.MoviesTMBD.Repository.UserMovieRepository;
import gft.training.MoviesTMBD.Services.MovieService;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.support.NullValue;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.net.http.HttpHeaders;
import java.security.Principal;
import java.util.HashMap;
import java.util.Optional;


import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class MovieServiceTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	private Integer testId = 550;
	
	@Test
	void getConfigBody() {
		webTestClient.get()
			.uri("/api/configuration")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectHeader().valueEquals("Content-Type","application/json")
			.expectBody()
			.jsonPath("$.images").exists()
			.jsonPath("$.change_keys").exists();
	}
	
	@Test
	void getAllGenres() {
		webTestClient.get()
			.uri("/api/genre/movie/list")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectHeader().valueEquals("Content-Type","application/json")
			.expectBody()
			.jsonPath("$.genres").exists();
	}
	
	@Test
	void getPopularMovies() {
		webTestClient.get()
			.uri("/api/movie/popular")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectHeader().valueEquals("Content-Type","application/json")
			.expectBody()
			.jsonPath("$.page").exists()
			.jsonPath("$.total_pages").exists()
			.jsonPath("$.results").exists()
			.jsonPath("$.total_results").exists();
		
	}
	
	@Test
	void getTopRated() {
		webTestClient.get()
		.uri("/api/movie/top_rated")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().valueEquals("Content-Type","application/json")
		.expectBody()
		.jsonPath("$.page").exists()
		.jsonPath("$.total_pages").exists()
		.jsonPath("$.results").exists()
		.jsonPath("$.total_results").exists();
		
	}
	
	@Test
	void getMovieById() {
		webTestClient.get()
			.uri("/api/movie/" + testId)
			.headers(httpHeaders -> httpHeaders.setBasicAuth("user","password"))
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectHeader().valueEquals("Content-Type","application/json")
			.expectBody()
			.jsonPath("$.id").exists()
			.jsonPath("$.vote_count").exists()
			.jsonPath("$.overview").exists();
		
	}
	

}

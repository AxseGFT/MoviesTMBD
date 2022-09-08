package gft.training.MoviesTMBD.Entities;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.Accessors;



@Entity
@Table(name="user_movie")
public class UserMovie {
    @Id
    @Column(name="movieid",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    String username;
    String movie;
    Boolean favorite;
    Integer personal_rating;
    String notes;
    
	public UserMovie(Integer id, String username, String movie, Boolean favorite, Integer personal_rating,
			String notes) {
		super();
		this.id = id;
		this.username = username;
		this.movie = movie;
		this.favorite = favorite;
		this.personal_rating = personal_rating;
		this.notes = notes;
	}
	
	public UserMovie() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public Integer getPersonal_rating() {
		return personal_rating;
	}

	public void setPersonal_rating(Integer personal_rating) {
		this.personal_rating = personal_rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}




package gft.vtraining.MoviesTMBD.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Images {
	
	private List<Backdrop> backdrop;
	private Long id;
	private List<Posters> posters;
	
	@Override
    public String toString() {
        return "{" +
                "Backdrop=" + backdrop +
                "id=" + id +
                ", Posters=" + posters +
                '}';
    }

	public Images(List<Backdrop> backdrop, Long id, List<Posters> posters) {
		super();
		this.backdrop = backdrop;
		this.id = id;
		this.posters = posters;
	}

	public Images() {
		
	}

	public List<Backdrop> getBackdrop() {
		return backdrop;
	}

	public void setBackdrop(List<Backdrop> backdrop) {
		this.backdrop = backdrop;
	}

	public List<Posters> getPosters() {
		return posters;
	}

	public void setPosters(List<Posters> posters) {
		this.posters = posters;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
    
}

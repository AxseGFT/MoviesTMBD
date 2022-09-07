package gft.vtraining.MoviesTMBD.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CastAndCrew {
    public List<Cast> casts;
    public List<Crew> crews;
    public CastAndCrew() {

    }

    public CastAndCrew(List<Cast> casts, List<Crew> crews) {
        this.casts = casts;
        this.crews = crews;
    }

    @Override
    public String toString() {
        return "CastAndCrew{" +
                "casts=" + casts +
                ", crews=" + crews +
                '}';
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
    }
}

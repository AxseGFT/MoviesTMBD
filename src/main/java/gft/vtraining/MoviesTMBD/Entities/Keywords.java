package gft.vtraining.MoviesTMBD.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Keywords {
    int id;
    String name;

    @Override
    public String toString() {
        return "Keywords{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Keywords(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Keywords() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

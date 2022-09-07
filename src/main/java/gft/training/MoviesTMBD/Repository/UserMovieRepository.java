package gft.training.MoviesTMBD.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gft.training.MoviesTMBD.Entities.UserMovie;

public interface UserMovieRepository extends JpaRepository<UserMovie, Long>{
	

   public Optional<UserMovie> findByUsernameAndMovie ( String username , Integer movie_id ) ;

}

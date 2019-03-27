package eu.gzs.hotseat.Repository;

import eu.gzs.hotseat.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Seance;
import eu.gzs.hotseat.model.Seat;

import java.util.List;

public interface SeanceDAO {
    void save(Seance seance);

    void update(Seance seance, Seat seat);

    void delete(Seance seance);

    void delete_all_seances();

    Seance findBySeanceId(int senaceId);

    Seance findByMovieId(int movieId);

    List<Seance> getAllSeances();
}

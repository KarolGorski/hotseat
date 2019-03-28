package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Seance;

import java.util.List;

public interface SeanceDAO {
    void save(Seance seance);

    void update(Seance seance);

    void delete(Seance seance);

    void delete_all_seances();

    Seance findBySeanceId(int senaceId);

    Seance findByMovieId(int movieId);

    List<Seance> getAllSeances();
}

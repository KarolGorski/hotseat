package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Seance;
import eu.gzs.hotseat.model.Seat;

import java.util.List;

public class SeanceService {
    private static SeanceDAOImpl seanceDAOImpl;

    public SeanceService() {
        seanceDAOImpl=new SeanceDAOImpl();
    }

    public void save(Seance seance){
        seanceDAOImpl.openCurrentSessionwithTransaction();
        seanceDAOImpl.save(seance);
        seanceDAOImpl.closeCurrentSessionwithTransaction();
    }

    public Seance update(Seance seance, Seat seat){
        seanceDAOImpl.openCurrentSessionwithTransaction();
        seanceDAOImpl.update(seance, seat);
        seanceDAOImpl.closeCurrentSessionwithTransaction();
        return seance;
    }
    public Seance update(Seance seance){
        seanceDAOImpl.openCurrentSessionwithTransaction();
        seanceDAOImpl.update(seance);
        seanceDAOImpl.closeCurrentSessionwithTransaction();
        return seance;
    }

    public void delete(Seance seance){
        seanceDAOImpl.openCurrentSessionwithTransaction();
        seanceDAOImpl.delete(seance);
        seanceDAOImpl.closeCurrentSessionwithTransaction();
    }

    public void delete_all(){
        seanceDAOImpl.openCurrentSessionwithTransaction();
        seanceDAOImpl.delete_all_seances();
        seanceDAOImpl.closeCurrentSessionwithTransaction();
    }

    public Seance findBySeanceId(int seanceId){
        seanceDAOImpl.openCurrentSessionwithTransaction();
        Seance seance=seanceDAOImpl.findBySeanceId(seanceId);
        seanceDAOImpl.closeCurrentSessionwithTransaction();
        return seance;
    }
    public Seance findByMovieId(int movieId){
        seanceDAOImpl.openCurrentSessionwithTransaction();
        Seance seance=seanceDAOImpl.findByMovieId(movieId);
        seanceDAOImpl.closeCurrentSessionwithTransaction();
        return seance;
    }

    public List<Seance> getAllSeances(){
        seanceDAOImpl.openCurrentSessionwithTransaction();
        List<Seance> seances=seanceDAOImpl.getAllSeances();
        seanceDAOImpl.closeCurrentSessionwithTransaction();
        return seances;
    }
}

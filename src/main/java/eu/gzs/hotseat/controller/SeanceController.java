package eu.gzs.hotseat.controller;

import eu.gzs.hotseat.daoclasses.SeanceDAOImpl;
import eu.gzs.hotseat.daoclasses.SeanceService;
import eu.gzs.hotseat.model.Seance;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/seances"})
public class SeanceController {
    private SeanceService seanceService = new SeanceService();

    @GetMapping
    public List<Seance> getAllSeances() {
        List<Seance> seances=seanceService.getAllSeances();
        return seances;
    }

    @GetMapping(path = {"/{id}"})
    public Seance findSeanceById(@PathVariable int id){
        return seanceService.findBySeanceId(id);
    }

    @PostMapping
    public void create(@RequestBody Seance seance){
        seanceService.save(seance);
    }

    @PutMapping(value="/{id}")
    public void update(@PathVariable("id") int id,
                       @RequestBody Seance seance){
        Seance seance_temp=seanceService.findBySeanceId(id);
        seance_temp.setMovie(seance.getMovie());
        seance_temp.setSeats(seance.getSeats());
        seanceService.update(seance_temp);
    }

}

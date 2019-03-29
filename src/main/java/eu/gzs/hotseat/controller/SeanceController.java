package eu.gzs.hotseat.controller;

import eu.gzs.hotseat.daoclasses.ClientService;
import eu.gzs.hotseat.daoclasses.SeanceDAOImpl;
import eu.gzs.hotseat.daoclasses.SeanceService;
import eu.gzs.hotseat.model.Client;
import eu.gzs.hotseat.model.Seance;
import eu.gzs.hotseat.model.Seat;
import org.hibernate.Hibernate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/seances"})
public class SeanceController implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Autowired
    SeanceService seanceService;

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

    @PutMapping(value="/{id}/{seat_id}/{client_id}")
    public Seance reservate(@PathVariable("id") int id, @PathVariable("seat_id") int seat_id, @PathVariable("client_id") int client_id){
        Seance seance_temp=seanceService.findBySeanceId(id);
        Seat seat_tem=seance_temp.getSeats().get(seat_id);

        ClientService clientService=new ClientService();
        Client client=clientService.findByClientId(client_id);

        seat_tem.setClient(client);
        return seanceService.update(seance_temp);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}

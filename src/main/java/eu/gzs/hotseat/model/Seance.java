package eu.gzs.hotseat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Seance")
public class Seance {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "seance_id")
    private List<Seat> seats;

    @OneToOne
    private Movie movie;

    public Seance(){}

    public Seance(Movie movie, int seats_quantity) {
        this.movie = movie;
        seats=new ArrayList<>(seats_quantity);
        for (int i=0; i<seats_quantity; i++){
            seats.add(new Seat());
            System.out.println("Seat no. "+i);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

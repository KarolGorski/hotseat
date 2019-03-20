package eu.gzs.hotseat.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Hall {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private int seatsQuantity;

    public Hall(int seatsQuantity) {
        this.seatsQuantity = seatsQuantity;
    }

    public int getSeatsQuantity() {
        return seatsQuantity;
    }

    public void setSeatsQuantity(int seatsQuantity) {
        this.seatsQuantity = seatsQuantity;
    }
}

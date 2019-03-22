package eu.gzs.hotseat.model;

import javax.persistence.*;

@Entity
@Table(name="Seat")
public class Seat {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @OneToOne
    //@JoinColumn(name = "id_client")
    private Client client;

    public Seat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

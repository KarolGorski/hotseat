package eu.gzs.hotseat.model;

import javax.persistence.*;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
}

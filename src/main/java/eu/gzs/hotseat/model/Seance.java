package eu.gzs.hotseat.model;

import javax.persistence.*;

@Entity
@Table
public class Seance {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;


}

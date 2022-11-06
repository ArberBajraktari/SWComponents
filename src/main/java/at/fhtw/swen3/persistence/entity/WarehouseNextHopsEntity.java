package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.Hop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class WarehouseNextHopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wh_next_hop_id")
    private Integer id;

    private Integer traveltimeMins;


    @JoinColumn(name="hop_id", referencedColumnName="hop_id")
    @ManyToOne
    private HopEntity hop;
}

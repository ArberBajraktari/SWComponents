package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "wh_id")
    private Integer id;

    private Integer level;


    @NotNull
    @OneToMany(cascade = {CascadeType.ALL})
//    @JoinColumn
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}

package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entity.ErrorEntity;
import at.fhtw.swen3.persistence.entity.TruckEntity;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<TruckEntity, Integer> {

}
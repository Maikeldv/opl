package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Animal;
import be.thomasmore.party.model.Party;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    List<Animal> findAllBy();
}

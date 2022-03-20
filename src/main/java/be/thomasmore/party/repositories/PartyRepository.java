package be.thomasmore.party.repositories;


import be.thomasmore.party.model.Artist;
import be.thomasmore.party.model.Party;
import be.thomasmore.party.model.Venue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartyRepository extends CrudRepository<Party, Integer> {
    List<Party> findAllBy();
    //hier bij findBy kan je alle namen zetten van de private vars
    Iterable<Party> findByVenue(Venue venue);

}

package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Artist;
import be.thomasmore.party.model.Party;
import be.thomasmore.party.repositories.ArtistRepository;
import be.thomasmore.party.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller

public class PartyController {
    @Autowired
   private PartyRepository partyRepository;
    @GetMapping("/partylist")
    public String partyList(Model model) {

        List<Party> parties = partyRepository.findAllBy();
        model.addAttribute("parties", parties);

        return "partylist";
    }
    @GetMapping({ "/partydetails/{id}", "/partydetails"})
    public String partyDetails(Model model,
                                @PathVariable(required = false) Integer id) {
        if (id == null) return "partydetails";

        Optional<Party> optionalParty = partyRepository.findById(id);
        //noinspection OptionalIsPresent
        if (optionalParty.isPresent()) {
            model.addAttribute("parties", optionalParty.get());
        }
        return "partydetails";
    }

}

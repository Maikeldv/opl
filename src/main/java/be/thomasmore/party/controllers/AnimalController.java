package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Animal;
import be.thomasmore.party.model.Party;
import be.thomasmore.party.repositories.AnimalRepository;
import be.thomasmore.party.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;
    @GetMapping({ "/animaldetails/{id}", "/animaldetails"})
    public String animalDetails(Model model,
                               @PathVariable(required = false) Integer id) {
        if (id == null) return "animaldetails";


        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        //noinspection OptionalIsPresent
        if (optionalAnimal.isPresent()) {
            model.addAttribute("animals", optionalAnimal.get());
        }
        return "animaldetails";
    }
}

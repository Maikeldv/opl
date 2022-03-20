package be.thomasmore.party.controllers;



import be.thomasmore.party.model.Party;

import be.thomasmore.party.repositories.PartyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private PartyRepository partyRepository;

    @GetMapping( "/partyedit/{id}")
    public String partyEdit(Model model, @PathVariable(required = false) Integer id) {
        logger.info("partyedit");

        if (id == null) return "admin/partyedit";


        Optional<Party> partyFromDb = partyRepository.findById(id);


        if (partyFromDb.isPresent()) {
            model.addAttribute("parties", partyFromDb.get());

        }
        return "admin/partyedit";
    }

    @PostMapping("/partyedit/{id}")
    public String partyEditPost(Model model, @PathVariable int id,
                                @RequestParam String partyName,
                                @RequestParam int price,
                                @RequestParam int pricePreSale,
                                @RequestParam String extraInfo){
       logger.info("partyEditPost "+id + " --- new name=" + partyName + price + pricePreSale + extraInfo);
       Optional<Party> optionalParty=partyRepository.findById(id);
       if (optionalParty.isPresent()){
           Party party = optionalParty.get();
           party.setName(partyName);
           party.setPriceInEur(price);
           party.setPricePresaleInEur(pricePreSale);
           party.setExtraInfo(extraInfo);

           partyRepository.save(party);
           model.addAttribute("party", optionalParty.get());

       }
       return "redirect:/partydetails/"+id;
    }



        }







package PopulationRegistrationSystem.controller;

import PopulationRegistrationSystem.model.Citizen;
import PopulationRegistrationSystem.repository.CitizenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citizens/find")
public class CitizenFindController {

    //Powinienem wstrzyknąć serwis a nie repozytorium
    private CitizenRepository citizenRepository;

    public CitizenFindController(CitizenRepository citizenRepository){ this.citizenRepository = citizenRepository;}

    @GetMapping("/name")
    public ResponseEntity<List<Citizen>> findCitizens (@RequestParam("name") String citizenName){
        List<Citizen> citizens = citizenRepository.findCitizens(citizenName);
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }
}

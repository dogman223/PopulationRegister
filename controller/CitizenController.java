package PopulationRegistrationSystem.controller;

import PopulationRegistrationSystem.service.CitizenManager;
import PopulationRegistrationSystem.model.Citizen;
import PopulationRegistrationSystem.request.CreateCitizenRequest;
import PopulationRegistrationSystem.request.UpdateCitizenRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    private CitizenManager citizenManager;

    @GetMapping
    public ResponseEntity<List<Citizen>> getCitizenss() {
        List<Citizen> citizens = citizenManager.getCitizens();
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCitizen(@RequestBody CreateCitizenRequest citizenRequest) {
        citizenManager.saveCitizen(citizenRequest);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCitizen(@PathVariable("id") Long id) {
        citizenManager.delete(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity updateCitizen(@PathVariable("id") Long id, @RequestBody UpdateCitizenRequest updateCitizenRequest) {
        citizenManager.updateCitizen(id, updateCitizenRequest);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    public ResponseEntity patchCitizen(@PathVariable("id") Long id, @RequestBody UpdateCitizenRequest updateCitizenRequest) {
        citizenManager.patchCitizen(id, updateCitizenRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}

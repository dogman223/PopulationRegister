package PopulationRegistrationSystem.service;

import PopulationRegistrationSystem.exception.CitizenNotFoundException;
import PopulationRegistrationSystem.model.Citizen;
import PopulationRegistrationSystem.model.Gender;
import PopulationRegistrationSystem.repository.CitizenRepository;
import PopulationRegistrationSystem.request.CreateCitizenRequest;
import PopulationRegistrationSystem.request.UpdateCitizenRequest;
import PopulationRegistrationSystem.service.CitizenFullFledged;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenManager implements InitializingBean {

    private CitizenFullFledged citizenFullFledged;

    public CitizenManager(CitizenFullFledged citizenFullFledged) {
        this.citizenFullFledged = citizenFullFledged;
    }

    private CitizenRepository citizenRepository;

    public CitizenManager(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public List<Citizen> getCitizens() {
        return citizenRepository.findAll();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        saveCitizen();
    }

    private void saveCitizen() {
        Citizen citizen = new Citizen();
        citizenRepository.save(citizen);
    }

    public void saveCitizen(CreateCitizenRequest citizenRequest) {
        //java 11
        //var entity = CitizenMapper.map(citizenRequest);
        //java 8
        Citizen entity = CitizenMapper.map(citizenRequest);
        citizenRepository.save(entity);
    }


    public void delete(Long id) {
        citizenRepository.findById(id)
                .orElseThrow(CitizenNotFoundException::new);
        //.orElseThrow(() -> new CitizenNotFoundException());
        citizenRepository.deleteById(id);
    }

    public void updateCitizen(Long id, UpdateCitizenRequest updateCitizenRequest){
        Citizen citizen = citizenRepository.findById(id).orElseThrow(CitizenNotFoundException::new);
        citizen.setName(updateCitizenRequest.getName());
        citizen.setSurname(updateCitizenRequest.getSurname());
        citizen.setGender(updateCitizenRequest.getGender());
        citizenRepository.save(citizen);
    }

    public void patchCitizen(Long id, UpdateCitizenRequest updateCitizenRequest){
        Citizen citizen = citizenRepository.findById(id).orElseThrow(CitizenNotFoundException::new);
        //Optional.ofNullable(updateCitizenRequest.getName()).ifPresent(i -> citizen.setName(i));

        Optional.ofNullable(updateCitizenRequest.getName()).ifPresent(citizen::setName);

        Optional.ofNullable(updateCitizenRequest.getSurname()).ifPresent(citizen::setSurname);

        Optional.ofNullable(updateCitizenRequest.getGender()).ifPresent(citizen::setGender);

        citizenRepository.save(citizen);


    }

}

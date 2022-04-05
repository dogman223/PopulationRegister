package PopulationRegistrationSystem.repository;

import PopulationRegistrationSystem.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen,Long> {

    List<Citizen> findCitizenByPesel(Long pesel);

    List<Citizen> findCitizenByName(String name);

    List<Citizen> findCitizenBySurname(String surname);

    List<Citizen> findCitizenByNameAndSurname(String name, String surname);

    default List<Citizen> findCitizens(String name){
        return findCitizenByNameAndSurname(name);
    }


}

package PopulationRegistrationSystem.service;

import PopulationRegistrationSystem.model.Citizen;
import PopulationRegistrationSystem.model.Job;
import PopulationRegistrationSystem.request.CreateCitizenRequest;
import PopulationRegistrationSystem.request.CreateJobRequest;

import java.util.stream.Collectors;

public class CitizenMapper {

    public static Citizen map(CreateCitizenRequest citizenRequest) {
        Citizen citizen = new Citizen();
        citizen.setName(citizenRequest.getName());
        citizen.setGender(citizenRequest.getGender());
        citizen.setSurname(citizenRequest.getSurname());
        citizen.setJobs(citizenRequest.getJobs()
                .stream()
                //.map(i -> mapToy(i))
                .map(CitizenMapper::mapJob)
                .collect(Collectors.toList())
        );
        return citizen;
    }

    private static Job mapJob(CreateJobRequest jobRequest) {
        return new Job(jobRequest.getName());
    }

}

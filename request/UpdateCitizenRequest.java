package PopulationRegistrationSystem.request;


import PopulationRegistrationSystem.model.Gender;
import java.util.List;

public class UpdateCitizenRequest {

    private String name;
    private String surname;
    private Gender gender;
    private Long pesel;

    private List<CreateJobRequest> jobs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<CreateJobRequest> getJobs() {
        return jobs;
    }

    public void setJobs(List<CreateJobRequest> jobs) {
        this.jobs = jobs;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }
}

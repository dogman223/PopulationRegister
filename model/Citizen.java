package PopulationRegistrationSystem.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "/citizens")
public class Citizen {

    public Citizen(){}

    public Citizen(String name, String surname, Gender gender, Long pesel) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.pesel = pesel;
    }

    @Id
    @GeneratedValue
    private long id;
    private long pesel;
    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "citizen_id")
    private List<Job> jobs;

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

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public long getId() {
        return id;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }
}

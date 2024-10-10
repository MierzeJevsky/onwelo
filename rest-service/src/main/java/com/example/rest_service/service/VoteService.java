package com.example.rest_service.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rest_service.entity.Person;
import com.example.rest_service.entity.PersonEnum;
import com.example.rest_service.repo.PersonRepository;

@Service
public class VoteService {

    @Autowired
    PersonRepository repository;

    final private String ALREADY_VOTED = "This user has already voted.";
    final private String WRONG_PARAMS = "Wrong parameters";
    final private String NEW_VOTE = "This user voted for: %s.";

    public Person addPerson(String name, PersonEnum personEnum) {
        Person person = Person.builder()
            .name(name)
            .personEnum(personEnum)
            .build();
        repository.save(person);

        return person;
    }

    public String vote(String voterName, String candidateName) {
        Optional<Person> voterOpt = repository.findByName(voterName);
        Optional<Person> candidateOpt = repository.findByName(candidateName);

        if (voterOpt.isPresent() && candidateOpt.isPresent()) {
            Person voter = voterOpt.get();
            Person candidate = candidateOpt.get();

            if (!voter.getVoted()) {
                candidate.addVote();
                repository.save(candidate);

                return String.format(NEW_VOTE, candidate.getName());
            }

            return ALREADY_VOTED;
        }

        throw new InternalError(WRONG_PARAMS);
    }

    public List<Person> getAll() {
        // List<Person> list = new ArrayList<>();
        // repository.findAll().forEach(list::add);
        // return list;
        return repository.findAll();
    }
}

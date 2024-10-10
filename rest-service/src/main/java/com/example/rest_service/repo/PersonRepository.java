package com.example.rest_service.repo;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.example.rest_service.entity.Person;

    public interface PersonRepository extends ListCrudRepository<Person,Long> {

    Optional<Person> findByName(String voterName);
}

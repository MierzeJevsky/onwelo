package com.example.rest_service.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_service.entity.Person;
import com.example.rest_service.entity.PersonEnum;
import com.example.rest_service.service.VoteService;

@RestController
@RequestMapping("/vote")
public class VoteController {
	
	@Autowired
	VoteService service;

	@PostMapping("/add")
	public ResponseEntity<String> vote(
		@RequestParam(value = "name", defaultValue = "Adam") String voterName,
		@RequestParam(value = "name", defaultValue = "Eve") String candidateName) {
		// String result = service.vote(voterName, candidateName);
		// return new ResponseEntity<>(result, HttpStatus.OK);
		try {
            return ResponseEntity.ok(service.vote(voterName, candidateName));
        } catch (Throwable t) {;
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(t.toString());
        }
    }

	@GetMapping("/get_all")
	public ResponseEntity<List<Person>> getAll() {
		// List<Person> result = service.getAll();
		Person person1 = Person.builder().id(1L).name("1").personEnum(PersonEnum.VOTER).voted(false).votes(0).build();
		Person person2 = Person.builder().id(2L).name("2").personEnum(PersonEnum.CANDIDATE).voted(false).votes(0).build();
		List<Person> result = List.of(person1, person2);
		return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
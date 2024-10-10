package com.example.rest_service.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_service.entity.Person;
import com.example.rest_service.entity.PersonEnum;
import com.example.rest_service.service.VoteService;

@RestController
@RequestMapping("/voter")
public class VoterController {
	
	@Autowired
	VoteService service;

	@PostMapping("/add")
	public ResponseEntity<Person> addVoter(
		@RequestParam(value = "name", defaultValue = "Adam") String name) {
		Person result = service.addPerson(name, PersonEnum.VOTER);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
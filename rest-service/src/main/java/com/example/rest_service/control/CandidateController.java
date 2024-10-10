package com.example.rest_service.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_service.entity.Person;
import com.example.rest_service.entity.PersonEnum;
import com.example.rest_service.service.VoteService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	VoteService service;

	@PostMapping("/add")
	public Person addCandidate(
		@RequestParam(value = "name", defaultValue = "Eve") String name) {
		return service.addPerson(name, PersonEnum.CANDIDATE);
	}
}
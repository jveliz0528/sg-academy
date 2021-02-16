package ar.com.academy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.academy.model.Gender;
import ar.com.academy.repository.IGenderRepository;
import ar.com.academy.services.IGenderService;

@Service
public class GenderService implements IGenderService{
	
	@Autowired
	private IGenderRepository genderRepository;
	
	public List<Gender> getAll() {
		return (List<Gender>) genderRepository.findAll();
	}

	@Override
	public Gender findByCodGender(Long codGender) {
		return findByCodGender(codGender);
	}

	


}

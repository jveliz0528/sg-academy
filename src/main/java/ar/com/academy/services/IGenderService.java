package ar.com.academy.services;


import ar.com.academy.model.Gender;

public interface IGenderService {
	
	public Gender findByCodGender(Long codGender);
}

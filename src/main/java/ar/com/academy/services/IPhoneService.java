package ar.com.academy.services;


import ar.com.academy.model.Gender;

public interface IPhoneService {
	
	public Gender findByCodPhone(Long codPhone);
}

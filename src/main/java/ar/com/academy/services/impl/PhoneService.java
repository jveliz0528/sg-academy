package ar.com.academy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.academy.model.Gender;
import ar.com.academy.model.Phone;
import ar.com.academy.repository.IPhoneRepository;
import ar.com.academy.services.IPhoneService;

@Service
public class PhoneService implements IPhoneService{
	
	@Autowired
	private IPhoneRepository phoneRepository;
	
	public List<Phone> getAll() {
		return (List<Phone>) phoneRepository.findAll();
	}

	@Override
	public Gender findByCodPhone(Long codPhone) {
		return null;
	}

	


}

package ar.com.academy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.academy.model.Gender;
import ar.com.academy.model.Student;

@Repository
public interface IGenderRepository extends CrudRepository<Gender, Long>{
	
	Student findByCodGender(Long codGender);
}

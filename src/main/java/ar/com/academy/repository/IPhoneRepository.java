package ar.com.academy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.academy.model.Phone;
import ar.com.academy.model.Student;

@Repository
public interface IPhoneRepository extends CrudRepository<Phone, Long>{
	Student findByCodPhone(Long codPhone);
}

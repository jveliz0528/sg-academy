package ar.com.academy.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.com.academy.model.Student;

public interface IStudentService {
	
	 public Iterable<Student> findAll();
	 
	 public Page<Student> findAll(Pageable pageable);

	 public Optional<Student> findById(Long id);
	 
	 public Optional<Student> findByDocument(Long document);
	 
	 public Student save(Student student);	 
	 
	 public void remove(Long id);
}

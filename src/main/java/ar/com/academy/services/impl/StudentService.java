package ar.com.academy.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.academy.model.Student;
import ar.com.academy.repository.IGenderRepository;
import ar.com.academy.repository.IPhoneRepository;
import ar.com.academy.repository.IStudentRepository;
import ar.com.academy.services.IStudentService;

@Service
public class StudentService implements IStudentService{

	@Autowired
	private IStudentRepository studentRepository;
	
	@Autowired
	private IGenderRepository genderRepository;

	@Autowired
	private IPhoneRepository phoneRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Student> findAll() {		
		return studentRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Student> findAll(Pageable pageable) {		
		return studentRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}


	@Override
	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Student> findByDocument(Long document) {
		return studentRepository.findByDocument(document);
	}
	
}

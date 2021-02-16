package ar.com.academy.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.academy.model.Teacher;
import ar.com.academy.repository.IGenderRepository;
import ar.com.academy.repository.IPhoneRepository;
import ar.com.academy.repository.ITeacherRepository;
import ar.com.academy.services.ITeacherService;

@Service
public class TeacherService implements ITeacherService{
	
	private static final long serialVersionUID = 3204061481881962016L;

	//@Autowired & Constructor
	@Autowired
	private ITeacherRepository teacherRepository;
		
	@Autowired
	private IGenderRepository genderRepository;

	@Autowired
	private IPhoneRepository phoneRepository;

	
	@Override
	@Transactional
	public List<Teacher> finAll() throws Exception {
		try {
			List<Teacher> allTeacher = teacherRepository.findAll();
			return allTeacher;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Teacher findById(Long id) throws Exception {
		try {
			Optional<Teacher> getTeacher = teacherRepository.findById(id);
			return getTeacher.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Teacher save(Teacher teacher) throws Exception {
		try {
			teacher = teacherRepository.save(teacher);
			return teacher;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	@Transactional
	public Teacher update(Teacher teacher, Long id) throws Exception {
		try {
			Optional<Teacher> teacherOptional = teacherRepository.findById(id);
			Teacher getteacher = teacherOptional.get();
			getteacher = teacherRepository.save(teacher);
			return getteacher;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {
			if (teacherRepository.existsById(id)) {
				teacherRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}

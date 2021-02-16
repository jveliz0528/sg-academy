package ar.com.academy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.academy.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{
	 public Optional<Student> findByDocument(Long document);
}

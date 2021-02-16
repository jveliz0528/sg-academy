package ar.com.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.academy.model.Teacher;

public interface ITeacherRepository extends JpaRepository<Teacher, Long>{

}

package ar.com.academy.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.academy.model.Student;
import ar.com.academy.services.impl.StudentService;

//En RestApi 
@RestController
@RequestMapping("v1/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//AddNew Student 
	@PostMapping("/addNew")
	private ResponseEntity<?> addNew(@RequestBody Student student){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
	}

	//Read an Student for id
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> readId(@PathVariable (value = "id") Long idStudent) {
		Optional<Student> Student = studentService.findById(idStudent);
		if (!Student.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(Student);
	}
	
	//Read an Student for document
	@GetMapping("findOne/{document}")
	public ResponseEntity<?> readDocument(@PathVariable (value = "document") Long document) {
		Optional<Student> Student = studentService.findByDocument(document);
		if (!Student.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(Student);

	}
	
	@GetMapping("/getAll")
	public List<Student> readAll() {
		List<Student> student = StreamSupport
				.stream(studentService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return student;
		
	}
	

	//Update an Student
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable (value = "id") Long id, @RequestBody Student studentDetails) {
		Optional<Student> student = studentService.findById(id);
		if (!student.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(studentDetails, student.get());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student.get()));
	}
		
	//Remove student for id
	@DeleteMapping (value = "/remove/{id}")
	public ResponseEntity<?> remove(@PathVariable (value = "id") Long id) {
		
		if (!studentService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		studentService.remove(id);
		return ResponseEntity.ok().build();
		
	}


}

package ar.com.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.academy.model.Teacher;
import ar.com.academy.services.impl.TeacherService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "v1/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(teacherService.finAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please try later.\"}");
		}
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(teacherService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please try later.\"}");
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Teacher teacher){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(teacherService.save(teacher));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please try later. Tecaher not save.\"}");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Teacher teacher, @PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(teacherService.update(teacher, id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please try later.\"}");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(teacherService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please try later.\"}");
		}
	}
}

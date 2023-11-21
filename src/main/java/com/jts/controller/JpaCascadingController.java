package com.jts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jts.entity.Employee;
import com.jts.service.JpaService;

@RestController
@RequestMapping("/api")
public class JpaCascadingController {

	@Autowired
	private JpaService jpaService;

	@PostMapping("/save")
	public ResponseEntity<String> save() {
		jpaService.save();
		return ResponseEntity.status(HttpStatus.OK).body("Data saved successfully");
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> update(@RequestBody Employee emp) {
		jpaService.update(emp);

		return ResponseEntity.status(HttpStatus.OK).body("Data saved successfully");
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam long id) {
		jpaService.delete(id);

		return ResponseEntity.status(HttpStatus.OK).body("Data deleted successfully");
	}
}

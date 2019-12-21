package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.revature.beans.Form;
import com.revature.services.FormService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/form")
public class FormController {
	
	@Autowired
	private FormService fs;

	@GetMapping
	public ResponseEntity<Set<Form>> getForms() {
		return ResponseEntity.ok(fs.getForms());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Form> getForm(@PathVariable Integer id) {
		Form f = fs.getFormById(id);
		if (f == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(f);
	}

	@PostMapping
	public ResponseEntity<Form> addForm(@RequestBody Form f) {
		System.out.println(f);
		fs.addForm(f);
		return ResponseEntity.status(201).body(f);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Form> updateForm(@PathVariable Integer id, @RequestBody Form f) {
		if (fs.getFormById(id) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(fs.updateForm(f));
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deleteForm(@PathVariable Integer id) {
		if (fs.getFormById(id) == null)
			return ResponseEntity.status(405).build();
		fs.deleteForm(fs.getFormById(id));
		return ResponseEntity.noContent().build();
	}
}

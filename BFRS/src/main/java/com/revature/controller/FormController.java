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
import com.revature.data.FormDAO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/form")
public class FormController {
	@Autowired
	private FormDAO fd;

	@GetMapping
	public ResponseEntity<Set<Form>> getForms() {
		return ResponseEntity.ok(fd.getForms());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Form> getForm(@PathVariable Integer id) {
		Form f = fd.getForm(id);
		if (f == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(f);
	}

	@PostMapping
	public ResponseEntity<Form> addForm(@RequestBody Form f) {
		fd.addForm(f);
		return ResponseEntity.status(201).body(f);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Form> updateForm(@PathVariable Integer id, @RequestBody Form f) {
		if (fd.getForm(id) == null)
			return ResponseEntity.status(405).body(null);
		return ResponseEntity.ok(fd.updateForm(f));
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deleteForm(@PathVariable Integer id) {
		if (fd.getForm(id) == null)
			return ResponseEntity.status(405).build();
		fd.deleteForm(fd.getForm(id));
		return ResponseEntity.noContent().build();
	}
}

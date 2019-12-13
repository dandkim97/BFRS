package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Message;
import com.revature.services.MessageService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/message")
public class MessageController {
	
	@Autowired
	private MessageService ms;
	
//	@GetMapping(value="/asker")
//	public ResponseEntity<Set<Message>> getMessageForAsker(Integer id){//TODO: rework
//		return ResponseEntity.ok(ms.getMessagesByAskerId(id));
//	}
	
	@PostMapping
	public ResponseEntity<Message> addMessage(@RequestBody Message m){
		System.out.println(m);
		ms.addMessage(m);
		return ResponseEntity.status(201).body(m);
	}
	
	
}

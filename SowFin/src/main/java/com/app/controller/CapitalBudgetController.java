package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CapitalBudget;
import com.app.service.CapitalBudgetService;
import com.app.util.Response;
import com.app.util.Result;

@RestController
@RequestMapping("/api/v1")
public class CapitalBudgetController {
	@Autowired
	private CapitalBudgetService ser;

@CrossOrigin
@PostMapping(value="/capitalbudget")
public CapitalBudget createbusiness(@RequestBody CapitalBudget cap) {

	CapitalBudget list=ser.addUser(cap);
	return list;

	
	  

}
@CrossOrigin
@GetMapping("/capitalbudget")
public ResponseEntity<?> get() {
	List<CapitalBudget> cap=ser.getAllUsers();
	
	return new ResponseEntity<>(new Result(new Response(0, cap,"")),HttpStatus.OK);
	 	 	 
}
/*@CrossOrigin
@GetMapping("/capitalbudgeting/{id}")
public ResponseEntity<?> getbyId(@PathVariable("id") int id) {
	
	List<CapitalBudget> cap=ser.getById(id);
	return new ResponseEntity<>(new Result(new Response(0, cap,"")),HttpStatus.OK);
	}*/

}

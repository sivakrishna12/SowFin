package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CapitalBudgeting;
import com.app.service.CapitalBudgingService;
import com.app.util.CustomErrorType;
import com.app.util.Output;
import com.app.util.Response;
import com.app.util.ResponseCode;

@RestController
@RequestMapping("/api/v1")
public class CapitalBudgingController {
@Autowired
private CapitalBudgingService service;

@CrossOrigin	 
@RequestMapping(value = "/capitalbudgeting", method = RequestMethod.POST)
public ResponseEntity<?> createCapitalBudget(@RequestBody CapitalBudgeting unit) {

	 service.addUser(unit);
	 return new ResponseEntity<>(new Output(0, new ResponseCode("ok","Created",unit.getId()),""),HttpStatus.OK);
	 
}
@CrossOrigin	
@GetMapping("/capitalbudgeting")
public  ResponseEntity<?> createCapitalBudget() {

	List<CapitalBudgeting> role=service.getAllUsers();
	return new ResponseEntity<>(new Response(0, role,""),HttpStatus.OK);
}

@CrossOrigin
@RequestMapping(value = "/capitalbudgeting/{id}", method = RequestMethod.GET)
public  ResponseEntity<?> getById(@PathVariable("id") int id) {
	List<CapitalBudgeting> role=service.getById1(id);

	return new ResponseEntity<>(new Response(0, role,""),HttpStatus.OK);
}
@CrossOrigin
@RequestMapping(value = "/capitalbudgeting/{id}", method = RequestMethod.DELETE)
public ResponseEntity<?> deleteCapitalBudget(@PathVariable("id") int id) {
    

service.deleteById(id);
   
return new ResponseEntity<>(new CustomErrorType(0,"CapitalBudgeting deleted"  ),HttpStatus.OK);
      
}
/*@CrossOrigin
@PutMapping("/capitalbudget/{id}")

public ResponseEntity<?> updateCapitalBudget(@PathVariable("id") int id, @RequestBody CapitalBudgeting user) {
   
	
	CapitalBudgeting unit = service.getById(id);

 
    return new ResponseEntity<>(new Output(1, new ResponseCode("ok","updated with id " + id),""),HttpStatus.OK);
    }*/
	

}

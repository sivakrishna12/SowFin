package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.BusinessUnit;
import com.app.model.Projects;
import com.app.model.ValuationMethod;
import com.app.service.ProjectService;
import com.app.util.CustomErrorType;
import com.app.util.Output;
import com.app.util.Response;
import com.app.util.ResponseCode;
import com.app.util.Result;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {
@Autowired
private ProjectService service;

@CrossOrigin	 
@RequestMapping(value = "/projects", method = RequestMethod.POST)
public  ResponseEntity<?> createproject(@RequestBody Projects unit) {			 
BusinessUnit b=unit.getBusiness_unit();
ValuationMethod v=unit.getValuation_method();
unit.setBusiness_unit(new BusinessUnit(b.getId()));
unit.setValuation_method(new ValuationMethod(v.getId()));
	 service.addUser(unit);
	return new ResponseEntity<>(new Output(0, new ResponseCode("ok","Project Created",unit.getId()),""),HttpStatus.OK);
}
@CrossOrigin
@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
public  ResponseEntity<?> getById(@PathVariable("id") int id) {
	if (!(service.UserExists(id))) {
      
		return new ResponseEntity<>(new Output(1,"Project not found."),HttpStatus.NOT_FOUND);
		}
	List<Projects> role=service.getById1(id);
	
	return new ResponseEntity<>(new Result(new Response(0, role,"")),HttpStatus.OK);
}
@CrossOrigin
@GetMapping("/projects")
public ResponseEntity<?> getAllProjects() {
	if (!(service.getAllExists())) {
	     
		return new ResponseEntity<>(new Output(1,"No data found."),HttpStatus.NOT_FOUND);
	}
	List<Projects> list = service.getAllUsers();
	 service.getAllUsers();
	return new ResponseEntity<>(new Result(new Response(0, list,"")),HttpStatus.OK);
	 
}
@CrossOrigin
@RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
public ResponseEntity<?> deleteproject(@PathVariable("id") int id) {
    
	if (!(service.UserExists(id))) {
	     
      
		
	return new ResponseEntity<>(new Output(1,"Project not found."),HttpStatus.NOT_FOUND);
	}
service.delete(id);
   
 
return new ResponseEntity<>(new CustomErrorType(0,"Project deleted"
        ),HttpStatus.OK);
}
@CrossOrigin

@PutMapping("/projects/{id}")

public ResponseEntity<?> updateproject(@PathVariable("id") int id, @RequestBody Projects user) {
	 
		if (!(service.UserExists(id))) {
		     
	      
		return new ResponseEntity<>(new Output(1,"Project not found."),HttpStatus.NOT_FOUND);
		}
	Projects unit = service.getById(id);
	//unit.setCode(user.getCode());
	unit.setName(user.getName());
	unit.setDescription(user.getDescription());
	unit.setBusiness_unit(new BusinessUnit(user.getBusiness_unit().getId()));
	unit.setValuation_method(new ValuationMethod(user.getValuation_method().getId(),""));
    service.addUser(unit);
    return new ResponseEntity<>(new CustomErrorType(0,"Project updated"
            ),HttpStatus.OK);
}
@CrossOrigin

@GetMapping("/businessunit/{id}/projects")

public ResponseEntity<?> getBusinessUnitprojects(@PathVariable("id") int id) {
	
	if (!(service.getallProjectsBybuIdExists(id))) {
	     
	      
		return new ResponseEntity<>(new Output(1,"Project not found."),HttpStatus.NOT_FOUND);
		}
	List<Projects> role=service.getallProjectsBybuId(id);

	return new ResponseEntity<>(new Response(0, role,""),HttpStatus.OK);
}
@CrossOrigin

@GetMapping("/businessunit/{bid}/projects/{id}")

public ResponseEntity<?> getBusinessUnitprojectsbyId(@PathVariable("bid") int bid,@PathVariable("id") int id) {
	if (!(service.getallProjectsBybuIdExists(bid))) {
	     
	      
		return new ResponseEntity<>(new Output(1,"BusinessUnit not found."),HttpStatus.NOT_FOUND);
		}
	if (!(service.UserExists(id))) {
	     
	      
		return new ResponseEntity<>(new Output(1,"Project not found."),HttpStatus.NOT_FOUND);
		}
	if (!(service.getBybIdandidExists(bid, id))) {
	     
	      
		return new ResponseEntity<>(new Output(1,"Not found."),HttpStatus.NOT_FOUND);
		}
	List<Projects> role=service.getBybIdandid(bid, id);

	return new ResponseEntity<>(new Response(0, role,""),HttpStatus.OK);
}

}

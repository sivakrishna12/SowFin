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
import com.app.model.Roles;
import com.app.service.RoleService;
import com.app.util.CustomErrorType;
import com.app.util.Output;
import com.app.util.Response;
import com.app.util.ResponseCode;
import com.app.util.Result;

@RestController
@RequestMapping("/api/v1")
public class RoleController {

	@Autowired
	private RoleService service;
	@CrossOrigin	 
	@RequestMapping(value = "/roles/role/{role}", method = RequestMethod.GET)
	public ResponseEntity<?> createRoles(@PathVariable("role") String role) {
		if (service.RoleExists(role)) {
			
		 return new ResponseEntity<>(new CustomErrorType(1,"role exist"
	            ),HttpStatus.OK);
		}else {
			 return new ResponseEntity<>(new CustomErrorType(0,"ok"
			            ),HttpStatus.OK);
		}
	
	//return new ResponseEntity<>(new Output(0, new ResponseCode("ok","Role Created",roles.getId()),""),HttpStatus.OK);
	}
	@CrossOrigin	 
	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public ResponseEntity<?> createRoles(@RequestBody Roles roles) {
		if (service.RoleExists(roles.getRole())) {
			
		 return new ResponseEntity<>(new CustomErrorType(" role exist"
	            ),HttpStatus.OK);
		}
		roles.setActive("1");
	roles.setDeleted("0");
	service.addRoles(roles);
	return new ResponseEntity<>(new Output(0, new ResponseCode("ok","Role Created",roles.getId()),""),HttpStatus.OK);
	}
	@CrossOrigin	 
	@RequestMapping(value = "/roles/id/{id}", method = RequestMethod.GET)
	public  ResponseEntity<?> getById(@PathVariable("id") int id) {
		if (!(service.roleExist(id))) {
		     
			 return new ResponseEntity<>(new Output(1,"Role not found."),HttpStatus.NOT_FOUND);
		}
		List<Roles> role=service.findbyid1(id);

		return new ResponseEntity<>(new Result(new Response(0, role,"")),HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/roles")
	public ResponseEntity<?> getAllroles() {
		if (!(service.ActicveExist())) {
		     
			 return new ResponseEntity<>(new Output(1,"Not found."),HttpStatus.NOT_FOUND);
		}
		List<Roles> list = service.getActicve();
		return new ResponseEntity<>(new Result(new Response(0, list,"")),HttpStatus.OK);
		 
	}
	
	/*@CrossOrigin
	@GetMapping("/roles/all")
	public ResponseEntity<List<Roles>> getAllusers() {
		List<Roles> list = service.getAllRoles();
		return new ResponseEntity<List<Roles>>(list, HttpStatus.OK);
	}*/
	@CrossOrigin	 
	@RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRole(@PathVariable("id") int id) {
	    
		if (!(service.roleExist(id))) {
		     
			 return new ResponseEntity<>(new Output(1,"Role not found."),HttpStatus.NOT_FOUND);
		}
		Roles user=service.getActiveRole(id);
	   
	    user.setDeleted("1");
	    user.setActive("0");
	    service.addRoles(user);
	    return new ResponseEntity<>(new CustomErrorType(0,"Role deleted"
	            ),HttpStatus.OK);
    }
	@CrossOrigin
	@PutMapping("/roles/{id}")

	public ResponseEntity<?> updateRole(@PathVariable("id") int id, @RequestBody Roles user) {
		if (!(service.roleExist(id))) {
			 return new ResponseEntity<>(new Output(1,"Role not found."),HttpStatus.NOT_FOUND);
		}
		Roles role=service.getActiveRole(id);

	    
	   role.setActive("1");
	   role.setRole(user.getRole());
	    service.editUser(role);
	    return new ResponseEntity<>(new CustomErrorType(0,"Role updated"
	            ),HttpStatus.OK);
	}

	}
		
	


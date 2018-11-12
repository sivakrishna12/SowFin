package com.app.controller;



import java.util.Date;
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
import com.app.model.Users;
import com.app.service.UserService;
import com.app.util.CustomErrorType;
import com.app.util.Output;
import com.app.util.Response;
import com.app.util.ResponseCode;
import com.app.util.Result;
@RestController
@RequestMapping("/api/v1")
public class UserController {
@Autowired
private UserService service;

@CrossOrigin
@RequestMapping(value = "/user/username/{username}", method = RequestMethod.GET)
public ResponseEntity<?> createUser1(@PathVariable("username")String mail) {
	String s=mail.toLowerCase();
	if (!(service.UserExists(s,s))) {
		return new ResponseEntity<>(new CustomErrorType(0,"ok"
	            ),HttpStatus.OK);
   }
	
	 return new ResponseEntity<>(new CustomErrorType(1,"user exist"
            ),HttpStatus.OK);
	 
}

@CrossOrigin	 
@RequestMapping(value = "/user", method = RequestMethod.POST)
public ResponseEntity<?> createUser(@RequestBody Users user) {
	
Roles r=user.getRole();
		user.setActive("1");
		user.setDeleted("0");
		user.setCreated_at(new Date());
user.setUsername(user.getUsername().toLowerCase());
user.setEmail(user.getEmail().toLowerCase());
	user.setRole(new Roles(r.getId(),"","",""));
	service.addUser(user);
   
	return new ResponseEntity<>(new Output(0, new ResponseCode("ok","User Created",user.getId()),""),HttpStatus.OK);
	}
/*@CrossOrigin
@GetMapping("/user/all")
public ResponseEntity<List<Users>> getAllusers() {
	List<Users> list = service.getAllUsers();
	return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
}
*/
@CrossOrigin
@GetMapping("/user")
public ResponseEntity<?>  getactiveUsers() {
	if (!(service.ActiveUsersExist())) {
	     
		return new ResponseEntity<>(new Output(1,"not found."),HttpStatus.NOT_FOUND);
	}
	List<Users> list = service.getActiveUsers();
	return new ResponseEntity<>(new Result(new Response(0, list,"")),HttpStatus.OK);
	
}
@CrossOrigin
@GetMapping("/user/id/{id}")
public ResponseEntity<?> getactiveUsersById(@PathVariable("id") int id) {
	if (!(service.userExist(id))) {
	     
		return new ResponseEntity<>(new Output(1,"User not found."),HttpStatus.NOT_FOUND);
	}
    
	List<Users> list = service.getById(id);
	return new ResponseEntity<>(new Result(new Response(0, list,"")),HttpStatus.OK);
}
@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
	if (!(service.userExist(id))) {
	     
		return new ResponseEntity<>(new Output(1,"User not found."),HttpStatus.NOT_FOUND);
	}
    
    Users currentUser = service.getActiveBusiness(id);
    
   
   currentUser.setActive("0");
   currentUser.setDeleted("1");
    service.editUser(currentUser);
    return new ResponseEntity<>(new CustomErrorType(0,"User deleted"
            ),HttpStatus.OK);
    }

@CrossOrigin
@PutMapping("/user/{id}")

public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Users user) {
   
	
	  if (!(service.userExist(id))) {
		     
		  return new ResponseEntity<>(new Output(1,"User not found."),HttpStatus.NOT_FOUND);
		}
    Users currentUser = service.getActiveBusiness(id);
 
  
 //   Roles role=  currentUser.getRole();
    currentUser.setUsername(user.getUsername().toLowerCase());
    currentUser.setPassword(user.getPassword());
    currentUser.setUpdated_at(new Date());
    currentUser.setEmail(user.getEmail().toLowerCase());
currentUser.setRole(new Roles(user.getRole().getId(),"","",""));
   currentUser.getCreated_at();
   currentUser.setActive("1");
   
    service.editUser(currentUser);

    return new ResponseEntity<>(new CustomErrorType(0,"User updated"
            ),HttpStatus.OK);
}

}
		 

    


	  


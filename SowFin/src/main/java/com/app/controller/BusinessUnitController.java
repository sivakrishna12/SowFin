package com.app.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.BusinessUnit;
import com.app.service.BusinessunitService;
import com.app.util.CustomErrorType;
import com.app.util.Output;
import com.app.util.Response;
import com.app.util.ResponseCode;
import com.app.util.Result;
import com.app.util.Status;

@RestController
@RequestMapping("/api/v1")
public class BusinessUnitController {
@Autowired
	private BusinessunitService ser;

@CrossOrigin
@PostMapping(value="/businessunit")
public ResponseEntity<?> createbusiness(@RequestBody BusinessUnit cap) {
if(cap.getStatus().equalsIgnoreCase("ACTIVE")) {
cap.setStatus("1");

}else {
cap.setStatus("0");

}
ser.addUser(cap);

return new ResponseEntity<>(new Output(0, new ResponseCode("ok","BusinessUnit Created",cap.getId()),""),HttpStatus.OK);
}
@CrossOrigin
@GetMapping("/businessunit")
public ResponseEntity<?> get() {
	
	List<BusinessUnit> b=ser.getAllUsers();
	List<BusinessUnit> b1=	ser.getinactive();
	
	if (!(ser.AllUsersExist())) {
	     
		return new ResponseEntity<>(new Output(1,"BusinessUnit not found."),HttpStatus.NOT_FOUND);
	}
	 return new ResponseEntity<>(new Status(0, b,b1,""),HttpStatus.OK);
	 	 	 
}
@CrossOrigin
@GetMapping("/businessunit/{id}")
public ResponseEntity<?> getbyId(@PathVariable("id") int id) {
	if (!(ser.businessExist(id))) {
	     
		return new ResponseEntity<>(new Output(1,"BusinessUnit not found."),HttpStatus.NOT_FOUND);
	}
	List<BusinessUnit> b=ser.getById(id);
	return new ResponseEntity<>(new Result(new Response(0, b,"")),HttpStatus.OK);
	}

@CrossOrigin
@GetMapping("/businessunit/search/{name}")
public  ResponseEntity<?>Search(@PathVariable("name") String name) {
	//int i=	Integer.parseInt(name);
	List<BusinessUnit> b=null;
	boolean result=false;
	
	Pattern p=Pattern.compile("[0-9]*");
	
     // Pattern  p1 = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
result=	p.matcher(name).matches(); 

	if(result) {
		int i=	Integer.parseInt(name);	
		if (!(ser.businessExist(i))) {
		     
			return new ResponseEntity<>(new Output(1,"BusinessUnit not found."),HttpStatus.NOT_FOUND);
		}
	
	 b=ser.getById(i);
		
	}else {
		if (!(ser.serachExist(name, name))) {
		     
			return new ResponseEntity<>(new Output(1,"BusinessUnit not found."),HttpStatus.NOT_FOUND);
		}
		 b=ser.serach(name, name);
				
		 
	}/*else {
		return new ResponseEntity<>(new Output(1,"BusinessUnit not found."),HttpStatus.NOT_FOUND);
	}*/
	

	return new ResponseEntity<>(new Response(0, b,""),HttpStatus.OK);
	
	}
@CrossOrigin	 
@RequestMapping(value = "/businessunit/{id}", method = RequestMethod.DELETE)
public ResponseEntity<?> deletebusinessunit(@PathVariable("id") int id) {
	if (!(ser.businessExist(id))) {
	     
		return new ResponseEntity<>(new Output(1,"BusinessUnit not found."),HttpStatus.NOT_FOUND);
	}
try {
    ser.delete(id);
} catch (Exception e) {
	return new ResponseEntity<>(new Output(1,"Business unit is still referenced from table projects."),HttpStatus.NOT_FOUND);
	}
    return new ResponseEntity<>(new CustomErrorType(0,"Businessunit deleted"
            ),HttpStatus.OK);
}
@CrossOrigin
@PutMapping("/businessunit/{id}")

public ResponseEntity<?> updatebusiness(@PathVariable("id") int id, @RequestBody BusinessUnit user) {
   
	
	if (!(ser.businessExist(id))) {
	     
		return new ResponseEntity<>(new Output(1,"BusinessUnit not found."),HttpStatus.NOT_FOUND);
	}
	
	
 BusinessUnit bus = ser.getById1(id);
 
 
  bus.setDescription(user.getDescription());
bus.setName(user.getName());
if(user.getStatus().equalsIgnoreCase("active")) {
bus.setStatus("1");

}else {
	bus.setStatus("0");
	
}
 bus.setYearestablished(user.getYearestablished());
 
    ser.editUser(bus);
    return new ResponseEntity<>(new CustomErrorType(0,"Businessunit updated"
            ),HttpStatus.OK);
}
}
	


package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.LoginModel;
import com.app.model.Users;
import com.app.service.UserService;
import com.app.util.LoginResponseBody;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/v1")
public class LogInController {
	
	@Autowired
	private UserService service;
	//@Autowired
	//@Value("${jwt.secret}")
    private String key="mysecretkey";
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginModel log) {
	String s1=	log.getUsername().toLowerCase();
	Users s=service.getByUserNameOrMail(s1,s1);
	
	   if (!(service.UserExists(s1,s1))) {
	    	 return new ResponseEntity<>(new LoginResponseBody(false, null, "User with that name isn't exist"),
	                    HttpStatus.OK);
	    }
	   
	    if( !(s.getPassword().equals(log.getPassword()))){
	    	 return new ResponseEntity<>(new LoginResponseBody(false, null, "Wrong password"),
	                    HttpStatus.OK);
	    }


	   // login.addLogin(log);
	    String token = Jwts.builder()
	            .setSubject(log.getUsername())
	            
	            .signWith(SignatureAlgorithm.HS512, key)
	            .compact();

	    return new ResponseEntity<>(new LoginResponseBody(true, token,new LoginModel(log.getUsername(),log.getPassword()),"success"), HttpStatus.OK);
	
	
	}

}

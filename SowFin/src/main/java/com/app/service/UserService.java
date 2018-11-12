package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.model.Users;

@Service
public class UserService{
	@Autowired
	private UserRepository stu;
	
	public Users getActiveBusiness(int id) {
		//Users userInfo = new Users();
	
	
	return stu.findById1(id);
	
	}
	
	public boolean userExist(int id) {
		
		List<?> list=stu.findById(id);
	

		if(!(list.isEmpty())) {
			
			return true;
		}else {
			return false;
		}
	}
	
	public boolean UserExists(String mail,String userName){
	//	String s=	mail.toLowerCase();
		List<?> count= stu.findByUsernameOrEmail(mail, userName);
		
		if(!(count.isEmpty())) {
			
			return true;
		}else {
			return false;
		}
		
	}
	/*public boolean UserExists(int id){
		Users count=  stu.findById(id);
		
		if(!(((List<?>) count).isEmpty())) {
			
			return true;
		}else {
			return false;
		}
		
	}*/
	
	public Users getByUserNameOrMail(String userName,String emailId ) {
	//	Users userInfo = new Users();
		//String s=	emailId.toLowerCase();
		//String s=userName.toLowerCase();
	return stu.findByUsernameOrEmail1(userName, emailId);
		/*if (!list.isEmpty()) {
			
			userInfo = (Users) list.get(0);
		}
		return userInfo;*/
	}
	
	public Users addUser(Users user) {
		
		return stu.save(user);
		
	}
	
	
	public List<Users> getAllUsers() {
		
		return stu.findAll();
	}

	public void delete(int id) {
		stu.deleteById(id);
	
    }
	 @Transactional
	    public Users editUser(Users s) {
	    	/*s.setCreatedat(new Date());
	    	s.setEmail(s.getEmail());
	    	s.setId(s.getId());
	    	s.setPassword(s.getPassword());
	    	s.setUsername(s.getUsername());*/
	        return stu.saveAndFlush(s);
	    }

	public List<Users> getById(int id) {
        return stu.findById(id);
    }
	
	public List<Users> getActiveUsers() {
		//List<Users> userInfo = (List<Users>) new Users();
	
	//String active = "1";
	//List<?> list=
	
	return  stu.findByActive();
	}

	public Users getByroleId(int id) {
        return stu.findByRole(id);
    }
	

	public boolean ActiveUsersExist() {
		//Users userInfo = new Users();
	
	
		List<?> list=stu.findByActive();
	

		if(!(list.isEmpty())) {
			
			return true;
		}else {
			return false;
		}
	}


	


}

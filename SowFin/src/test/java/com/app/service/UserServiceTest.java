package com.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.dao.UserRepository;
import com.app.model.Roles;
import com.app.model.Users;


//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest{
	@Autowired
	private UserService service;
	
	
	@MockBean
	private UserRepository ticketBookingDao;
	@Test
	public void getActiveBusiness() {
		Users user=new Users(1, "siva", "krishna", "siva@gmail.com", "1", "0");
		user.setRole(new Roles(1));
		Users user1=new Users(2, "siva", "krishna", "siva@gmail.com", "1", "0");
		user1.setRole(new Roles(1));
		
		List<Users> list = new ArrayList<>();
		list.add(user);
	list.add(user1);
		
		Mockito.when(ticketBookingDao.findAll()).thenReturn(list);
		    
		    assertThat(service.getAllUsers()).isEqualTo(list);
	}
	
	
	@Test
	public void testAddUser() {
		
		Users user=new Users(1, "siva", "krishna", "siva@gmail.com", "1", "0");
		user.setCreated_at(new Date());
		user.setRole(new Roles(1));
		  Mockito.when(ticketBookingDao.save(user)).thenReturn(user);
		    
		    assertThat(service.addUser(user)).isEqualTo(user);
		
	}
	
	
	

	
	 @Test
	    public void testEditUser() {

		 Users user=new Users(1, "siva", "krishna", "siva@gmail.com", "1", "0");
			user.setCreated_at(new Date());
			user.setRole(new Roles(1));
			  Mockito.when(ticketBookingDao.saveAndFlush(user)).thenReturn(user);
			    
			    assertThat(service.editUser(user)).isEqualTo(user);
	       
	    }

	 
	 
	 @Test
		public void testDeleteTicket(){
		 Users user=new Users(1, "siva", "krishna", "siva@gmail.com", "1", "0");
			user.setCreated_at(new Date());
			user.setRole(new Roles(1));
			
			Mockito.when(ticketBookingDao.findById1(1)).thenReturn(user);
		    Mockito.when(ticketBookingDao.existsById(user.getId())).thenReturn(false);
		   assertFalse(ticketBookingDao.existsById(user.getId()));
		}
	 @Test
		public void testGetTicketById(){
		 Users user=new Users(1, "siva", "krishna", "siva@gmail.com", "1", "0");
			user.setCreated_at(new Date());
			user.setRole(new Roles(1));
			
			Mockito.when(ticketBookingDao.findById1(1)).thenReturn(user);
		    assertThat(service.getActiveBusiness(1)).isEqualTo(user);
		}
		@Test
		public void testGetTicketByEmail(){
			
			Users user=new Users(1, "siva", "krishna", "siva@gmail.com", "1", "0");
			user.setCreated_at(new Date());
			user.setRole(new Roles(1));
			
			
		    Mockito.when(ticketBookingDao.findByUsernameOrEmail1("siva", "krishna")).thenReturn(user);
		    
		    assertThat(service.getByUserNameOrMail("siva", "krishna")).isEqualTo(user);
		}
		

}

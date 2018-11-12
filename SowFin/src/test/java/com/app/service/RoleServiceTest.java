package com.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.dao.RoleRepository;
import com.app.model.Roles;

@RunWith(SpringRunner.class)
@SpringBootTest

	
	
public class RoleServiceTest {
	@Autowired
	private RoleService service;
	
	@MockBean
	private RoleRepository ticketBookingDao;

	@Test
	public void getAllRoles() {
		Roles p=new Roles(1, "admin", "1", "0");
		Roles p1=new Roles(2, "manager", "1", "0");
		List<Roles> list = new ArrayList<>();
		list.add(p);
	list.add(p1);
		
		Mockito.when(ticketBookingDao.findByActive()).thenReturn(list);
		    
		    assertThat(service.getActicve()).isEqualTo(list);
	}
	
	@Test
	public void testAddRole() {
		
		Roles p=new Roles(1, "admin", "1", "0");
		  Mockito.when(ticketBookingDao.save(p)).thenReturn(p);
		    
		    assertThat(service.addRoles(p)).isEqualTo(p);
		
	}
	
	
	

	
	 @Test
	    public void testEditUser() {

		 Roles p=new Roles(1, "admin", "1", "0");
			  Mockito.when(ticketBookingDao.saveAndFlush(p)).thenReturn(p);
			    
			    assertThat(service.editUser(p)).isEqualTo(p);
	       
	    }

	
	
	 @Test
		public void testGetRoleById(){
		 Roles p=new Roles(1, "admin", "1", "0");
			
			Mockito.when(ticketBookingDao.findById(1)).thenReturn(p);
		    assertThat(service.getActiveRole(1)).isEqualTo(p);
		}
	 @Test
		public void testGetRoleById1(){
		 Roles p=new Roles(1, "admin", "1", "0");
		 Roles p1=new Roles(1, "admin", "1", "0");
		 ArrayList<Roles> role=new ArrayList<>();
		 role.add(p);
		 role.add(p1);
			Mockito.when(ticketBookingDao.findById1(1)).thenReturn(role);
		    assertThat(service.findbyid1(1)).isEqualTo(role);
		}
	
}

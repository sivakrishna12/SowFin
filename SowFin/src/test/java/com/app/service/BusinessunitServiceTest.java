package com.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.dao.BusinessunitRepository;
import com.app.model.BusinessUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessunitServiceTest {
	@Autowired
	private BusinessunitService service;
	@MockBean
	private BusinessunitRepository ticketBookingDao;
	@Test
	public void getAllBusiness() {
		BusinessUnit user=new BusinessUnit(1, "businessunit", "hello", "2018", "1");
		BusinessUnit user1=new BusinessUnit(2, "businessunit", "hello", "2018", "1");
		List<BusinessUnit> list = new ArrayList<>();
		list.add(user);
	list.add(user1);
		
		Mockito.when(ticketBookingDao.findAll1()).thenReturn(list);
		    
		    assertThat(service.getAllUsers()).isEqualTo(list);
	}
	
	@Test
	public void testSearch() {
		BusinessUnit user=new BusinessUnit(1, "businessunit", "hello", "2018", "1");
		BusinessUnit user1=new BusinessUnit(2, "businessunit", "hello", "2018", "1");
		List<BusinessUnit> list = new ArrayList<>();
		list.add(user);
	list.add(user1);
		
		Mockito.when(ticketBookingDao.findByNameOrDescriptionContainingIgnoreCase("businessunit", "hello")).thenReturn(list);
		    
		    assertThat(service.serach("businessunit", "hello")).isEqualTo(list);
	}
	
		
	@Test
	public void testAddUser() {
		
		BusinessUnit user=new BusinessUnit(1, "businessunit", "hello", "2018", "1");
		  Mockito.when(ticketBookingDao.save(user)).thenReturn(user);
		    
		    assertThat(service.addUser(user)).isEqualTo(user);
		
	}
	
	
	

	
	 @Test
	    public void testEditUser() {

		 BusinessUnit user=new BusinessUnit(1, "businessunit", "hello", "2018", "1");
			  Mockito.when(ticketBookingDao.saveAndFlush(user)).thenReturn(user);
			    
			    assertThat(service.editUser(user)).isEqualTo(user);
	       
	    }
 
	 @Test
		public void testDeleteTicket(){
		 BusinessUnit user=new BusinessUnit(1, "businessunit", "hello", "2018", "1");
			
			Mockito.when(ticketBookingDao.findById(1)).thenReturn(user);
		    Mockito.when(ticketBookingDao.existsById(user.getId())).thenReturn(false);
		   assertFalse(ticketBookingDao.existsById(user.getId()));
		}
	 @Test
		public void testGetTicketById(){
		 BusinessUnit user=new BusinessUnit(1, "businessunit", "hello", "2018", "1");
			
			Mockito.when(ticketBookingDao.findById(1)).thenReturn(user);
		    assertThat(service.getById1(1)).isEqualTo(user);
		}
	 @Test
		public void testGetTicketById1(){
		 BusinessUnit user=new BusinessUnit(1, "businessunit", "hello", "2018", "1");
			BusinessUnit user1=new BusinessUnit(2, "businessunit", "hello", "2018", "1");
			List<BusinessUnit> list = new ArrayList<>();
			list.add(user);
		list.add(user1);
			
			Mockito.when(ticketBookingDao.findById1(1)).thenReturn(list);
		    assertThat(service.getById(1)).isEqualTo(list);
		}
	
}

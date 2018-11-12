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

import com.app.dao.ProjectRepository;
import com.app.model.BusinessUnit;
import com.app.model.Projects;
import com.app.model.ValuationMethod;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {
	
	@Autowired
	private ProjectService service;
	
	@MockBean
	private ProjectRepository ticketBookingDao;
	
	@Test
	public void getAllBusiness() {
		Projects p=new Projects(1, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
		Projects p1=new Projects(2, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
		List<Projects> list = new ArrayList<>();
		list.add(p);
	    list.add(p1);
		
		Mockito.when(ticketBookingDao.findAll()).thenReturn(list);
		    
		    assertThat(service.getAllUsers()).isEqualTo(list);
	}
	
	@Test
	public void testAddUser() {
		
		Projects p=new Projects(1, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
		  Mockito.when(ticketBookingDao.save(p)).thenReturn(p);
		    
		    assertThat(service.addUser(p)).isEqualTo(p);
		
	}
	
	
	

	
	 @Test
	    public void testEditUser() {

		 Projects p=new Projects(1, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
			  Mockito.when(ticketBookingDao.saveAndFlush(p)).thenReturn(p);
			    
			    assertThat(service.editUser(p)).isEqualTo(p);
	       
	    }

	
	 
	 @Test
		public void testDeleteTicket(){
		 Projects p=new Projects(1, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
			
			Mockito.when(ticketBookingDao.findById(1)).thenReturn(p);
		    Mockito.when(ticketBookingDao.existsById(p.getId())).thenReturn(false);
		   assertFalse(ticketBookingDao.existsById(p.getId()));
		}
	 @Test
		public void testGetProjectById(){
		 Projects p=new Projects(1, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
			
			Mockito.when(ticketBookingDao.findById(1)).thenReturn(p);
		    assertThat(service.getById(1)).isEqualTo(p);
		}
	 @Test
		public void testGetProjectById1(){
		 Projects p=new Projects(1, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
		 Projects p1=new Projects(2, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
		 List<Projects> list = new ArrayList<>();
			list.add(p);
		    list.add(p1);
			Mockito.when(ticketBookingDao.findById1(1)).thenReturn(list);
		    assertThat(service.getById1(1)).isEqualTo(list);
		}
	 @Test
		public void testGetProjectByBusinessId(){
		 Projects p=new Projects(1, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
		 Projects p1=new Projects(2, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
		 List<Projects> list = new ArrayList<>();
			list.add(p);
		    list.add(p1);
			Mockito.when(ticketBookingDao.findbyBusinessUnitId(1)).thenReturn(list);
		    assertThat(service.getallProjectsBybuId(1)).isEqualTo(list);
		}
		
	 @Test
		public void testGetProjectByBusinessIdAndProjectId(){
		 Projects p=new Projects(1, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
		 Projects p1=new Projects(2, "projects", "hello", new BusinessUnit(1), new ValuationMethod(1));
		 List<Projects> list = new ArrayList<>();
			list.add(p);
		    list.add(p1);
			Mockito.when(ticketBookingDao.findBybIdandid(1, 1)).thenReturn(list);
		    assertThat(service.getBybIdandid(1, 1)).isEqualTo(list);
		}
		
}

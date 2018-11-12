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

import com.app.dao.ValuationRepository;
import com.app.model.ValuationMethod;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValuationServiceTest {

	@Autowired
	private ValuationService service;
	
	@MockBean
	private ValuationRepository ticketBookingDao;

	
	@Test
	public void testAllValuationMethods() {
		ValuationMethod v=new ValuationMethod(1, "valuation");
		ValuationMethod v1=new ValuationMethod(2, "valuationMethod");
		List<ValuationMethod> list = new ArrayList<>();
		list.add(v);
	    list.add(v1);
		
		Mockito.when(ticketBookingDao.findAll()).thenReturn(list);
		    
		    assertThat(service.getAllUsers()).isEqualTo(list);
	}
	
	
	
	 @Test
		public void testGetTicketById(){
		 ValuationMethod v=new ValuationMethod(1, "valuation");
		
			Mockito.when(ticketBookingDao.findById(1)).thenReturn(v);
		    assertThat(service.getById(1)).isEqualTo(v);
		}
		

}

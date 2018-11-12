package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ValuationMethod;
import com.app.service.ValuationService;
import com.app.util.Output;
import com.app.util.Response;
import com.app.util.Result;

@RestController
@RequestMapping("/api/v1")
public class ValuationController {
@Autowired
private ValuationService service;	
		
		@CrossOrigin	 
		@RequestMapping(value = "/valuationtechnique", method = RequestMethod.POST)
		public void createunit(@RequestBody ValuationMethod unit) {
		/*	ValuationMethod v1=new ValuationMethod(4,"Valuation Technique: DCF (Discounted Cash Flow) using WACC (Weighted Average Cost of Capital)\r\n" + 
					"Leverage Policy: Constant Debt-Equity ratio - Same as Firm's Target Leverage Ratio");
			ValuationMethod v2=new ValuationMethod();
			ValuationMethod v3=new ValuationMethod();
			ValuationMethod v4=new ValuationMethod();
			ValuationMethod v5=new ValuationMethod();
			ValuationMethod v6=new ValuationMethod();
			//v1.setName("Valuation Technique: DCF (Discounted Cash Flow) using WACC (Weighted Average Cost of Capital)\r\n" + 
			//		"Leverage Policy: Constant Debt-Equity ratio - Same as Firm's Target Leverage Ratio");
		 
		v2.setName("Valuation Technique: DCF (Discounted Cash Flow) using APV (Adjusted Present Value)\r\n" + 
				"Leverage Policy: Constant Debt-Equity ratio - Same as Firm's Target Leverage Ratio");
		v3.setName("Valuation Technique: FTE (Flow-to-Equity) using Cost of Equity Method\r\n" + 
				"Leverage Policy: Constant Debt-Equity ratio - Same as Firm's Target Leverage Ratio");
		v4.setName("Valuation Technique: DCF (Discounted Cash Flow) using Project Based Cost of Capital\r\n" + 
				"Leverage Policy: Constant Debt-Equity ratio (Target Leverage Ratio) - Different from Rest of the Firm");
		v5.setName("Valuation Technique: DCF (Discounted Cash Flow) using APV (Adjusted Present Value)\r\n" + 
				"Leverage Policy: Constant Debt-Equity ratio - Constant Interest Coverage Ratio (Fraction of its FCF)");
		v6.setName("Valuation Technique: DCF (Discounted Cash Flow) using APV (Adjusted Present Value)\r\n" + 
				"Leverage Policy: Predetermined Debt Levels (According to a Fixed Schedule)");
		service.addUser(v1);
		service.addUser(v2);
		service.addUser(v3);
		service.addUser(v4);
		service.addUser(v5);
		service.addUser(v6);*/
			service.addUser(unit);
		}
		
		@RequestMapping(value = "/valuationtechnique/{id}", method = RequestMethod.GET)
		public  ResponseEntity<?> getById(@PathVariable("id") int id) {
			if (!(service.getById1Exist(id))) {
			     
				return new ResponseEntity<>(new Output(1,"not found."),HttpStatus.NOT_FOUND);
			}
			List<ValuationMethod> role=service.getById1(id);

	//return new ResponseEntity<ValuationMethod>(role, HttpStatus.OK);
			return new ResponseEntity<>(new Result(new Response(0, role,"")),HttpStatus.OK);
		}
		@CrossOrigin
		@GetMapping("/valuationtechnique")
		public ResponseEntity<?> getAllunits() {
			if (!(service.AllUsersExist())) {
			     
				return new ResponseEntity<>(new Output(1,"not found."),HttpStatus.NOT_FOUND);
			}
			List<ValuationMethod> list = service.getAllUsers();
			return new ResponseEntity<>(new Result(new Response(0, list,"")),HttpStatus.OK);
		}
		
}
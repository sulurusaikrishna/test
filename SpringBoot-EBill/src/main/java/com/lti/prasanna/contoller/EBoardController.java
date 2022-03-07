package com.lti.prasanna.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.prasanna.entity.EBoard;
import com.lti.prasanna.exception.ResourceNotFoundException;
import com.lti.prasanna.service.EBoardService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ebill/")
public class EBoardController {


	@Autowired
	private EBoardService service;
	
	@GetMapping("/bills")
	public List<Integer> getAllBills() {
		return service.getAllBills();
	}

	@GetMapping("/name")
	public Set<String> getAllNames() {
		return service.getAllNames();
	}
	
	
	/*
	 * @GetMapping("/name1") public Set<String> getAllNames1() { return
	 * service.getAllNames(); }
	 */
	 
	@GetMapping("/allbills")
	public List<EBoard> getAllBillsInfo() {
		return service.getAllBillsInfo();
	}
	@GetMapping("/bills/{id}")
	public ResponseEntity<EBoard> getBill(@PathVariable int id) {
		EBoard eBoard;

		try {
			eBoard=service.getBill(id);

		}catch(ResourceNotFoundException rs) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(eBoard);
	}



	@GetMapping("/bills/name/{name}") 
	public List<EBoard> getBillsByName(@PathVariable String name) 
	{
		List<EBoard> billsList=new ArrayList<EBoard>();

		try { 
			billsList=service.getBillsByName(name);

		}catch(ResourceNotFoundException rs) { 
			System.out.println(" resource Not found");
		}

		return billsList; 
	}

	@PostMapping("/bills")
	public EBoard addBill(@Valid @RequestBody EBoard bill) {
		return service.addBill(bill);
	}
	
	/*
	 * @PostMapping("/bills1") public EBoard addBill1(@Valid @RequestBody EBoard
	 * bill) { return service.addBill(bill); }
	 */
	
	@PutMapping("/bills/{id}")
	public ResponseEntity<EBoard> updateBill(@Valid @RequestBody EBoard bill, @PathVariable int id) {

		EBoard updateBill=null;

		try {
			updateBill=service.getBill(id);
			updateBill.setName(bill.getName());
			updateBill.setUnitsConsumed(bill.getUnitsConsumed());;
			updateBill.setBillAmount(bill.getBillAmount());;
			service.updateBill(updateBill);
		}catch(ResourceNotFoundException rs) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(updateBill);
	}

	@DeleteMapping("/bills/{id}")
	public ResponseEntity<String> deleteBill(@PathVariable int id) {

		EBoard toDeletebill = null;

		try {
			toDeletebill=service.getBill(id);
			service.deleteBill(toDeletebill);

		}catch(ResourceNotFoundException rs) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok("Bill deleted successfully with id =" + id);
	}
	
}

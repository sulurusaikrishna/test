package com.lti.prasanna.service;

import java.util.List;
import java.util.Set;

import com.lti.prasanna.entity.EBoard;
import com.lti.prasanna.exception.ResourceNotFoundException;

public interface EBoardService {


	public List<Integer> getAllBills() ;
	public Set<String> getAllNames() ;
	
	public List<EBoard> getAllBillsInfo() ;
	
	public EBoard getBill(int id) throws ResourceNotFoundException;
	
	public List<EBoard> getBillsByName( String name) throws ResourceNotFoundException;
	
	public EBoard addBill(EBoard bill) ;
	
	public EBoard updateBill(EBoard bill);
	
	public void deleteBill(EBoard bill);
		
	
	
	
}

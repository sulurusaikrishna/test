package com.lti.prasanna.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.prasanna.entity.EBoard;
import com.lti.prasanna.exception.ResourceNotFoundException;
import com.lti.prasanna.repository.EBoardRepository;
@Service
public class EBoardServiceIMPL implements EBoardService{


	@Autowired
	EBoardRepository dao;

	//Finding all the bills customer ID
	@Override
	public List<Integer> getAllBills() {
		List<Integer> billList= new ArrayList<Integer>();
		List<EBoard> bills= new ArrayList<EBoard>();

		//get all list
		bills=dao.findAll();

		//printing list of all entries
		System.out.println("=========== printing list of all enteries ===========");
		System.out.println(" Bills List "+bills);

		//populating id's list of all entries
		billList=bills.stream().map(bill -> bill.getId()).collect(Collectors.toList());

		System.out.println("=========== populating id's list of all entries ===========");
		System.out.println(" Bills id's List "+billList);


		//returning the list of customer id's
		return billList;
	}

	@Override
	public Set<String> getAllNames(){
		List<String> nameList= new ArrayList<String>();
		List<EBoard> bills= new ArrayList<EBoard>();

		//set to get the customer names list
		Set<String> set=new HashSet<String>();

		//get all list
		bills=dao.findAll();

		//printing list of all entered
		System.out.println("=========== printing list of all entries ===========");
		System.out.println(" Bills List "+bills);

		//populating name's list of all entries
		nameList=bills.stream().map(bill -> bill.getName()).collect(Collectors.toList());
		System.out.println("=========== populating name's list of all entries ===========");
		System.out.println(" Bills id's List "+nameList);


		for (String name : nameList) 
			set.add(name.toUpperCase());

		return set;
	}
	@Override
	public List<EBoard> getAllBillsInfo(){

		List<EBoard> bills= new ArrayList<EBoard>();
		//get all list
		bills=dao.findAll();

		//printing list of all entered
		System.out.println("=========== printing list of all entries ===========");
		System.out.println(" Bills List "+bills);

		return bills;
	}

	@Override
	public EBoard getBill(int id) throws ResourceNotFoundException{

		//finding bill for selected customer id
		EBoard bill=dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bill not available "+id)) ;

		//printing bill for selected customer id
		System.out.println("=========== printing bill for selected customer id===========");
		System.out.println(" Bill "+bill);

		return bill;

	}

	@Override
	public List<EBoard> getBillsByName( String name) throws ResourceNotFoundException{

		//finding bill for selected customer name
		List<EBoard> bills=dao.findEBoardByName(name);

		System.out.println("=========== printing bill for selected customer name===========");
		for(EBoard b:bills) {
			System.out.println("Printing All the Bills by Name " +b);
		}

		return bills;
	}

	@Override
	public EBoard addBill(EBoard bill) {
		//saving the created Bill
		System.out.println("=========== Saving Created bill ===========");

		return dao.save(bill);
	}

	@Override
	public EBoard updateBill(EBoard bill){
		//Updating the selected Bill
		System.out.println("=========== Updating bill ===========");

		return dao.save(bill);
	}

	@Override
	public void deleteBill(EBoard bill) {
		//Deleting the selected Bill
		System.out.println("=========== Deleting bill ===========");

		dao.delete(bill);
	}


}

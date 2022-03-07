package com.lti.prasanna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "EBoard")
@Table(name = "Electricty_Board")
@NamedQueries(value= {
        @NamedQuery(name= "findEBoard", query="from EBoard e"),
        @NamedQuery(name= "findEBoardByName", query="from EBoard e where e.name =: name")
})
public class EBoard {

	private int id;
	private String name;
	private int unitsConsumed;
	private float billAmount;


	public EBoard() {

	}
	public EBoard(int id, String name, int unitsConsumed, float billAmount) {
		this.id = id;
		this.name = name;
		this.unitsConsumed = unitsConsumed;
		this.billAmount = billAmount;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "unitsConsumed", nullable = false)
	public int getUnitsConsumed() {
		return unitsConsumed;
	}
	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}
	@Column(name = "billAmount", nullable = false)
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "EBoard [id=" + id + ", name=" + name + ", unitsConsumed=" + unitsConsumed
				+ ", billAmount=" + billAmount + "]";
	}
	


}

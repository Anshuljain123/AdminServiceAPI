package com.idexcel.AnshulJainadminservice.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Lender {
	
	@Id
	private String id;
	
	//@Indexed(unique = true, direction = IndexDirection.ASCENDING)
	private String name;
	
	private Address address;
	
	private Contact primaryContact;
	
	private String status;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    
    public Lender() {};

    public Lender(String id, String name, Address address,
            Contact primaryContact, String status, String createdBy, Date createdDate,
            String updatedBy, Date updatedDate) {
			  this.id = id;
			  this.name = name;
			  this.address = address;
			  this.primaryContact = primaryContact;
			  this.status = status;
			  this.createdBy = createdBy;
			  this.createdDate = createdDate;
			  this.updatedBy = updatedBy;
			  this.updatedDate = updatedDate;
}
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(Contact primaryContact) {
		this.primaryContact = primaryContact;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	private Date updatedDate;
}

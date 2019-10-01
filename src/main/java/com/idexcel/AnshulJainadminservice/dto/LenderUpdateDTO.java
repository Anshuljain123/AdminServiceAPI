package com.idexcel.AnshulJainadminservice.dto;

import javax.validation.constraints.NotNull;

public class LenderUpdateDTO {
	@NotNull
    private String id;
    //@NotNull    // I deleted not null to run PUT 
    private String name;
    //@NotNull
    private AddressDTO address;
   // @NotNull
    private ContactDTO primaryContact;
    //@NotNull
    private String status;

    public LenderUpdateDTO() {
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public ContactDTO getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(ContactDTO primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

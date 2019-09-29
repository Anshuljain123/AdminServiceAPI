package com.idexcel.AnshulJainadminservice.dto;

import javax.validation.constraints.NotNull;

public class LenderDTO {
	@NotNull
    private String name;
    @NotNull
    private AddressDTO address;
    @NotNull
    private ContactDTO primaryContact;

    public LenderDTO() {
    }

    public String getName() {
        return name;
    }

	public LenderDTO(@NotNull String name, @NotNull AddressDTO address, @NotNull ContactDTO primaryContact) {
		//super();
		this.name = name;
		this.address = address;
		this.primaryContact = primaryContact;
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

	public void setName(String name) {
		this.name = name;
	}
	

}

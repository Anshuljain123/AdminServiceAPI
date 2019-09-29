package com.idexcel.AnshulJainadminservice.controller;

import javax.validation.constraints.NotNull;

public class TestMapper
{
    public String name;

    public String street;
    @NotNull
    public String city;
    @NotNull
    public String state;
    @NotNull
    public String country;
    @NotNull
    public int zipCode;
  
    public String email;
    @NotNull
    public String phone;
	public TestMapper(String name, String street, @NotNull String city, @NotNull String state, @NotNull String country,
			@NotNull int zipCode, String email, @NotNull String phone) {
		super();
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.email = email;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}


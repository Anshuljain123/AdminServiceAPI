package com.idexcel.AnshulJainadminservice.dto;

import javax.validation.constraints.NotNull;

public class ContactDTO {
	 @NotNull
	    private String email;
	    @NotNull
	    private String name;
	    @NotNull
	    private String phone;

	    public ContactDTO() {
	    }

		public ContactDTO(@NotNull String email, @NotNull String name, @NotNull String phone) {
			//super();
			this.email = email;
			this.name = name;
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
		
	

}

package com.idexcel.AnshulJainadminservice.dto;

import javax.validation.constraints.NotNull;

public class LenderPatchDTO {
	@NotNull
    private String id;
    @NotNull
    private String status;
    
    public LenderPatchDTO() {
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

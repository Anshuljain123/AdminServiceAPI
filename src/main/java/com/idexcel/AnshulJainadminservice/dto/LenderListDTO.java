package com.idexcel.AnshulJainadminservice.dto;

public class LenderListDTO {
	 private String id;
	    private String name;
	    private String status;

	    public LenderListDTO() {
	    }

		public LenderListDTO(String id, String name, String status) {
			//super();
			this.id = id;
			this.name = name;
			this.status = status;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}


}

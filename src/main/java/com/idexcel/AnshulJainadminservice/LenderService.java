package com.idexcel.AnshulJainadminservice;

import java.util.List;

import com.idexcel.AnshulJainadminservice.dto.LenderListDTO;
import com.idexcel.AnshulJainadminservice.entity.Lender;

public interface LenderService {
	String addLender(Lender lender);
	List<LenderListDTO> getAllLenders();
	Lender getLenderById(String Id);
	Lender updateLenderById(String Id);
	//void deleteLenderById(String Id);
	void update(String id, Lender lender);
    void delete(String id);

}

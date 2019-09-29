package com.idexcel.AnshulJainadminservice.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idexcel.AnshulJainadminservice.LenderService;
import com.idexcel.AnshulJainadminservice.dao.LenderRepository;
import com.idexcel.AnshulJainadminservice.dto.LenderListDTO;
import com.idexcel.AnshulJainadminservice.entity.Lender;
import com.idexcel.AnshulJainadminservice.exception.LenderNotFoundException;

@Service
public class LenderServiceImpl implements LenderService{
	
	@Autowired
	private LenderRepository lenderRepo;
	
    @Autowired
    private ModelMapper modelMapper;	
	

	@Override
	public String addLender(Lender lender) {
		lender.setStatus("Active");
		lender.setCreatedBy("Anshul Jain");
		lender.setCreatedDate(Calendar.getInstance().getTime());
		lender.setUpdatedBy("Anshul Jain");
	    lender.setUpdatedDate(Calendar.getInstance().getTime());
	    Lender newLender = lenderRepo.save(lender);
	    return newLender.getId();	
	}

	@Override
	public List<LenderListDTO> getAllLenders() {
		List<Lender> lenders = lenderRepo.findAll();
		if(lenders.size() == 0)
		{
			throw new LenderNotFoundException("No Lender found in database");
		}
		return lenders.stream().map(lender -> modelMapper.map(lender, LenderListDTO.class)).collect(Collectors.toList());
	}

	@Override
	public Lender getLenderById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLenderById(String Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLenderById(String Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String id, Lender lender) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		lenderRepo.deleteById(id);

	}
	

}

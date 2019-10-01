package com.idexcel.AnshulJainadminservice.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
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
		 Optional<Lender> existing = lenderRepo.getLenderById(Id);
		 if(!existing.isPresent() || existing.get().getStatus() == "SUSPENDED" ) //without enum
	            throw new LenderNotFoundException("Lender does not exist or status is suspended!");
	        return existing.get();
		

	}

	@Override
	public Lender updateLenderById(String Id) { 
		Optional<Lender> existing = lenderRepo.findById(Id);
        if(!existing.isPresent())
            throw new LenderNotFoundException("Lender not found!");
        //return existing.get(); // what is happening here
        return existing.get();
    }
		
	

	
	@Override
	public void update(String id, Lender lender) { // 
		lender.setUpdatedDate(Calendar.getInstance().getTime());
        lender.setId(id);
        lenderRepo.save(lender);
    }
		
	

	@Override
	public void delete(String id) {
		lenderRepo.deleteById(id);

	}

//	@Override
//	public Lender updateLenderById(String Id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	

}

package com.idexcel.AnshulJainadminservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.idexcel.AnshulJainadminservice.LenderService;
import com.idexcel.AnshulJainadminservice.dto.LenderDTO;
import com.idexcel.AnshulJainadminservice.dto.LenderListDTO;
import com.idexcel.AnshulJainadminservice.entity.Lender;

@RestController
@RequestMapping(value = "anshul-api/lenders")
public class LenderController {
	
	@Autowired
    private ModelMapper modelMapper;
	
	
	@Qualifier("lenderServiceImpl")
    @Autowired
    private LenderService service;
	
	@PostMapping
	public ResponseEntity<Object> addLender(@Valid @RequestBody LenderDTO addLenderDTO, HttpServletRequest request) {
        Lender lender = modelMapper.map(addLenderDTO, Lender.class);
//		TestMapper lender = new TestMapper(addLenderDTO.getName(), 
//											addLenderDTO.getAddress().getStreet(), 
//											addLenderDTO.getAddress().getCity(), 
//											addLenderDTO.getAddress().getState(), 
//											addLenderDTO.getAddress().getCountry(), 
//											addLenderDTO.getAddress().getZipCode(), 
//											addLenderDTO.getPrimaryContact().getEmail(), 
//											addLenderDTO.getPrimaryContact().getPhone());
        String id = service.addLender(lender);
		//String id = "test";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Location", request.getRequestURL().toString() + "/" + id);
        return new ResponseEntity<>("Id: " + id, responseHeaders, HttpStatus.CREATED);
    }
	
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<LenderListDTO> getAllLenders(){

       return service.getAllLenders();

    }	
    
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value="{lenderId}")
    public void deleteLender(@PathVariable("lenderId") String lenderId){
        service.delete(lenderId);
    }

}


package com.idexcel.AnshulJainadminservice.service.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.idexcel.AnshulJainadminservice.LenderService;
import com.idexcel.AnshulJainadminservice.dao.LenderRepository;
import com.idexcel.AnshulJainadminservice.dto.LenderListDTO;
import com.idexcel.AnshulJainadminservice.entity.Address;
import com.idexcel.AnshulJainadminservice.entity.Contact;
import com.idexcel.AnshulJainadminservice.entity.Lender;
import com.idexcel.AnshulJainadminservice.exception.LenderAlreadyExistsException;
import com.idexcel.AnshulJainadminservice.exception.LenderNotFoundException;




	@RunWith(SpringRunner.class)
	public class LenderServiceImplTest {

	    @TestConfiguration
	    static class LenderServiceTestConfig{
	    	
	        @Bean
	        public LenderService getService(){
	            return new LenderServiceImpl();
	        }

	    }
	    
	    @Autowired
	    private LenderServiceImpl service;
	    
	    @MockBean
	    private ModelMapper modelMapper;

	    @MockBean
	    private LenderRepository lenderRepo;

	    private List<Lender> lenders;
	    
	    @Before
	    public void setup(){
	        Lender lender = new Lender("anshul1234", "Ricky Martin", new Address("Alpha", "Tysons", "VA", "USA", 21223 ), new Contact("Mary Jane", "mj@idexcel.net", "757-663-2122"), "ACTIVE", "Hrishi G",
	                Calendar.getInstance().getTime(), "Anshul Jain", Calendar.getInstance().getTime());

	        Lender lender2 = new Lender("anshul111", "Jack Willis", new Address("Cumming", "Ashburn", "VA", "USA", 21224 ), new Contact("Mary Louis", "ml@idexcel.net", "755-663-2122"), "SUSPENDED", "Hrishi G",
	                Calendar.getInstance().getTime(), "Anshul Jain", Calendar.getInstance().getTime());

	        Lender lender3 = new Lender("jain121", "Natalie Z", new Address("Herndon", "Ashburn", "VA", "USA", 21224 ), new Contact("Lee Louis", "ll@idexcel.net", "745-663-2122"), "ACTIVE", "Hrishi G",
	                Calendar.getInstance().getTime(), "Anshul Jain", Calendar.getInstance().getTime());


	        lenders = Arrays.asList(lender, lender2, lender3);

	        Mockito.when(lenderRepo.findAll()).thenReturn(lenders);

	        Mockito.when(lenderRepo.findById(lender.getId())).thenReturn(Optional.of(lender));

	        //to check for suspended lender
	        Mockito.when(lenderRepo.findById(lender2.getId())).thenThrow(LenderNotFoundException.class);

	        //Mockito.when(repo.findByName(lender.getName())).thenThrow(LenderAlreadyExistsException.class);

	       //Mockito.when(repo.findByName(lender3.getName())).thenReturn(null);

	        Mockito.when(lenderRepo.save(lender2)).thenReturn(lender2);



	    }


//	    @Test(expected = LenderAlreadyExistsException.class)
//	    public void create() {
//	        service.addLender(lenders.get(0));
//	    }
	
	    @Test
	    public void addLender(){
	        Assert.assertEquals("Lender created", lenders.get(1).getId(), service.addLender(lenders.get(1)));
	    }

//	    @Test
//	    public void getAll() {
//	        List<LenderListDTO> lenderList = service.getAllLenders();
//	        Assert.assertEquals("Employee list should match", lenders, lenderList);
//	    }

	    @Test
	    public void get(){
	        Lender foundLender = service.getLenderById(lenders.get(0).getId());
	        Assert.assertEquals("Lender should match", lenders.get(0).getId(), foundLender.getId());
	    }

	    @Test(expected = LenderNotFoundException.class)
	    public void ById() {
	        service.getLenderById("jhjgjg");
	    }

	    @Test(expected = LenderNotFoundException.class)
	    public void getLenderById() {
	        service.getLenderById(lenders.get(1).getId());
	    }

	    @Test(expected = LenderNotFoundException.class)
	    public void updateLender() {
	        service.updateLenderById("seseer");
	    }

	    @Test
	    public void updateLenderById(){
	        Lender foundLender = service.updateLenderById(lenders.get(0).getId());
	        Assert.assertEquals("Lender should match", lenders.get(0).getId(), foundLender.getId());
	    }

	    @Test(expected = LenderNotFoundException.class)
	    public void delete() {
	        service.delete("hhggfh");
	    }

	}
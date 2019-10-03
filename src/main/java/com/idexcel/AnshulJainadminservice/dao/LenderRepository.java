package com.idexcel.AnshulJainadminservice.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.idexcel.AnshulJainadminservice.entity.Lender;

@Repository

public interface LenderRepository extends MongoRepository<Lender, String> {

	//Optional<Lender> getLenderById(String id);

	//Optional<Lender> updateLenderById(String id);

}

package com.mmdworks.recap.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmdworks.recap.domain.Property;
import com.mmdworks.recap.domain.User;

public interface PropertyRepository extends JpaRepository<Property, Long>  {

	public List<Property> findByUser(User user);
	
	public Property findByPropertyId(long propertyId);
	
	
}

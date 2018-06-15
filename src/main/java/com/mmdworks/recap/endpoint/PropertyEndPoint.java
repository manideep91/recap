package com.mmdworks.recap.endpoint;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmdworks.recap.domain.Property;
import com.mmdworks.recap.dto.PropertyDto;
import com.mmdworks.recap.service.PropertyService;

@RestController
@RequestMapping("/property-services")
public class PropertyEndPoint {
	
	private static final Logger logger = Logger.getLogger(Property.class); 
	@Autowired
	private PropertyService propertyService;
	
	@PostMapping("/create-property")
	public  ResponseEntity<?> createProperty(@RequestBody PropertyDto property) {
		Property savedProperty =  propertyService.createProperty(property);
		return new ResponseEntity<Property>(savedProperty, HttpStatus.OK);
	}
	
	@GetMapping("/get-property-by-user/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable long userId) {
		return new ResponseEntity<List<Property>>(propertyService.getAllPropertiesOfUser(userId), HttpStatus.OK);
	}
}

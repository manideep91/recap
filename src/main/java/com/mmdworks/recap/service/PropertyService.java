package com.mmdworks.recap.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmdworks.recap.dao.MortageDetailsRepository;
import com.mmdworks.recap.dao.PropertyDocumentRepository;
import com.mmdworks.recap.dao.PropertyRepository;
import com.mmdworks.recap.dao.UserRepository;
import com.mmdworks.recap.domain.MortageDetails;
import com.mmdworks.recap.domain.Property;
import com.mmdworks.recap.domain.PropertyDocument;
import com.mmdworks.recap.domain.User;
import com.mmdworks.recap.dto.PropertyDto;
import com.mmdworks.recap.exception.CommonErrorMessages;
import com.mmdworks.recap.exception.InternalException;

@Service
public class PropertyService {

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private PropertyDocumentRepository propertyDocumentRespository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MortageDetailsRepository mortageDetailsRepository;

	@Autowired
	private ModelMapper modelMapper;

	private Property transformToEntity(PropertyDto propertyDto) {
		return modelMapper.map(propertyDto, Property.class);
	}

	@Transactional
	public Property createProperty(PropertyDto propertydto) {

		try {
			User user = userRepository.findByUserId(propertydto.getUserId());
			Property inputProperty = transformToEntity(propertydto);
			inputProperty.setUser(user);

			Property savedPropertyObject = propertyRepository.save(inputProperty);

			if (inputProperty.getPropertyDocuments() != null && inputProperty.getPropertyDocuments().size() > 0) {
				for (PropertyDocument propertyDocument : inputProperty.getPropertyDocuments()) {
					propertyDocument.setProperty(savedPropertyObject);
					propertyDocumentRespository.save(propertyDocument);
				}
			}

			if (inputProperty.getMortageDetails() != null && inputProperty.getMortageDetails().size() > 0) {
				for (MortageDetails mortageDetails : inputProperty.getMortageDetails()) {
					mortageDetails.setProperty(savedPropertyObject);
					mortageDetailsRepository.save(mortageDetails);
				}
			}

			return savedPropertyObject;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(CommonErrorMessages.INTERNAL_ERROR_MESSAGE);
		}

	}

	public List<Property> getAllPropertiesOfUser(long userId) {
		try {
			User user = userRepository.findByUserId(userId);
			List<Property> propertyList = propertyRepository.findByUser(user);
			return propertyList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(CommonErrorMessages.INTERNAL_ERROR_MESSAGE);
		}
	}

}

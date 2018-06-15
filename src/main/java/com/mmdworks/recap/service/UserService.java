package com.mmdworks.recap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmdworks.recap.dao.DeviceRepository;
import com.mmdworks.recap.dao.UserDocumentRepository;
import com.mmdworks.recap.dao.UserRepository;
import com.mmdworks.recap.domain.Device;
import com.mmdworks.recap.domain.User;
import com.mmdworks.recap.domain.UserDocument;
import com.mmdworks.recap.exception.CommonErrorMessages;
import com.mmdworks.recap.exception.InternalException;
import com.mmdworks.recap.exception.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDocumentRepository userDocumentRepository;

	@Autowired
	private DeviceRepository deviceRepository;

	@Transactional
	public User createuser(User user) {

		try {
			User savedUserObj = userRepository.save(user);
			if (user.getUserDocument() != null && user.getUserDocument().size() > 0) {
				for (UserDocument userDocument : user.getUserDocument()) {
					userDocument.setUser(savedUserObj);
					userDocumentRepository.save(userDocument);
				}
			}
			if(user.getUserDevice() != null && user.getUserDevice().size() >0) {
				for (Device device : user.getUserDevice()) {
					device.setUser(savedUserObj);
					deviceRepository.save(device);
				}
			}
			return savedUserObj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(CommonErrorMessages.INTERNAL_ERROR_MESSAGE);
		}

	}

	public List<User> getAllUsers() {
		try {
			return (List<User>) userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(CommonErrorMessages.INTERNAL_ERROR_MESSAGE);
		}

	}

	public List<User> getUserByEmail(String email) {
		List<User> userList = userRepository.findByEmail(email);
		if (userList != null && userList.size() > 0) {
			return userList;
		} else {
			StringBuilder builder = new StringBuilder(CommonErrorMessages.EMAIL_NOT_FOUND_MESSAGE + email);
			throw new UserNotFoundException(builder.toString());
		}
	}

	public User getUserById(long userId) {
		try {
			return userRepository.findByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(CommonErrorMessages.INTERNAL_ERROR_MESSAGE);
		}

	}

	public User checkUserLoginDetails(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		if (user != null) {
			return user;
		} else {
			StringBuilder builder = new StringBuilder("No User found with the");
			builder.append("User Name :");
			builder.append(email);
			builder.append(" And password :");
			builder.append(password);
			throw new UserNotFoundException(builder.toString());
		}
	}

}

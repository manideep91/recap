
package com.mmdworks.recap.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmdworks.recap.domain.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserId(long id);

	public List<User> findByEmail(String email);
	
	public User findByEmailAndPassword(String email, String password);
}

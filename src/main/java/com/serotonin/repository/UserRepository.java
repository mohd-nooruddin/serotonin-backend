package com.serotonin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serotonin.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query(value ="Select * from user_details where id=?", nativeQuery = true)
	public User findDatabyId(int id);
	
	@Query(value = "Select * from user_details where email=?", nativeQuery = true)
	public User findDataByEmail(String email);
	
	@Query(value = "Select * from user_details where email=? and password=?",nativeQuery = true)
	public User findDataByEmailandPassword(String email, String pass);
	
	@Query(value = "Select * from user_details where email=? and mobile_number=?",nativeQuery =  true)
	public List<User> findDataByEmailandMobile(String email, String mobile);
	
	@Query(value = "Select name from user_details where email=? and password=?",nativeQuery =  true)
	public List<String> getNameByEmailandPassword(String email, String pass);
	
	@Query(value = "update user_details set password=? where id=?", nativeQuery = true)
	public void updateUserPassword(String pass, int id);
	
	@Query(value = "Select * from user_details where email=? and mobile_number=?",nativeQuery =  true)
	public User findByEmailandMobile(String email , String mobile);
	
}


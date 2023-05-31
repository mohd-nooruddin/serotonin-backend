package com.serotonin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.serotonin.entity.User;
import com.serotonin.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
//	Finding All data from list 
	public List<User> getData(){
		return (List<User>) userRepository.findAll();
	}
	
//	Get data by id 
	public Optional<User> getDataById(int id){
		return userRepository.findById(id);
	}
	
//	Inserting all data through Spring jpa
	public Boolean insertData(User user) {
		userRepository.save(user);
		return true;
	}
	
//	Check Whether id exists or not
	 public Boolean checkIdExistence(int id) {
		 return userRepository.existsById(id);
	 }
	 
//	 Delete data by id
	 public Boolean deleteDataById(Integer id) {
		 if(checkIdExistence(id)) {
			 userRepository.deleteById(id);
			 return true;
		 }
		 return false;
	 }
	 
//	 Updating user by id 
	 public Boolean updateDataById(User user) {
		 if (checkIdExistence(user.getUserId())) {
			userRepository.save(user);
			return true;
		}
		 return false;
	 }
	 
	 
//	 Find by id Custom
	 public User findByIdCustom(int id) {
		 return userRepository.findDatabyId(id);
	 }
	 
//	 Fin Data by Email by Custom Query 
	 public User findByEmail(String email) {
		 return userRepository.findDataByEmail(email);
	 }
	 
//	 Find by Email and Password
	 public User findDataByEmailandPass(String email, String password) {
		 return userRepository.findDataByEmailandPassword(email, password);
	 }
	 
//	 Find by Email and Password
	 public ResponseEntity<?> findDataByEmailandPassword(String email, String password) {
		User user =  userRepository.findDataByEmailandPassword(email, password);
		if (user.getUserEmail().equals(email) && user.getUserPassword().equals(password)) {
			return ResponseEntity.ok(user);
		}
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	 }
	 
//	 Find By Email and Password
	 public List<User> findDataByEmailAndMobile(String email, String mobile) {
		 return userRepository.findDataByEmailandMobile(email, mobile);
	 }
	 
//	 Update Password by checking Mobile and Email 
	 public ResponseEntity<?> updatePassword(User user){
		 System.out.println(user);
		 for(User u : userRepository.findDataByEmailandMobile(user.getUserEmail(), user.getUserMobileNumber())) {
			 System.out.println(u);
			 if(u.getUserEmail().equals(user.getUserEmail()) && u.getUserMobileNumber().equals(user.getUserMobileNumber())) {
				 userRepository.updateUserPassword(user.getUserPassword(), u.getUserId());
				 return ResponseEntity.ok(u);
			 } 
//			 break;
		 }
		 return (ResponseEntity<?>) ResponseEntity.internalServerError();
	 }
	 
//	 Update Password by checking Mobile and Email 
	 public Boolean updatePa(User user){
		 System.out.println(user);
		 for(User u : userRepository.findDataByEmailandMobile(user.getUserEmail(), user.getUserMobileNumber())) {
			 System.out.println(u);
			 user.setUserId(u.getUserId());
			 user.setUserName(u.getUserName());
//			 u.setUserId(user.getUserId());
//			 return updateDataById(u);
		 }
		 return updateDataById(user);
	 }
	 
//	 Get name By email and Password
	 public List<String> getNameByEmailandPassword(String email, String password) {
		 return userRepository.getNameByEmailandPassword(email, password);
	 }
}

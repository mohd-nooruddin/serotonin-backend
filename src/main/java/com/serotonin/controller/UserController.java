package com.serotonin.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serotonin.entity.User;
import com.serotonin.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping (value = "/getdata", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getAllData(){
		return userService.getData();
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/getbyid/{id}", produces = {MediaType.APPLICATION_NDJSON_VALUE})
	public Optional<User> getById(@PathVariable int id){
		return userService.getDataById(id);
	}
	
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(value = "/insert", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Boolean insert(@RequestBody User user) {
		return userService.insertData(user);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/checkid/{id}")
	public Boolean checkId(@PathVariable int id) {
		return userService.checkIdExistence(id);
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping(value = "/deletebyid/{id}")
	public Boolean deleteById(@PathVariable int id) {
		return userService.deleteDataById(id);
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Boolean updateById(@RequestBody User user) {
		return userService.updateDataById(user);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/findbyid/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getDataByIdCustom(@PathVariable int id) {
		return userService.findByIdCustom(id);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/findbyemail/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getDataByEmail(@PathVariable String email) {
		return userService.findByEmail(email);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/findbyemailandpass/{email}/{password}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getDataByEmailandPassword(@PathVariable String email, @PathVariable String password) {
		return  userService.findDataByEmailandPass(email, password);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/findbyemailandpassword/{email}/{password}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getDataByEmailandPass(@PathVariable String email, @PathVariable String password) {
		return  userService.findDataByEmailandPassword(email, password);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/findbyemailandmobile/{email}/{mobile}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getDataByEmailandMobile(@PathVariable String email, @PathVariable String mobile){
		return userService.findDataByEmailAndMobile(email, mobile);
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(value = "/updatepassword", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Boolean updatePasswor(@RequestBody User user){
		return userService.updatePa(user);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/getnamebyemailandpass/{email}/{pass}")
	public List<String> getNameByEmailAndPassword(@PathVariable String email,@PathVariable String pass) {
		return userService.getNameByEmailandPassword(email, pass);
	}
}

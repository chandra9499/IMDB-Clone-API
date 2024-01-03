package com.example.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.imdb.Entity.User;
import com.example.imdb.exceptionhandling.UserNotFoundException;
import com.example.imdb.requestdto.UserRequestDto;
import com.example.imdb.responsedto.UserResponseDto;
import com.example.imdb.service.UserService;
import com.example.imdb.utility.ResponseStructure;

import javax.validation.Valid;


@RestController
public class UserController {
	
	@Autowired
	UserService is;
	
	
	
	@PostMapping("/users")   // working
	public ResponseEntity<ResponseStructure<String>> inserUser(@RequestBody @Valid UserRequestDto li)
	{
		
		 return is.insertUser(li);
		
	}
	
	@GetMapping("/users/{id}")   // working
	public ResponseEntity<ResponseStructure<UserResponseDto>> findById(@PathVariable int id) throws UserNotFoundException
	{
	
		 return is.findById(id);
		
	}

	
	@PutMapping("/users/{id}")   // working
	public ResponseEntity<ResponseStructure<UserResponseDto>> updateUser(@RequestBody @Valid UserRequestDto li,@PathVariable int id) throws UserNotFoundException
	{
		
		 return is.updateUser(li,id);
		
	}
	
	@DeleteMapping("/users/{id}")   // working
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable int id) throws UserNotFoundException
	{
		
		 return is.deleteUserById(id);
		
	}
	
	
}

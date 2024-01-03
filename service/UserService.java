package com.example.imdb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.imdb.Entity.User;
import com.example.imdb.exceptionhandling.UserNotFoundException;
import com.example.imdb.repository.UserRepository;
import com.example.imdb.requestdto.UserRequestDto;
import com.example.imdb.responsedto.UserResponseDto;
import com.example.imdb.utility.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	UserRepository ir;
	
	
	private User convertToUser(UserRequestDto userRq ,User user)
	{
	
		user.setUserName(userRq.getUserName());
		user.setDateOfBirth(userRq.getDateOfBirth());
		user.setUserEmail(userRq.getUserEmail());
		user.setUserPassword(userRq.getUserPassword());
		return user;
	}
	
	
	private UserResponseDto convertToUserRespnse (User user)
	{
		UserResponseDto ur= new UserResponseDto();
		
		ur.setUserName(user.getUserName());
		ur.setUserId(user.getUserId());
		ur.setUserEmail(user.getUserEmail());
		ur.setDateOfBirth(user.getDateOfBirth());
		return ur;
		
		
	}

	public ResponseEntity<ResponseStructure<String>> insertUser(UserRequestDto userReq) {
	
		User user = convertToUser(userReq, new User());
		ir.save(user);
		
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage(" User data saved successfully");
		rs.setData(" 1 USER ADDED  SUCCESSFULLY");
		
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.CREATED);	
	}

	public ResponseEntity<ResponseStructure<UserResponseDto>> findById(int id) throws UserNotFoundException {
		
		
	             Optional<User> id2 = ir.findById(id);
	             
	             if(id2.isPresent()) {
	            	
		                  UserResponseDto dto = convertToUserRespnse(id2.get()) ;    
	            	 
		ResponseStructure<UserResponseDto> rs = new ResponseStructure<UserResponseDto>();
		
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage(" User data fetched successfully");
		rs.setData(dto);
		
	
		return new ResponseEntity<ResponseStructure<UserResponseDto>>(rs, HttpStatus.FOUND);
	             }
	             
	             else throw new UserNotFoundException("user not found with this Id");
		
	}

	public ResponseEntity<ResponseStructure<UserResponseDto>> updateUser(UserRequestDto userReq,int id) throws UserNotFoundException {
        Optional<User> optionalUser = ir.findById(id);
        
        if(optionalUser.isPresent()) {
        	
        	User existing = optionalUser.get();
 
        User updated = convertToUser(userReq,existing);
      //  updated.setUserId(existing.getUserId()); // no need bcz i gave the existing userObject to save
            ir.save(updated);
           
ResponseStructure<UserResponseDto> rs = new ResponseStructure<>();
rs.setStatusCode(HttpStatus.FOUND.value());
rs.setMessage(" User data updated successfully");
rs.setData( convertToUserRespnse(updated));


return new ResponseEntity<ResponseStructure<UserResponseDto>>(rs, HttpStatus.FOUND);
        }
        
        else throw new UserNotFoundException("user not found with this Id");

	}

	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id) throws UserNotFoundException {
	      Optional<User> id2 = ir.findById(id);
	        
	        if(id2.isPresent()) {
	            ir.deleteById(id);
	ResponseStructure<String> rs = new ResponseStructure<>();
	rs.setStatusCode(HttpStatus.FOUND.value());
	rs.setMessage(" User data deleted successfully");
	rs.setData(" USER DELETED SUCCESSFULLY");


	return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.FOUND);
	        }
	        
	        else throw new UserNotFoundException("user not found with this Id");

	}

}

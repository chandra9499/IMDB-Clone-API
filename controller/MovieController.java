package com.example.imdb.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.imdb.Entity.Movie;
import com.example.imdb.Entity.User;
import com.example.imdb.enums.Genre;
import com.example.imdb.exceptionhandling.MovieNotFoundByGenreException;
import com.example.imdb.exceptionhandling.MovieNotFoundByNameException;
import com.example.imdb.exceptionhandling.MovieNotFoundException;
import com.example.imdb.exceptionhandling.UserNotFoundException;
import com.example.imdb.requestdto.MovieRequestDto;
import com.example.imdb.responsedto.MovieReponseDto;
import com.example.imdb.service.MovieService;
import com.example.imdb.utility.ResponseStructure;

@RestController
public class MovieController {
	
	@Autowired
	MovieService ms;
	
	
	@PostMapping("/movies")   // working
	public ResponseEntity<ResponseStructure<String>> inserMovie(@RequestBody @Valid MovieRequestDto movReq)
	{
		
		 return ms.insertMovie(movReq);
		
	}
	
	@GetMapping("/movies/{movId}")   // working
	public ResponseEntity<ResponseStructure<MovieReponseDto>> findById(@PathVariable int movId) throws MovieNotFoundException
	{
		
		 return ms.findById(movId);
		
	}
	
	@GetMapping("names/{name}/movies")   
	public ResponseEntity<ResponseStructure<List<MovieReponseDto>>> findByName(@PathVariable String movName) throws  MovieNotFoundByNameException
	{
		
		 return ms.findByName(movName);
		
	}
	
	@GetMapping("genre/{genrename}/movies")   
	public ResponseEntity<ResponseStructure<List<MovieReponseDto>>> findByGenre(@PathVariable Genre genreName) throws MovieNotFoundByGenreException
	{
		
		 return ms.findByGenre(genreName);
		
	}
	
	
	@GetMapping("/movies")   // working
	public ResponseEntity<ResponseStructure<List<MovieReponseDto>>> findAll() throws MovieNotFoundException
	{
		
		 return ms.findAll();
		
	}
	
	@PutMapping("/movies/{movId}")   // working
	public ResponseEntity<ResponseStructure<String>> updateMovie(@RequestBody MovieRequestDto movReq,@PathVariable int movId) throws MovieNotFoundException
	{
		
		 return ms.updateMovie(movReq,movId);
		
	}
	
	@DeleteMapping("/movies/{movId}")   // working
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int movId) throws MovieNotFoundException
	{
		
		 return ms.deleteById(movId);
		
	}
	
	
	}

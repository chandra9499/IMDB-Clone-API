package com.example.imdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.imdb.Entity.Review;
import com.example.imdb.exceptionhandling.MovieNotFoundException;
import com.example.imdb.exceptionhandling.ReviewNotFoundException;
import com.example.imdb.exceptionhandling.UserNotFoundException;
import com.example.imdb.requestdto.ReviewRequestDto;
import com.example.imdb.responsedto.ReviewResponseDto;
import com.example.imdb.service.ReviewService;
import com.example.imdb.utility.ResponseStructure;

import javax.validation.Valid;

@RestController
public class ReviewController {

	@Autowired
	ReviewService ms;

	@PostMapping("/movies/{movie}/users/{userid}/reviews") // working
	public ResponseEntity<ResponseStructure<String>> inserReview(@RequestBody @Valid ReviewRequestDto li,
			@PathVariable int userid, @PathVariable int movie) throws MovieNotFoundException, UserNotFoundException {
		return ms.insertReview(li, userid, movie);

	}

	
	
//	list get reviews by movie id
//	{ response revie id, message ,rating map<user></user/{userid}>options
//		
//		
//	}
	
	@GetMapping("/reviews/{id}") // working
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> findById(@PathVariable int id)
			throws ReviewNotFoundException {

		return ms.findById(id);

	}
	
	@GetMapping("/movies/{movieId}/reviews") // working
	public ResponseEntity<ResponseStructure<List<ReviewResponseDto>>> findByMovieId(@PathVariable int movieId)
			throws ReviewNotFoundException, MovieNotFoundException {

		return ms.findByMovieId(movieId);

	}

	@PutMapping("/reviews/{reviewId}") // working
	public ResponseEntity<ResponseStructure<String>> updateReview(@RequestBody @Valid ReviewRequestDto li,
			@PathVariable int reviewId) throws ReviewNotFoundException {

		return ms.updateReview(li,reviewId);

	}

	@DeleteMapping("/reviews/{id}") // working
	public ResponseEntity<ResponseStructure<String>> deleteReviewById(@PathVariable int id)
			throws ReviewNotFoundException {

		return ms.deleteReviewById(id);

	}

}

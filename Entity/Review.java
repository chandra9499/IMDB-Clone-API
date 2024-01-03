package com.example.imdb.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Component
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	private String message;
	private float rating;

	@ManyToOne
	private User userMap;

	@ManyToOne
	private Movie movieMap;




	public int getReviewId() {
		return reviewId;
	}




	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public float getRating() {
		return rating;
	}




	public void setRating(float rating) {
		this.rating = rating;
	}









	public User getUserMap() {
		return userMap;
	}




	public void setUserMap(User userMap) {
		this.userMap = userMap;
	}




	public Movie getMovieMap() {
		return movieMap;
	}




	public void setMovieMap(Movie movieMap) {
		this.movieMap = movieMap;
	}




	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", message=" + message + ", rating=" + rating + "]";
	}

}

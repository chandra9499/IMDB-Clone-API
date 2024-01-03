package com.example.imdb.requestdto;

import java.time.LocalTime;

import com.example.imdb.entity.Enums.MovieGenr;

public class MovieRequestDTO {
	private String movieName;
	private MovieGenr movieGenre;
	private String movieLanguage;
	private LocalTime movieDuration;
	private Float movieRating;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public MovieGenr getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(MovieGenr movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public LocalTime getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(LocalTime movieDuration) {
		this.movieDuration = movieDuration;
	}
	public Float getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(Float movieRating) {
		this.movieRating = movieRating;
	}
}

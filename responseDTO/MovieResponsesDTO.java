package com.example.imdb.responseDTO;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.example.imdb.entity.Enums.MovieGenr;

@Component
public class MovieResponsesDTO {
	
	private String movieName;
	private MovieGenr movieGenre;
	private String movieLanguage;
	private LocalTime movieDuration;
	
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
	
	
}

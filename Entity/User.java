package com.example.imdb.Entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;

@Component
@Entity
public class User {
	
	
		
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Id
	   private  int userId;
		

	   private  String userName;
	   private  String userEmail;
	   private  String userPassword; 
	   private LocalDate dateOfBirth;
	    
	   
		@OneToMany(mappedBy = "userMap")
		private List<Review> reviewList;
	   
	    
	   
	    public List<Review> getReviewList() {
			return reviewList; 
		}
		public void setReviewList(List<Review> reviewList) {
			this.reviewList = reviewList;
		}
		@Override
		public String toString() {
			return "User [ userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
					+ ", userPassword=" + userPassword + ", dateOfBirth=" + dateOfBirth + "]";
		}
	
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
	
    
    
	
}

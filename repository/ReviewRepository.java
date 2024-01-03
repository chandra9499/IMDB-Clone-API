package com.example.imdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.imdb.entity.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

}

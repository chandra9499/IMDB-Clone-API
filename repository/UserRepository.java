package com.example.imdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.imdb.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}

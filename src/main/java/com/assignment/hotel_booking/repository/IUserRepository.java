package com.assignment.hotel_booking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assignment.hotel_booking.document.User;

public interface IUserRepository extends MongoRepository<User, String>{

	Optional<User> findByCode(String code);
}

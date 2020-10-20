package com.assignment.hotel_booking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assignment.hotel_booking.document.Room;

public interface IRoomRepository extends MongoRepository<Room, String>{

	Optional<Room> findByCode(String code);
}

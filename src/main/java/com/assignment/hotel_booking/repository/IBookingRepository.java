package com.assignment.hotel_booking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assignment.hotel_booking.document.Booking;

public interface IBookingRepository extends MongoRepository<Booking, String>{

	Optional<Booking> findByCode(String code);
}

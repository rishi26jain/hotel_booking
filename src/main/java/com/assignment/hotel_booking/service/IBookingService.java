package com.assignment.hotel_booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.hotel_booking.dto.BookingDTO;

@Service
public interface IBookingService {

	BookingDTO addBooking(BookingDTO booking);
	
	BookingDTO updateBooking(BookingDTO booking);
	
	BookingDTO getBooking(String code);
	
	List<BookingDTO> getAllBookings();
	
	BookingDTO deleteBooking(String code);
}

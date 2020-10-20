package com.assignment.hotel_booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.hotel_booking.dto.BookingDTO;
import com.assignment.hotel_booking.service.IBookingService;

@RequestMapping(value="/v1")
@RestController
public class BookingController {

	@Autowired
	IBookingService bookingService;
	
	@PostMapping(value = "/bookings", produces = "application/json",
			consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public BookingDTO bookRoom(@RequestBody BookingDTO booking) {
		return bookingService.addBooking(booking);
	}
	
	@PutMapping(value = "/bookings/{code}", produces = "application/json",
			consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public BookingDTO updateBooking(@RequestBody BookingDTO booking, @PathVariable (value = "code") String code) {
		return bookingService.updateBooking(booking);
	}
	
	@GetMapping(value = "/bookings/{code}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public BookingDTO getBooking(@PathVariable (value = "code") String code) {
		return bookingService.getBooking(code);
	}
	
	@GetMapping(value = "/bookings", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<BookingDTO> getAllBookings() {
		return bookingService.getAllBookings();
	}
	
	@DeleteMapping(value = "/bookings/{code}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public BookingDTO deleteBooking(@PathVariable (value = "code") String code) {
		return bookingService.deleteBooking(code);
	}
}

package com.assignment.hotel_booking.converter;

import org.springframework.stereotype.Component;

import com.assignment.hotel_booking.document.Booking;
import com.assignment.hotel_booking.dto.BookingDTO;

@Component
public class BookingConverter implements IConverter<BookingDTO, Booking>{

	@Override
	public BookingDTO convert(Booking booking) {
		
		BookingDTO bookingDTO = null;
		
		if(booking != null) {
			bookingDTO = new BookingDTO();
			bookingDTO.setCode(booking.getCode());
			bookingDTO.setBookingStartDate(booking.getBookingStartDate());
			bookingDTO.setBookingEndDate(booking.getBookingEndDate());
			bookingDTO.setPrimaryUserCode(booking.getPrimaryUserCode());
			bookingDTO.setRoomsCodeList(booking.getRoomsCodeList());
			bookingDTO.setTotalAmount(booking.getTotalAmount());
		}
		
		return bookingDTO;
	}

	@Override
	public Booking convert(BookingDTO bookingDTO) {

		Booking booking = null;
		
		if(bookingDTO != null) {
			booking = new Booking();
			booking.setCode(bookingDTO.getCode());
			booking.setBookingStartDate(bookingDTO.getBookingStartDate());
			booking.setBookingEndDate(bookingDTO.getBookingEndDate());
			booking.setPrimaryUserCode(bookingDTO.getPrimaryUserCode());
			booking.setRoomsCodeList(bookingDTO.getRoomsCodeList());
			booking.setTotalAmount(bookingDTO.getTotalAmount());
		}
		
		return booking;
	}

}

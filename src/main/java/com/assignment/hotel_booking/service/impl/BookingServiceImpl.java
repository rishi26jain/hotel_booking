package com.assignment.hotel_booking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.hotel_booking.common.IConstants;
import com.assignment.hotel_booking.converter.IConverter;
import com.assignment.hotel_booking.document.Booking;
import com.assignment.hotel_booking.document.Room;
import com.assignment.hotel_booking.document.User;
import com.assignment.hotel_booking.dto.BookingDTO;
import com.assignment.hotel_booking.repository.IBookingRepository;
import com.assignment.hotel_booking.repository.IRoomRepository;
import com.assignment.hotel_booking.repository.IUserRepository;
import com.assignment.hotel_booking.service.IBookingService;

@Service
public class BookingServiceImpl implements IBookingService{

	@Autowired
	IRoomRepository roomRepo;
	
	@Autowired
	IBookingRepository bookingRepo;
	
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IConverter<BookingDTO, Booking> converter;
	
	@Override
	public BookingDTO addBooking(BookingDTO booking) {
		
		Optional<User> user = userRepo.findByCode(booking.getPrimaryUserCode());
		if(user.isPresent()) {
			if(booking.getRoomsCodeList() != null && !booking.getRoomsCodeList().isEmpty()) {
				Integer bonusPoint = user.get().getBonusPoints();
				if(bonusPoint == null) {
					bonusPoint = 0;
				}
				
				for(String roomCode : booking.getRoomsCodeList()) {
					Optional<Room> room = roomRepo.findByCode(roomCode);
					if(room.isPresent()) {
						if(room.get().getRate() >= bonusPoint) {
							room.get().setStatus(IConstants.BOOKING_STATUS_BOOKED);
							bonusPoint = bonusPoint - room.get().getRate();
						}else {
							room.get().setStatus(IConstants.BOOKING_STATUS_PENDING_APPROVAL);
						}
						roomRepo.save(room.get());
					}
				}
				user.get().setBonusPoints(bonusPoint);
				userRepo.save(user.get());
			}
		}
		
		return booking;
	}

	@Override
	public BookingDTO updateBooking(BookingDTO booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDTO getBooking(String code) {

		Optional<Booking> booking = bookingRepo.findByCode(code);
		if(booking.isPresent()) {
			return converter.convert(booking.get());
		}
		return null;
	}

	@Override
	public List<BookingDTO> getAllBookings() {
		List<BookingDTO> bookingDtoList = null;
		List<Booking> bookingList = bookingRepo.findAll();
		if(bookingList != null && !bookingList.isEmpty()) {
			bookingDtoList = new ArrayList<>();
			for(Booking booking : bookingList) {
				bookingDtoList.add(converter.convert(booking));
			}
		}
		return bookingDtoList;
	}

	@Override
	public BookingDTO deleteBooking(String code) {
		Optional<Booking> booking = bookingRepo.findByCode(code);
		if(booking.isPresent()) {
			bookingRepo.delete(booking.get());
			return converter.convert(booking.get());
		}
		return null;
	}
	
}

package com.assignment.hotel_booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.hotel_booking.dto.RoomDTO;

@Service
public interface IRoomService {

	RoomDTO addRoom(RoomDTO room);
	
	RoomDTO updateRoom(RoomDTO room);
	
	RoomDTO getRoom(String code);
	
	List<RoomDTO> getAllRooms();
	
	List<RoomDTO> getAllAvailableRooms();
	
	RoomDTO deleteRoom(String code);
}

package com.assignment.hotel_booking.converter;

import org.springframework.stereotype.Component;

import com.assignment.hotel_booking.document.Room;
import com.assignment.hotel_booking.dto.RoomDTO;

@Component
public class RoomConverter implements IConverter<RoomDTO, Room>{

	@Override
	public RoomDTO convert(Room room) {
		
		RoomDTO roomDto = null;
		
		if(room != null) {
			roomDto = new RoomDTO();
			roomDto.setCode(room.getCode());
			roomDto.setRate(room.getRate());
			roomDto.setRoomType(room.getRoomType());
			roomDto.setStatus(room.getStatus());
			roomDto.setCapacity(room.getCapacity());
			
		}
		return roomDto;
	}

	@Override
	public Room convert(RoomDTO roomDto) {
		
		Room room = null;
		
		if(roomDto != null) {
			room = new Room();
			room.setCode(roomDto.getCode());
			room.setRate(roomDto.getRate());
			room.setRoomType(roomDto.getRoomType());
			room.setStatus(roomDto.getStatus());
			room.setCapacity(roomDto.getCapacity());
		}
		return room;
	}
}

package com.assignment.hotel_booking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.hotel_booking.converter.IConverter;
import com.assignment.hotel_booking.document.Room;
import com.assignment.hotel_booking.dto.RoomDTO;
import com.assignment.hotel_booking.repository.IRoomRepository;
import com.assignment.hotel_booking.service.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService{

	@Autowired
	IRoomRepository roomRepo;
	
	@Autowired
	IConverter<RoomDTO, Room> converter;
	
	@Override
	public RoomDTO addRoom(RoomDTO room) {
		roomRepo.save(converter.convert(room));
		return room;
	}

	@Override
	public RoomDTO updateRoom(RoomDTO roomDto) {
		Optional<Room> room = roomRepo.findByCode(roomDto.getCode());
		if(room.isPresent()) {
			Room roomToUpdate = converter.convert(roomDto);
			roomToUpdate.setId(room.get().getId());
			roomRepo.save(roomToUpdate);
		}
		
		return roomDto;
	}

	@Override
	public RoomDTO getRoom(String code) {
		Optional<Room> room = roomRepo.findByCode(code);
		if(room.isPresent()) {
			return converter.convert(room.get());
		}
		return null;
	}

	@Override
	public List<RoomDTO> getAllRooms() {
		List<RoomDTO> roomDtoList = null;
		List<Room> roomList = roomRepo.findAll();
		if(roomList != null && !roomList.isEmpty()) {
			roomDtoList = new ArrayList<>();
			for(Room room : roomList) {
				roomDtoList.add(converter.convert(room));
			}
		}
		return roomDtoList;
	}

	@Override
	public RoomDTO deleteRoom(String code) {
		Optional<Room> room = roomRepo.findByCode(code);
		if(room.isPresent()) {
			roomRepo.delete(room.get());
			return converter.convert(room.get());
		}
		return null;
	}

	@Override
	public List<RoomDTO> getAllAvailableRooms() {
		List<RoomDTO> roomDtoList = null;
		List<Room> roomList = roomRepo.findAll();
		if(roomList != null && !roomList.isEmpty()) {
			roomDtoList = new ArrayList<>();
			for(Room room : roomList) {
				roomDtoList.add(converter.convert(room));
			}
		}
		//roomDtoList = roomDtoList.stream().filter(i -> !(i.getIsBooked())).collect(Collectors.toList());
		return roomDtoList;
	}

}

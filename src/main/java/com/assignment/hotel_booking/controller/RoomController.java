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

import com.assignment.hotel_booking.dto.RoomDTO;
import com.assignment.hotel_booking.service.IRoomService;

@RequestMapping(value="/v1")
@RestController
public class RoomController {
	
	@Autowired
	IRoomService roomService;
	
	@PostMapping(value = "/rooms", produces = "application/json",
			consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public RoomDTO addRoom(@RequestBody RoomDTO room) {
		return roomService.addRoom(room);
	}
	
	@PutMapping(value = "/rooms/{code}", produces = "application/json",
			consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public RoomDTO updateRoom(@RequestBody RoomDTO room, @PathVariable (value = "code") String code) {
		return roomService.updateRoom(room);
	}
	
	@GetMapping(value = "/rooms/{code}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public RoomDTO getRoom(@PathVariable (value = "code") String code) {
		return roomService.getRoom(code);
	}
	
	@GetMapping(value = "/rooms", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<RoomDTO> getAllRooms() {
		return roomService.getAllRooms();
	}
	
	@GetMapping(value = "/availableRooms", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<RoomDTO> getAllAvailableRooms() {
		return roomService.getAllRooms();
	}
	
	@DeleteMapping(value = "/rooms/{code}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public RoomDTO deleteRoom(@PathVariable (value = "code") String code) {
		return roomService.deleteRoom(code);
	}

}

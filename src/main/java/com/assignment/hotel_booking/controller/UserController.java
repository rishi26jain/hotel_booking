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

import com.assignment.hotel_booking.dto.UserDTO;
import com.assignment.hotel_booking.service.IUserService;

@RequestMapping(value="/v1")
@RestController
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping(value = "/users", produces = "application/json",
			consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO addUser(@RequestBody UserDTO user) {
		return userService.addUser(user);
	}
	
	@PutMapping(value = "/users/{code}", produces = "application/json",
			consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public UserDTO updateUser(@RequestBody UserDTO user, @PathVariable (value = "code") String code) {
		return userService.updateUser(user);
	}
	
	@GetMapping(value = "/users/{code}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public UserDTO getUser(@PathVariable (value = "code") String code) {
		return userService.getUser(code);
	}
	
	@GetMapping(value = "/users", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@DeleteMapping(value = "/users/{code}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public UserDTO deleteUser(@PathVariable (value = "code") String code) {
		return userService.deleteUser(code);
	}

}

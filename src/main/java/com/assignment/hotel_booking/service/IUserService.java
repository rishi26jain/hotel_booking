package com.assignment.hotel_booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.hotel_booking.dto.UserDTO;

@Service
public interface IUserService {

	UserDTO addUser(UserDTO user);
	
	UserDTO updateUser(UserDTO user);
	
	UserDTO getUser(String code);
	
	List<UserDTO> getAllUsers();
	
	UserDTO deleteUser(String code);
}

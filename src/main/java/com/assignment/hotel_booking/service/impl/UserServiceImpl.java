package com.assignment.hotel_booking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.hotel_booking.converter.IConverter;
import com.assignment.hotel_booking.document.User;
import com.assignment.hotel_booking.dto.UserDTO;
import com.assignment.hotel_booking.repository.IUserRepository;
import com.assignment.hotel_booking.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IConverter<UserDTO, User> converter;
	
	@Override
	public UserDTO addUser(UserDTO user) {
		userRepo.save(converter.convert(user));
		return user;
	}

	@Override
	public UserDTO updateUser(UserDTO userDto) {
		Optional<User> user = userRepo.findByCode(userDto.getCode());
		if(user.isPresent()) {
			User userToUpdate = converter.convert(userDto);
			userToUpdate.setId(user.get().getId());
			userRepo.save(userToUpdate);
		}
		
		return userDto;
	}

	@Override
	public UserDTO getUser(String code) {
		
		Optional<User> user = userRepo.findByCode(code);
		if(user.isPresent()) {
			return converter.convert(user.get());
		}
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> userDtoList = null;
		List<User> userList = userRepo.findAll();
		if(userList != null && !userList.isEmpty()) {
			userDtoList = new ArrayList<>();
			for(User user : userList) {
				userDtoList.add(converter.convert(user));
			}
		}
		return userDtoList;
	}

	@Override
	public UserDTO deleteUser(String code) {

		Optional<User> user = userRepo.findByCode(code);
		if(user.isPresent()) {
			userRepo.delete(user.get());
			return converter.convert(user.get());
		}
		return null;
	}

}

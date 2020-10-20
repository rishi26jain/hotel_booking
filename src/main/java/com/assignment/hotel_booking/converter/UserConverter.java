package com.assignment.hotel_booking.converter;

import org.springframework.stereotype.Component;

import com.assignment.hotel_booking.document.User;
import com.assignment.hotel_booking.dto.UserDTO;

@Component
public class UserConverter implements IConverter<UserDTO, User>{

	@Override
	public UserDTO convert(User user) {
		
		UserDTO userDto = null;
		if(user != null) {
			userDto = new UserDTO();
			userDto.setCode(user.getCode());
			userDto.setName(user.getName());
			userDto.setAge(user.getAge());
			userDto.setAddress(user.getAddress());
			userDto.setBonusPoints(user.getBonusPoints());
		}
		return userDto;
	}

	@Override
	public User convert(UserDTO userDto) {
		
		User user = null;
		if(userDto != null) {
			user = new User();
			user.setCode(userDto.getCode());
			user.setName(userDto.getName());
			user.setAge(userDto.getAge());
			user.setAddress(userDto.getAddress());
			user.setBonusPoints(userDto.getBonusPoints());
		}
		return user;
	}

}

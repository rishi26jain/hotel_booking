package com.assignment.hotel_booking.dto;

import java.io.Serializable;

public class RoomDTO implements Serializable, IDto{

	private static final long serialVersionUID = 5809577037669837343L;

	private String code;
	
	private String roomType;
	
	private Integer rate;
	
	private String status;
	
	private Integer capacity;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
}

package com.assignment.hotel_booking.document;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "room")
public class Room implements Serializable, IDocument{

	private static final long serialVersionUID = 5082692013029907984L;
	
	private ObjectId id;

	private String code;
	
	private String roomType;
	
	private Integer rate;
	
	private String status;
	
	private Integer capacity;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

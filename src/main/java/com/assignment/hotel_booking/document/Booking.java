package com.assignment.hotel_booking.document;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class Booking implements Serializable, IDocument{

	private static final long serialVersionUID = -1509921578856614413L;

	private ObjectId id;

	private String code;
	
	private String primaryUserCode;
	
	private List<String> roomsCodeList;
	
	private Double totalAmount;
	
	private String bookingStartDate;
	
	private String bookingEndDate;

	@Id
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

	public String getPrimaryUserCode() {
		return primaryUserCode;
	}

	public void setPrimaryUserCode(String primaryUserCode) {
		this.primaryUserCode = primaryUserCode;
	}

	public List<String> getRoomsCodeList() {
		return roomsCodeList;
	}

	public void setRoomsCodeList(List<String> roomsCodeList) {
		this.roomsCodeList = roomsCodeList;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBookingStartDate() {
		return bookingStartDate;
	}

	public void setBookingStartDate(String bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}

	public String getBookingEndDate() {
		return bookingEndDate;
	}

	public void setBookingEndDate(String bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}
	
}

package com.assignment.hotel_booking.document;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User implements Serializable, IDocument{

	private static final long serialVersionUID = -5445559158175607451L;

	private ObjectId id;
	
	private String code;
	
	private String name;
	
	private String age;
	
	private String address;
	
	private Integer bonusPoints;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(Integer bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	
}

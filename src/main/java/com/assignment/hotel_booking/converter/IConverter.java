package com.assignment.hotel_booking.converter;

import com.assignment.hotel_booking.document.IDocument;
import com.assignment.hotel_booking.dto.IDto;

public interface IConverter <K extends IDto, T extends IDocument>{

	K convert(T t);
	T convert(K k);
}

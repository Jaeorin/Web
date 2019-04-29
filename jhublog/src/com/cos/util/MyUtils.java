package com.cos.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyUtils {

	public static LocalDate StringToLocalDate(String target) {
		
		LocalDate result = LocalDate.parse(target, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		return result;
	}

}
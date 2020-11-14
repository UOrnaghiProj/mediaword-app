package com.freeinfo.mediaw.mediaworld.exception;

import java.time.LocalTime;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private LocalTime date;
	private Integer code;
	private String message;

}

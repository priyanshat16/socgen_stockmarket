package com.stock.app.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;


import org.springframework.http.HttpStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

		private static final long serialVersionUID = 7782580285420278256L;
		
	    public NotFoundException(String message) {
	        super(message);
	    }
	}


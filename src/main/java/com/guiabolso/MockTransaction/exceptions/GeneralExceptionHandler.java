package com.guiabolso.MockTransaction.exceptions;


import com.guiabolso.MockTransaction.exceptions.errors.ApiErrorDTO;
import com.guiabolso.MockTransaction.exceptions.errors.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class GeneralExceptionHandler {
	
	@Autowired
	private BusinessRuleExceptionHandler businessHandler;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ApiErrorDTO handle(Exception exception) {
		if(exception instanceof BusinessRuleException) {
			return businessHandler.handle((BusinessRuleException) exception);
		} else {
			ApiErrorDTO error = new ApiErrorDTO();
			error.setErrors(new ArrayList<>());
			error.getErrors().add(new ErrorDTO(exception));
			return error;
		}
	}
	
}

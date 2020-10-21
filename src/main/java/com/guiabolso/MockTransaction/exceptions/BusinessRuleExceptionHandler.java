package com.guiabolso.MockTransaction.exceptions;

import com.guiabolso.MockTransaction.exceptions.errors.ApiErrorDTO;
import com.guiabolso.MockTransaction.exceptions.errors.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class BusinessRuleExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BusinessRuleException.class)
	public ApiErrorDTO handle(BusinessRuleException exception) {
		ApiErrorDTO error = new ApiErrorDTO();
		error.setErrors(new ArrayList<>());
		error.getErrors().add(exception.getErrorDto());
		exception.getErrorDto();
		return error;
	}
	
	
}

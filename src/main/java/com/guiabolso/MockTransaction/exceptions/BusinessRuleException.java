package com.guiabolso.MockTransaction.exceptions;

import com.guiabolso.MockTransaction.enums.BusinessRulesEnum;
import com.guiabolso.MockTransaction.exceptions.errors.ErrorDTO;
import org.springframework.http.HttpStatus;

public class BusinessRuleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2145566446362060621L;
	
	private ErrorDTO errorDto;
	
	public BusinessRuleException(BusinessRulesEnum businessRules, Class<?> originClass) {
		this(businessRules, originClass, null, null, null);
	}
	
	public BusinessRuleException(BusinessRulesEnum businessRules, Class<?> originClass, HttpStatus httpStatus) {
		this(businessRules, originClass, null, httpStatus, null);
	}
	
	public BusinessRuleException(BusinessRulesEnum businessRules, Class<?> originClass, String detail) {
		this(businessRules, originClass, detail, null, null);
	}

	public BusinessRuleException(BusinessRulesEnum businessRules, Class<?> originClass, Object errors) {
		this(businessRules, originClass, null, null ,errors);
	}
	
	public BusinessRuleException(BusinessRulesEnum businessRules, Class<?> originClass, String detail, HttpStatus httpStatus, Object errorsDescription) {
		errorDto = new ErrorDTO(businessRules.ordinal(), originClass.getCanonicalName(), businessRules.name(), detail, httpStatus, errorsDescription);
	}

    public BusinessRuleException(ErrorDTO errorDto) {
		this.errorDto = errorDto;
    }

	public ErrorDTO getErrorDto() {
		return errorDto;
	}
}

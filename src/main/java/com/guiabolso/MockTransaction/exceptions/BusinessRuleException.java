package com.guiabolso.MockTransaction.exceptions;

import com.guiabolso.MockTransaction.enums.BusinessRulesEnum;
import com.guiabolso.MockTransaction.exceptions.errors.ErrorDTO;

public class BusinessRuleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2145566446362060621L;
	
	private ErrorDTO errorDto;

	public BusinessRuleException(BusinessRulesEnum businessRules, Class<?> originClass, String detail) {
		errorDto = new ErrorDTO(businessRules.ordinal(), originClass.getCanonicalName(), businessRules.name(), detail);
	}

    public BusinessRuleException(ErrorDTO errorDto) {
		this.errorDto = errorDto;
    }

	public ErrorDTO getErrorDto() {
		return errorDto;
	}
}

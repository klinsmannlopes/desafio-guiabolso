package com.guiabolso.MockTransaction.exceptions.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorDTO {
	
	private Integer errorCode;
	private String errorSource;
	private String errorReason;
	private String errorDetail;
	private HttpStatus httpStatus;
	private Object errorsDescription;
	
	public ErrorDTO() {
	}
	
	public ErrorDTO(Integer errorCode, String errorSource, String errorReason) {
		this(errorCode, errorSource, errorReason, null, null);
	}
	
	public ErrorDTO(Integer errorCode, String errorSource, String errorReason, String errorDetail, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.errorSource = errorSource;
		this.errorReason = errorReason;
		this.errorDetail = errorDetail;
		this.httpStatus = httpStatus;
	}

	public ErrorDTO(Integer errorCode, String errorSource, String errorReason, String errorDetail, HttpStatus httpStatus, Object errorsDescription) {
		this.errorCode = errorCode;
		this.errorSource = errorSource;
		this.errorReason = errorReason;
		this.errorDetail = errorDetail;
		this.httpStatus = httpStatus;
		this.errorsDescription = errorsDescription;
	}

	public ErrorDTO(Exception exception) {
		setErrorCode(99);
		setErrorSource(exception.getClass().getCanonicalName());
		if(exception.getMessage() != null && !exception.getMessage().trim().isEmpty())
			setErrorReason(exception.getMessage());

		StackTraceElement[] stackTrace = exception.getStackTrace();
		if(stackTrace != null && stackTrace.length > 0) {
			String reason = ""; 
			for (int i = 0; i < stackTrace.length; i++) {
				if(stackTrace[i].getClassName().contains("br.com.contasoma"))
					reason += stackTrace[i].getClassName() + " (" + stackTrace[i].getLineNumber() + ") "; 
			}
			setErrorDetail(reason.trim());
		}
	}
	
}

package com.guiabolso.MockTransaction.exceptions.errors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
	
	private Integer errorCode;
	private String errorSource;
	private String errorReason;
	private String errorDetail;
	
	public ErrorDTO(Integer errorCode, String errorSource, String errorReason, String errorDetail) {
		this.errorCode = errorCode;
		this.errorSource = errorSource;
		this.errorReason = errorReason;
		this.errorDetail = errorDetail;
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

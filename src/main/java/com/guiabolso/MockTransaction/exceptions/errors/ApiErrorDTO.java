package com.guiabolso.MockTransaction.exceptions.errors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ApiErrorDTO {

	@JsonIgnore
	private HttpStatus httpStatus;

	private List<ErrorDTO> errors;
}

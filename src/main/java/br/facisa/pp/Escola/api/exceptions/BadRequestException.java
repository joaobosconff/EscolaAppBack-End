package br.facisa.pp.Escola.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -2611143203073348440L;

    public BadRequestException(String message) {
		super(message);
    }
}

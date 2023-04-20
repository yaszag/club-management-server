package com.sportsclubmanagement.clubmanagement.exeptions;

import org.springframework.http.HttpStatus;


public class UnauthorizeddException extends ApiBaseException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UnauthorizeddException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.UNAUTHORIZED;
    }
}

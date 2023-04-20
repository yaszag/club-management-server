package com.sportsclubmanagement.clubmanagement.exeptions;

import org.springframework.http.HttpStatus;


public class NotFoundException extends ApiBaseException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}

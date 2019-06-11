package com.exception.product;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomRestError extends RuntimeException {

    private static final long serialVersionUID = -2706433342411605482L;

    public CustomRestError(Date date, String exception, String description) {
        super("Something went wrong at: " + date + System.lineSeparator() + "This is all information about it: " + exception + " - " + description);
    }

}
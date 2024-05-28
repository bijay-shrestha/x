package com.x.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ApiException(String message,
                           HttpStatus httpStatus,
                           ZonedDateTime timestamp) {
}

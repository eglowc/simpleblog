package com.eglowc.simpleblog.web.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@AllArgsConstructor
public class AlreadyExistOwnerException extends RuntimeException {
    @Getter
    private String message;
}

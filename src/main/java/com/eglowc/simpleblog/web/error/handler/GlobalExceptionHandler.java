package com.eglowc.simpleblog.web.error.handler;

import com.eglowc.simpleblog.web.error.ErrorCode;
import com.eglowc.simpleblog.web.error.ErrorResponse;
import com.eglowc.simpleblog.web.error.exception.AlreadyExistOwnerException;
import com.eglowc.simpleblog.web.error.exception.BindingResultHasErrorsException;
import com.eglowc.simpleblog.web.error.exception.CouldNotCreateOwnerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception e) {
        log.debug("global Exception Handler ::: ", e);
        return new ResponseEntity<>(
                ErrorResponse.setRequestErrorInfo(
                        "요청실패.",
                        ErrorCode.INTERNAL_SERVER_ERROR
                ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BindingResultHasErrorsException.class)
    public ResponseEntity handleBindingResultHasErrorsException(BindingResultHasErrorsException e) {
        return new ResponseEntity<>(
                ErrorResponse.setBindingResultErrorInfo(
                        "잘못된 요청입니다.",
                        ErrorCode.BINDING_BAD_REQUEST,
                        e.getResult().getFieldErrors()
                ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {CouldNotCreateOwnerException.class, AlreadyExistOwnerException.class})
    public ResponseEntity handleCouldNotCreateOwnerException(RuntimeException e) {
        return new ResponseEntity<>(
                ErrorResponse.setRequestErrorInfo(
                        e.getMessage(),
                        ErrorCode.FAIL_CREATE_OWNER
                ), HttpStatus.EXPECTATION_FAILED);
    }

}

package com.eglowc.simpleblog.exception.handler;

import com.eglowc.simpleblog.exception.BindingResultHasErrorsException;
import com.eglowc.simpleblog.exception.CouldNotCreateOwner;
import com.eglowc.simpleblog.web.support.ErrorCode;
import com.eglowc.simpleblog.web.support.ErrorResponse;
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

    @ExceptionHandler(CouldNotCreateOwner.class)
    public ResponseEntity handleCouldNotCreateOwnerException() {
        return new ResponseEntity<>(
                ErrorResponse.setRequestErrorInfo(
                        "Owner 를 만드는데 실패했습니다.",
                        ErrorCode.FAIL_CREATE_OWNER
                ), HttpStatus.EXPECTATION_FAILED);
    }

}

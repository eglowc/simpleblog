package com.eglowc.simpleblog.web.support;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@Getter
@ToString
@EqualsAndHashCode
public class ErrorResponse {
    private String errorMessage;
    private ErrorCode errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FieldErrorInfo> fieldErrors;

    private ErrorResponse(String errorMessage, ErrorCode errorCode, List<FieldErrorInfo> fieldErrors) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.fieldErrors = fieldErrors;
    }

    private ErrorResponse(String errorMessage, ErrorCode errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public static ErrorResponse setRequestErrorInfo(final String errorMessage,
                                                    final ErrorCode errorCode) {
        return new ErrorResponse(errorMessage, errorCode);
    }

    public static ErrorResponse setBindingResultErrorInfo(final String errorMessage,
                                                          final ErrorCode errorCode,
                                                          final List<FieldError> fieldErrors) {
        return new ErrorResponse(
                errorMessage,
                errorCode,
                fieldErrors.stream().map(e ->
                        new FieldErrorInfo(e.getField(),
                                String.valueOf(e.getRejectedValue()),
                                e.getDefaultMessage())
                ).collect(Collectors.toList()));
    }

    @AllArgsConstructor
    @Getter
    private static class FieldErrorInfo {
        private String field;
        private String rejectedValue;
        private String reason; // defaultMessage
    }
}

package com.eglowc.simpleblog.web.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@AllArgsConstructor
public enum ErrorCode {

    BINDING_BAD_REQUEST("BINDING.BAD_REQUEST"),
    FAIL_CREATE_OWNER("FAIL_CREATE_OWNER"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR");

    @Getter
    public String errorCode;
}

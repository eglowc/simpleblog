package com.eglowc.simpleblog.web.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

/**
 * Created by HCLEE on 2016. 7. 21..
 *
 * @author HCLEE
 */
@AllArgsConstructor
public class BindingResultHasErrorsException extends RuntimeException{

    @Getter
    BindingResult result;

}

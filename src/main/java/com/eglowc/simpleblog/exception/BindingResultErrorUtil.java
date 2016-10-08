package com.eglowc.simpleblog.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;

/**
 * Created by HCLEE on 2016. 7. 21..
 *
 * @author HCLEE
 */
@Slf4j
public class BindingResultErrorUtil {

    public static void checkBindingResultError(BindingResult result) {
        if (result.hasErrors()) {
            log.debug("BindingResult hasErrors(), target: [{}], count: [{}]", result.getTarget(), result.getErrorCount());
            throw new BindingResultHasErrorsException(result);
        }
    }

}

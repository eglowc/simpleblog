package com.eglowc.simpleblog.models.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.omg.CORBA.UNKNOWN;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@AllArgsConstructor
@Getter
@ToString
public enum Role {
    OWNER("owner"),
    VISITOR("visitor"),
    UNKNOWN("unknown");

    private String name;
}

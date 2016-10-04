package com.eglowc.simpleblog.models.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.omg.CORBA.UNKNOWN;

/**
 * Created by HCLEE on 2016. 10. 4..
 *
 * @author HCLEE
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

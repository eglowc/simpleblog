package com.eglowc.simpleblog.models.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HCLEE on 2016. 10. 4..
 *
 * @author HCLEE
 */
@AllArgsConstructor
@Getter
@ToString
public enum PostStatus {
    UNSAVED("unsaved"),
    TEMPORARY_SAVED("temporary_saved"),
    PUBLISHED("published");

    private String name;
}

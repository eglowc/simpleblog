package com.eglowc.simpleblog.models.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author eglowc<eglowc@gmail.com>
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

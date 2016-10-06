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
public enum PostType {
    PLAIN("plain"),
    MARKDOWN("markdown");

    private String name;
}

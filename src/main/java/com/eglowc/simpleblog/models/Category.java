package com.eglowc.simpleblog.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@Entity
@Data
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 10)
    private int level;

    @Column(nullable = false, length = 10)
    private int parent;

    @Column(nullable = false, length = 75, unique = true)
    private String name;
}

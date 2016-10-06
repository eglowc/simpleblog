package com.eglowc.simpleblog.models;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@Entity
@Data
public class Category extends BaseEntity {
    private int level;
    private int parent;

    @NotBlank
    private String name;
}

package com.eglowc.simpleblog.models;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;

/**
 * Created by HCLEE on 2016. 10. 4..
 *
 * @author HCLEE
 */
@Entity
@Data
public class Category extends BaseEntity {
    private int level;
    private int parent;

    @NotBlank
    private String name;
}

package com.eglowc.simpleblog.models;


import com.eglowc.simpleblog.models.support.Role;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@Entity
@Data
@ToString(exclude = {"password"})
public class Owner extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String signature;

    @Enumerated(EnumType.STRING)
    private Role role = Role.UNKNOWN;

}

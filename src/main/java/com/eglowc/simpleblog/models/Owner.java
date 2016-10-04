package com.eglowc.simpleblog.models;



import com.eglowc.simpleblog.models.support.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by HCLEE on 2016. 10. 4..
 *
 * @author HCLEE
 */
@Entity
@Data
@ToString(exclude = {"password"})
public class Owner extends BaseEntity{

    @Column(nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false)
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column
    private String signature;

    @Enumerated(EnumType.STRING)
    private Role role = Role.UNKNOWN;

}

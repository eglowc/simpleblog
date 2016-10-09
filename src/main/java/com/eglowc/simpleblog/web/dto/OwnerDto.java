package com.eglowc.simpleblog.web.dto;

import com.eglowc.simpleblog.models.support.Role;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

/**
 * @author eglowc<eglowc@gmail.com>
 */
public class OwnerDto {

    @Data
    public static class Create {
        @Email
        @NotBlank
        private String email;

        @NotBlank
        private String password;

        private String signature;
    }

    @Data
    public static class Read {
        private String email;
        private String signature;
        private Role role;
        private LocalDateTime created;
        private LocalDateTime updated;
    }

}

package com.eglowc.simpleblog.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@EnableAsync
@SpringBootApplication
@EnableJpaAuditing
public class AuditingConfiguration {
}

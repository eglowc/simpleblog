package com.eglowc.simpleblog.repository;

import com.eglowc.simpleblog.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author eglowc<eglowc@gmail.com>
 */
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByEmail(String email);
}

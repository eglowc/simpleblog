package com.eglowc.simpleblog.repository;

import com.eglowc.simpleblog.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by HCLEE on 2016. 10. 6..
 *
 * @author HCLEE
 */
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByEmail(String email);
}

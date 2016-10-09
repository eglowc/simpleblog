package com.eglowc.simpleblog.service;

import com.eglowc.simpleblog.models.Owner;
import com.eglowc.simpleblog.models.support.Role;
import com.eglowc.simpleblog.repository.OwnerRepository;
import com.eglowc.simpleblog.web.error.exception.AlreadyExistOwnerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@Service
@Transactional
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Stream<Owner> getOwnerStream() {
        return this.ownerRepository.findAll().stream();
    }

    public Optional<Owner> createOwner(final Owner owner) {
        if (this.ownerRepository.findAll().isEmpty()) {
            owner.setRole(Role.OWNER);
            return Optional.ofNullable(this.ownerRepository.save(owner));
        } else {
            throw new AlreadyExistOwnerException("이미 Owner 가 존재합니다.");
        }
    }
}

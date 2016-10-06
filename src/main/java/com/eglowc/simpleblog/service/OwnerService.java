package com.eglowc.simpleblog.service;

import com.eglowc.simpleblog.models.Owner;
import com.eglowc.simpleblog.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Stream<Owner> getOwnerStream() {
        return this.ownerRepository.findAll().stream();
    }
}

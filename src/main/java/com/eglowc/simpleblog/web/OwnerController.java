package com.eglowc.simpleblog.web;

import com.eglowc.simpleblog.models.Owner;
import com.eglowc.simpleblog.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @GetMapping
    public ResponseEntity getOwner() {
        Optional<Owner> optOwner =
                ownerService.getOwnerStream().findFirst();

        if (optOwner.isPresent()) {
            return new ResponseEntity<>(optOwner.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

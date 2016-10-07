package com.eglowc.simpleblog.web;

import com.eglowc.simpleblog.dto.OwnerDto;
import com.eglowc.simpleblog.models.Owner;
import com.eglowc.simpleblog.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    public OwnerController(OwnerService ownerService, ModelMapper modelMapper) {
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    public ResponseEntity getOwner() {
        Optional<Owner> optOwner =
                ownerService.getOwnerStream().findFirst();

        if (optOwner.isPresent()) {
            final OwnerDto.Read read = modelMapper.map(optOwner.get(), OwnerDto.Read.class);
            return new ResponseEntity<>(read, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/create")
    public ResponseEntity createOwner(@RequestBody @Valid final OwnerDto.Create createOwner) {
        Optional<Owner> created =
                ownerService.createOwner(modelMapper.map(createOwner, Owner.class));

        if (created.isPresent()) {
            final OwnerDto.Read read = modelMapper.map(created.get(), OwnerDto.Read.class);
            return new ResponseEntity<>(read, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }


    }
}

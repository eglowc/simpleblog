package com.eglowc.simpleblog.web;

import com.eglowc.simpleblog.models.Owner;
import com.eglowc.simpleblog.service.OwnerService;
import com.eglowc.simpleblog.web.dto.OwnerDto;
import com.eglowc.simpleblog.web.error.exception.CouldNotCreateOwnerException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@RestController
@Slf4j
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
        final Optional<Owner> optOwner =
                ownerService.getOwnerStream().findFirst();

        if (optOwner.isPresent()) {
            final OwnerDto.Read read = modelMapper.map(optOwner.get(), OwnerDto.Read.class);
            return new ResponseEntity<>(read, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/create")
    public ResponseEntity createOwner(@RequestBody @Valid final OwnerDto.Create createOwner,
                                      BindingResult result) {
        final Optional<Owner> created =
                ownerService.createOwner(modelMapper.map(createOwner, Owner.class));

        if (created.isPresent()) {
            final OwnerDto.Read read = modelMapper.map(created.get(), OwnerDto.Read.class);
            return new ResponseEntity<>(read, HttpStatus.CREATED);
        } else {
            log.debug("Owner 생성 예외, 생성 후 반환값을 가져오지 못했음.");
            throw new CouldNotCreateOwnerException("Owner 를 생성하는데 실패했습니다.");
        }
    }

}

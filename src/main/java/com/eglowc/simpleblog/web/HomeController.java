package com.eglowc.simpleblog.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HCLEE on 2016. 9. 30..
 *
 * @author HCLEE
 */
@RestController
public class HomeController {

    @GetMapping("/hello")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Hello simpleblog.", HttpStatus.OK);
    }

}

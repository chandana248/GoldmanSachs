package com.example.demo.solution1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> post(@RequestBody @Size(max = 1000) final String _s_) {
        service.post(_s_);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get/{_s_}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> get(@PathVariable String _s_) {
        final String val = service.get(_s_);
        return val != null ? ResponseEntity.ok(val) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

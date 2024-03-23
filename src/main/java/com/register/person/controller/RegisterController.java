package com.register.person.controller;

import com.register.person.models.Register;
import com.register.person.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @GetMapping
    public ResponseEntity<List<Register>> getAllRegister(){
        return  new ResponseEntity<>(registerService.getAllRegister(), HttpStatus.OK);
    }
    @GetMapping("/{idRegister}")
    public ResponseEntity<Register> findRegisterById(@PathVariable String idRegister){
        return new ResponseEntity(registerService.findRegisterById(idRegister),HttpStatus.OK);
    }

    @PostMapping("/{save-register}")
    public ResponseEntity<Register> saveRegister(@RequestBody Register register){
        return new ResponseEntity<>(registerService.saveRegister(register), HttpStatus.CREATED);
    }

    @PutMapping("/{idRegister}")
    public ResponseEntity<Register> updateRegister(@PathVariable String idRegister, @RequestBody Register register){
        return new ResponseEntity<>(registerService.updateRegister(idRegister, register),HttpStatus.OK);
    }

    @DeleteMapping("/{idRegister}")
    public ResponseEntity<Boolean> deleteRegister(@PathVariable String idRegister){
       return new ResponseEntity<>(registerService.deleteRegisterById(idRegister),HttpStatus.OK);
    }
}

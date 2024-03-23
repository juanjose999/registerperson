package com.register.person.service;

import com.register.person.models.Register;

import java.util.List;
import java.util.Optional;

public interface RegisterService {
    List<Register> getAllRegister();
    Optional<Register> findRegisterById(String idRegister);
    Register saveRegister(Register register);
    Register updateRegister(String idRegister, Register register);
    Boolean deleteRegister (String idRegister);
}

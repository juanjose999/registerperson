package com.register.person.repository;

import com.register.person.models.Register;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository {
    List<Register> getAllRegister();
    Optional<Register> findRegisterById(String idRegister);
    Register saveRegister(Register register);
    Register updateRegister(String idRegister, Register register);
    Boolean deleteRegister (String idRegister);
}

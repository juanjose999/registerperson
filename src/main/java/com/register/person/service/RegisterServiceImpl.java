package com.register.person.service;

import com.register.person.models.Register;
import com.register.person.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public List<Register> getAllRegister() {
        return registerRepository.getAllRegister();
    }

    @Override
    public Optional<Register> findRegisterById(String idRegister) {
        return registerRepository.findRegisterById(idRegister);
    }

    @Override
    public Register saveRegister(Register register) {
        return registerRepository.saveRegister(register);
    }

    @Override
    public Register updateRegister(String idRegister, Register register) {
        return registerRepository.updateRegister(idRegister, register);
    }

    @Override
    public Boolean deleteRegisterById(String idRegister) {
        return registerRepository.deleteRegisterById(idRegister);
    }
}

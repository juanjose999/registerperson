package com.register.person.repository;

import com.register.person.models.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class RegisterRepositoryImpl implements RegisterRepository{

    @Autowired
    private RegisterRepositoryMongo registerRepositoryMongo;

    @Override
    public List<Register> getAllRegister() {
        return registerRepositoryMongo.findAll();
    }

    @Override
    public Optional<Register> findRegisterById(String idRegister) {
        return registerRepositoryMongo.findById(idRegister);
    }

    @Override
    public Register saveRegister(Register register) {
        return registerRepositoryMongo.save(register);
    }

    @Override
    public Register updateRegister(String idRegister, Register register) {
        Optional<Register> findRegister = registerRepositoryMongo.findById(idRegister);
        if(findRegister.isPresent()){
            Register existingRegister = findRegister.get();
            existingRegister.setFullNamePerson(register.getFullNamePerson());
            existingRegister.setIdCardNumber(register.getIdCardNumber());
            existingRegister.setReasonForEntry(register.getReasonForEntry());
            return registerRepositoryMongo.save(existingRegister);
        }
        throw new RuntimeException("Error in find Register or id not existing");
    }

    @Override
    public Boolean deleteRegister(String idRegister) {
        Optional<Register> findRegister = registerRepositoryMongo.findById(idRegister);
        if(findRegister.isPresent()){
            registerRepositoryMongo.delete(findRegister.get());
            return true;
        }
        return false;
    }
}

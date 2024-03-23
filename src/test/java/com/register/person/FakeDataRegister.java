package com.register.person;

import com.register.person.models.Register;

import java.util.ArrayList;
import java.util.List;

public class FakeDataRegister {
    public static Register registerNew(){
        Register register = new Register();
        register.setIdRegister("1");
        register.setFullNamePerson("holman morris");
        register.setIdCardNumber("323224555");
        register.setReasonForEntry("conferencia");
        register.setHourEntry("2024-03-23 : 10:15");
        return register;
    }
    public static List<Register> registerList(){
        Register register2 = new Register();
        register2.setIdRegister("2");
        register2.setFullNamePerson("Maria carolina");
        register2.setIdCardNumber("323224555");
        register2.setReasonForEntry("Aseo");
        register2.setHourEntry("2024-03-23 : 10:15");

        Register register3 = new Register();
        register3.setIdRegister("3");
        register3.setFullNamePerson("Alicia ordas");
        register3.setIdCardNumber("323224555");
        register3.setReasonForEntry("Tecnologia");
        register3.setHourEntry("2024-03-23 : 10:15");

        List<Register> registerList = new ArrayList<>();
        registerList.add(register2);
        registerList.add(register3);
        return registerList;
    }
}

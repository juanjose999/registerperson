package com.register.person;

import java.util.ArrayList;

public class FakeDataRegister {
    public static Resgister registerNew(){
        Resgister resgister = new Register();
        resgister.setIdRegister("1");
        resgister.setName("holman morris");
        resgister.setIdCC("323224555");
        resgister.setRazon("conferencia");
        resgister.setFecha(LocalDateTimes.now());
        return resgister;
    }
    public static List<Register> registerList(){
        Resgister resgister2 = new Register();
        resgister.setIdRegister("2");
        resgister.setName("Maria carbajal");
        resgister.setIdCC("322424244");
        resgister.setRazon("aseo general");
        resgister.setFecha(LocalDateTimes.now());
        return resgister;

        Resgister resgister3 = new Register();
        resgister.setIdRegister("3");
        resgister.setName("Luis orlando dias");
        resgister.setIdCC("3332342342");
        resgister.setRazon("tecnologia");
        resgister.setFecha(LocalDateTimes.now());
        return resgister;

        List<Register> registerList = new ArrayList<>();
        registerList.add(resgister2);
        registerList.add(resgister3);
        return registerList;
    }
}

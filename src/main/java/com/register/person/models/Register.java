package com.register.person.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "registers")
public class Register implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
    @Id
    private String idRegister;
    private String fullNamePerson;
    private String idCardNumber;
    private String reasonForEntry;
    private String hourEntry;

    public Register(String fullNamePerson, String idCardNumber, String reasonForEntry) {
        this.fullNamePerson = fullNamePerson;
        this.idCardNumber = idCardNumber;
        this.reasonForEntry = reasonForEntry;
        hourEntry = getHourEntry();
    }

    public String getHourEntry(){
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd : HH:mm");
        return currentDate.format(formatter);
    }
}

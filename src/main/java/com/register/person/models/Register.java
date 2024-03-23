package com.register.person.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
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
}

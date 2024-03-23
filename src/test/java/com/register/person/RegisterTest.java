package com.register.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.register.person.controller.RegisterController;
import com.register.person.models.Register;
import com.register.person.service.RegisterService;
import com.register.person.service.RegisterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RegisterTest {

    @Mock
    private RegisterService registerService;

    @InjectMocks
    private RegisterController registerController;

    private MockMvc mockMvc;
    private static final String BASE_URL = "/register";

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
    }

    @Test
    public void testReadAllRegister() {
        List<Register> registerList = FakeDataRegister.registerList();

        when(registerService.getAllRegister()).thenReturn(registerList);
        List<Register> registerListSimulation = registerService.getAllRegister();

        verify(registerService, times(1)).getAllRegister();
    }

    @Test
    public void testReadRegisterById() throws Exception {
        Register registerNew = FakeDataRegister.registerNew();
        String idRegisterSearch = "1";

        when(registerService.findRegisterById(idRegisterSearch)).thenReturn(Optional.of(registerNew));

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(registerNew);

        mockMvc.perform(get(BASE_URL + "/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));

        verify(registerService, times(1)).findRegisterById("1");
    }

    @Test
    public void testAddNewRegister() {
        Register registerNew = FakeDataRegister.registerNew();

        when(registerService.saveRegister(registerNew)).thenReturn(registerNew);

        Register registerSimulation = registerService.saveRegister(registerNew);

        verify(registerService, times(1)).saveRegister(registerNew);
        assertEquals(registerNew, registerSimulation);
    }

    @Test
    public void testDeleteRegister() throws Exception {
        Register register = new Register(); // Crea un registro de prueba aquí

        String idDelete = "1";
        when(registerService.findRegisterById(idDelete)).thenReturn(Optional.of(register));

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(register); // Convierte el registro a JSON

        mockMvc.perform(delete(BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                        .andExpect(status().isOk());

        verify(registerService, times(1)).deleteRegisterById("1");
    }
}

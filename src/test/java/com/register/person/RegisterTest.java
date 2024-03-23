package com.register.person;

import com.register.person.models.Register;
import com.register.person.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

public class RegisterTest {

    @Mock
    private RegisterService registerService;
    private MockMvc mock;
    private static final String BASE_URL = "register";

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

        when(registerService.findRegisterById(idRegisterSearch)).thenReturn(registerNew);

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));

        verify(registerService, times(1)).findRegisterById("1");
    }

    @Test
    public void testAddNewRegister() {
        Register registerNew = FakeDataRegister.registerNew();

        when(registerService.saveNewRegister(registerNew)).thenReturn(registerNew);

        Register registerSimulation = registerService.saveNewRegister(registerNew);

        verify(registerService, times(1)).saveNewRegister(registerNew);
        assertEquals(registerNew, registerSimulation);
    }

    @Test
    public void testDeleteRegister() throws Exception {
        String idDelete = "1";
        when(registerService.deleteRegisterById(idDelete)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(registerService, times(1)).deleteRegisterById("1");
    }
}

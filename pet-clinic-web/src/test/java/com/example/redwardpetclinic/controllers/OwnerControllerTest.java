package com.example.redwardpetclinic.controllers;

import com.example.redwardpetclinic.model.Owner;
import com.example.redwardpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by r.edward on {19/08/2023}
 * For controller we use mock MockMvc with **standalone**(lighter) setup
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock OwnerService ownerService;

    @InjectMocks OwnerController controller;

    MockMvc mockMvc;

    Set<Owner> ownersSet;

    @BeforeEach
    void setUp() {
        ownersSet= new HashSet<>();
        Owner o1= new Owner();
        o1.setId(1L);
        Owner o2= new Owner();
        o2.setId(2L);
        ownersSet.addAll(asList(o1, o2));

        //init mockmvc
        mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(ownersSet);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
//                .andExpect(model().attribute("owners", eq(ownersSet)));
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listOwnersByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(ownersSet);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notImplemented"));
    }
}
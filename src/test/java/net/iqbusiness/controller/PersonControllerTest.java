package net.iqbusiness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.iqbusiness.converter.PersonDTOToPersonConverter;
import net.iqbusiness.dto.PersonDTO;
import net.iqbusiness.model.Person;
import net.iqbusiness.service.PersonService;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PersonControllerTest.class)
@AutoConfigureMockMvc
public class PersonControllerTest {

    private PersonDTO validPersonDto;
    private PersonDTO invalidPersonDto;
    private Person validNewPerson;
    private Person savedPerson;
    private Person invalidNewPerson;
    private PersonDTOToPersonConverter personDTOToPersonConverter;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonService personService;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        validPersonDto = new PersonDTO("Muzi1", "Hlatshwayo", "9076542345678", "0724368695");
        invalidPersonDto= new PersonDTO("", "Hlatshwayo", "9076542345678", "0724368695");

        personDTOToPersonConverter = new PersonDTOToPersonConverter();
        validNewPerson = personDTOToPersonConverter.getPerson(validPersonDto);
        invalidNewPerson = personDTOToPersonConverter.getPerson(invalidPersonDto);
        savedPerson = new Person();
        savedPerson.setId(1L);
        savedPerson.setFullName("Muzi1 Hlatshwayo");
        savedPerson.setIdNumber("9076542345678");
        savedPerson.setPhoneNumber("0724368695");

    }


    @Test
    public void whenAddValidPerson_thenReturnStatus201() throws Exception {

        Mockito.when(personService.addPerson(validNewPerson)).thenReturn(savedPerson);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/persons/add")
                .content(objectMapper.writeValueAsString(validPersonDto)).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fullName", Matchers.is("Muzi1 Hlatshwayo")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idNumber", Matchers.is("9076542345678")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber", Matchers.is("0724368695")))
                .andReturn();

    }



    @Test
    public void whenGetPersonsList_thenCorrectResponse() throws Exception {

        Mockito.when(personService.listPersons()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/persons/list")
                .content(String.valueOf(MediaType.APPLICATION_JSON_UTF8))
        ).andReturn();


    }

    @After
    public void tearDown() {
        validPersonDto = null;
        savedPerson = null;
        validNewPerson = null;
        personDTOToPersonConverter = null;
    }

}

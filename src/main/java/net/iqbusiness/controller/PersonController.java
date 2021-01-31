package net.iqbusiness.controller;

import net.iqbusiness.converter.PersonDTOToPersonConverter;
import net.iqbusiness.dto.PersonDTO;
import net.iqbusiness.model.Person;
import net.iqbusiness.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/persons")
public class PersonController {

    PersonDTOToPersonConverter personDTOToPersonConverter = new PersonDTOToPersonConverter();
    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public Person addPerson(@Valid @RequestBody PersonDTO personDTO)
    {
        return personService.addPerson(personDTOToPersonConverter.getPerson(personDTO));
    }

    @GetMapping("/list")
    public List<Person> getAllPersons()
    {
        return personService.listPersons();
    }
}


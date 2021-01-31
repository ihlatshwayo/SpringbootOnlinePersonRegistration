package net.iqbusiness.service.impl;

import net.iqbusiness.model.Person;
import net.iqbusiness.repository.PersonRepository;
import net.iqbusiness.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Override
    public Person addPerson(Person person) {
       return personRepository.save(person);

    }

    @Override
    public List<Person> listPersons() {
        return personRepository.findAll();
    }
}

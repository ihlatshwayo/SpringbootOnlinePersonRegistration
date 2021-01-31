package net.iqbusiness.service;

import net.iqbusiness.model.Person;

import java.util.List;

public interface PersonService {

    Person addPerson(Person person);
    List<Person> listPersons();
}

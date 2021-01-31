package net.iqbusiness.converter;

import net.iqbusiness.dto.PersonDTO;
import net.iqbusiness.model.Person;

public class PersonDTOToPersonConverter {
    public Person getPerson(PersonDTO personDTO){
        Person person = new Person();
         person.setFullName(new StringBuilder(personDTO.getFirstName())
                 .append(" ")
                 .append(personDTO.getLastName()).toString());
         person.setIdNumber(personDTO.getIdNumber());
         person.setPhoneNumber(personDTO.getPhoneNumber());
       return person;
    }
}

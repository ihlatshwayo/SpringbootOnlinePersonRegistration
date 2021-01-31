package net.iqbusiness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {

    @NotBlank(message = "firstname cannot be blank")
    private String firstName;

    @NotBlank(message = "lastname cannot be blank")
    private String lastName;

    @Size(min = 13, max = 13, message = "13 numeric characters required for id number")
    @NotBlank(message = "ID number cannot be blank")
    String idNumber;

    @Size(min = 10, max = 10, message = "10 numeric characters required for phone number")
    @NotBlank(message = "phone number cannot be blank")
    private String phoneNumber;

}

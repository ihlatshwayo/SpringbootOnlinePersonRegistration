package net.iqbusiness.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Persons")
public class Person {
    @Id
    @GeneratedValue
    private long Id;
    private String fullName;
    private String idNumber;
    private String phoneNumber;
}

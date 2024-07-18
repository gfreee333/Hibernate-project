package org.example.tableperclasstest;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@DiscriminatorValue(value = "client")
public class Client extends Userr {
    private String addres;
    @Builder
    public Client(Integer id, String firstName, String lastName, Integer phone, String addres) {
        super(id, firstName, lastName, phone);
        this.addres = addres;
    }
}

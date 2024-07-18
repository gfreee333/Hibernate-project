package org.example.tableperclasstest;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@DiscriminatorValue(value = "maganer")
public class Manager extends Userr{
    @Column(name = "nickname")
    private String nickName;
    @Builder
    public Manager(Integer id, String firstName, String lastName, Integer phone, String nickName) {
        super(id, firstName, lastName, phone);
        this.nickName = nickName;
    }
}

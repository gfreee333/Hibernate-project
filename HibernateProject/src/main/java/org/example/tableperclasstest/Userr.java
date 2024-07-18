package org.example.tableperclasstest;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"addres","nickname"})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "type")
public class Userr{
    @Id
    @GeneratedValue(generator = "sequence2", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sequence2", sequenceName="userr_id_seq", allocationSize=1)
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private Integer phone;
}

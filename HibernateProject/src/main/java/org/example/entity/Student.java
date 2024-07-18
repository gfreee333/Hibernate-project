package org.example.entity;
import lombok.*;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
@EqualsAndHashCode(of = "firstname")
@Entity
public class Student extends ExtendId<Integer>{
    @Column(name = "firstname")
    private String firsName;
    @Column(name = "lastname")
    private String lastName;
    private String email;
    @Column(name = "phonenumber")
    private Integer phoneNumber;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "coursed")
    private Course course;
}

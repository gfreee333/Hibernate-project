package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "person")
@Builder
@EqualsAndHashCode()
@Entity
@Table(name = "jobe")
public class Jobe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private String name;
    @OneToMany(mappedBy = "jobe", cascade = CascadeType.ALL)
    @Builder.Default
    List<Person> personList = new ArrayList<>();
    public void addPerson(Person person){
        personList.add(person);
        person.setJobe(this);
    }
}

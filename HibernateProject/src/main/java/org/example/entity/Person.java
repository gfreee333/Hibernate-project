package org.example.entity;

import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("all")
@NamedQuery(name = "SelectAllPerson", query = "select p from Person p")

@NamedQuery(name = "test", query = "select j from Jobe j")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "jobe")
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer phone;
    private Integer experience;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "jobeid")
    private Jobe jobe;
}

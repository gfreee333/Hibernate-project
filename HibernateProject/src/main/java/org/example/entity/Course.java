package org.example.entity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "student")
@EqualsAndHashCode(of = "coursename")
@Entity
public class Course extends ExtendId<Integer>{
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;*/
    private String courseName;
    private String region;
    @Builder.Default
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();
    public void addStudent(Student student){
        students.add(student);
        student.setCourse(this);
    }

}

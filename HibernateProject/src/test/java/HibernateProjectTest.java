import lombok.Cleanup;
import org.example.entity.Course;
import org.example.entity.Jobe;
import org.example.entity.Person;
import org.example.entity.Student;
import org.example.tableperclasstest.Client;
import org.example.tableperclasstest.Manager;
import org.example.util.TransactionHI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class HibernateProjectTest {
    @SuppressWarnings("all")
    @Test
    public void AllPersonWhereIdJobe(){
        @Cleanup SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
            String query = "from Person where jobeid = 2";
            //System.out.println(session.createQuery("select p from org.example.entity.Person p").list());
            System.out.println(session.createQuery(query)
                    .list());
            System.out.println(session.createNamedQuery("SelectAllPerson"));
            System.out.println(session.createNamedQuery("test"));
            session.getTransaction().commit();
    }
    @Test
    public void setJobe(){
        @Cleanup SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        Jobe jobe = Jobe.builder()
                .address("This address 1")
                .name("Yandex")
                .build();
        Person person = Person.builder()
                .phone(213123)
                .firstName("CYKA").build();
        session.save(jobe);
        session.getTransaction().commit();
    }
    @Test
    public void setPerson(){
        @Cleanup SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        Jobe jobeValue = session.get(Jobe.class,1);
        Person person = Person.builder()
                .firstName("Ivan")
                .experience(3)
                .phone(23333)
                .jobe(jobeValue).build();
        jobeValue.addPerson(person);
        session.save(person);
        session.getTransaction().commit();
    }


    @Test
    public void InheritanceTest(){
        @Cleanup SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = Client.builder()
                .addres("hello")
                .firstName("help")
                .phone(213123)
                .lastName("fefefe")
                .build();
        Manager manager = Manager.builder()
                .nickName("Alina")
                .firstName("help")
                .lastName("fefefe")
                .phone(213123)
                .build();
        session.save(client);
        session.save(manager);
        session.flush();
        session.clear();

        var manager2 = session.get(Manager.class,1);
        var client2 = session.get(Client.class,2);
        session.getTransaction().commit();
    }
    @Test
    public void tablePerClassTest(){
        @Cleanup SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = Client.builder()
                .firstName("help")
                .addres("hello")
                .phone(213123)
                .lastName("fefefe")
                .build();
        Manager manager = Manager.builder()
                .nickName("helper").phone(22213).build();
        session.save(client);
        session.save(manager);
        session.flush();
        session.clear();
        session.getTransaction().commit();
    }
//    @Test
//    public void setUser(){
//        @Cleanup SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
//        @Cleanup Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Userr user = Userr.builder()
//                .firstName("Ivan")
//                .phone(123123)
//                .lastName("ehehehe")
//                .build();
//        session.save(user);
//        session.getTransaction().commit();
//    }


    @Test
    public void setCourseTest(){
        @Cleanup SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        Course course = Course.builder()
                .courseName("testing").build();
        session.save(course);
        session.getTransaction().commit();
    }
    @Test
    public void checkH2(){
        @Cleanup SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = Student.builder()
                .email("first")
                .phoneNumber(23213)
                .firsName("23123123")
                .lastName("efefef")
                .build();
        Course course = session.get(Course.class,1);
        course.addStudent(student);
        session.save(course);
        session.getTransaction().commit();
    }
    @Test
    public void saveStudentsTest(){
        Configuration configuration = new Configuration().configure();
        configuration.configure();
        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Student student = Student.builder()
                    .firsName("Ivan")
                    .lastName("Chuhmanov")
                    .email("chuha22@mail.ru")
                    .phoneNumber(78878866)
                    .build();
            session.save(student);
            session.getTransaction().commit();
        }
    }
    @Test
    public void getStudentTest(){
        try(SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
            Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            System.out.println(session.get(Student.class,2));
            session.getTransaction().commit();
        }
    }
    @Test
    public void deleteStudentTest(){
        try(SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
            Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.delete(session.get(Student.class,1));
            session.getTransaction().commit();
        }
    }
    @Test
    public void updateStudentTest(){
        try(SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
            Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            Student student = session.get(Student.class,7);
            student.setEmail("FUCK_YOU");
            session.update(student);
            session.getTransaction().commit();
        }
    }
    @Test
    public void addStudent(){
        try(SessionFactory sessionFactory = TransactionHI.buildSessionFactory();
            Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            Student student = Student.builder()
                    .firsName("LastProverka")
                    .lastName("Chuhmanov")
                    .email("google2")
                    .phoneNumber(789)
                    .build();
           // Course course = Course.builder()
           //         .courseName("TestCourse").build();
            Course course = session.get(Course.class,1);
            course.addStudent(student);
            session.save(course);
            session.getTransaction().commit();
        }
    }
}



import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Student> studentList = 	session.createCriteria(Student.class)
                .add(Restrictions.like("name", 	"P%")).list();
        for (Student student : studentList) {
            System.out.println(student.getName());
        }



        session.getTransaction().commit();
        session.close();
    }

}

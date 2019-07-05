package com.zhouyi.hibernate.demo;
import com.zhouyi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = MySessionFactory.sessionFactory;

        Session session = factory.getCurrentSession();


        try{

        // use the session object to save Java object

        // create a student object
        Student student = new Student("Kaijun5", "Chen5", "999@qq.com");

        // start transaction
        session.beginTransaction();

        // save the student
        session.save(student);

        // commit transaction
        session.getTransaction().commit();

    }
        finally{
        factory.close();
    }
}
}

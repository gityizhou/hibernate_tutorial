package com.zhouyi.hibernate.demo;

import com.zhouyi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = MySessionFactory.sessionFactory;

        Session session = factory.getCurrentSession();


        try{

            // use the session object to save Java object


            // start transaction
            session.beginTransaction();

            // write the query
            List<Student> studentList = session.createQuery("from Student").getResultList();
            for(Object tempStudent : studentList){
                System.out.println(tempStudent);
            }

            System.out.println("---------------------------------------");

            studentList = session.createQuery("from Student s where s.last_name='Chen'").getResultList();
            for(Object tempStudent : studentList){
                System.out.println(tempStudent);
            }

            System.out.println("---------------------------------------");

            studentList = session.createQuery("from Student s where s.last_name='Chen' OR s.last_name='Zhou'").getResultList();
            for(Object tempStudent : studentList){
                System.out.println(tempStudent);
            }

            System.out.println("---------------------------------------");

            studentList = session.createQuery("from Student s where s.email LIKE'%qq.com'").getResultList();
            for(Object tempStudent : studentList){
                System.out.println(tempStudent);
            }
            // commit transaction
            session.getTransaction().commit();

        }
        finally{
            factory.close();
        }
    }
}

package com.zhouyi.hibernate.demo;

import com.zhouyi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = MySessionFactory.sessionFactory;

        Session session = factory.getCurrentSession();



        try{
            // read the student

            session.beginTransaction();

            System.out.println("通过id获取这个对象");

            Student student = session.get(Student.class, 1);

            System.out.println("学生资料:" + student);

            session.getTransaction().commit();


        }
        finally{
            factory.close();
        }
    }
}

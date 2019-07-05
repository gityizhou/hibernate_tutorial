package com.zhouyi.hibernate.demo;

import com.zhouyi.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmoloyeeDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            Employee e1 = session.get(Employee.class, 1);
            System.out.println(e1);
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}

package com.wipro.Example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wipro.Example.entity.Flight;

public class HqlDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Flight.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // -------- INSERT using HQL --------
        Transaction tx = session.beginTransaction();

        Flight f5 = new Flight(205, "GoAir", "Pune", "Delhi", 3100.0);
        Flight f6 = new Flight(206, "AirAsia", "Chennai", "Mumbai", 2900.0);

        session.persist(f5);
        session.persist(f6);

        tx.commit();
        System.out.println("✅ INSERT done using HqlDemo");

        // -------- SELECT using HQL with WHERE clause --------
        Query<Flight> hqlQuery = session.createQuery(
                "from Flight f where f.price > :minPrice", Flight.class);

        hqlQuery.setParameter("minPrice", 3000.0);

        List<Flight> list = hqlQuery.list();

        System.out.println("\n📋 SELECT - HQL Output (price > 3000):");
        for (Flight f : list) {
            System.out.println(f);
        }

        session.close();
        factory.close();
    }
}

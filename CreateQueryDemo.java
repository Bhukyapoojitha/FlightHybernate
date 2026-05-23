package com.wipro.Example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wipro.Example.entity.Flight;

public class CreateQueryDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Flight.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // -------- INSERT using session.persist() --------
        Transaction tx = session.beginTransaction();

        Flight f1 = new Flight(201, "IndiGo", "Hyderabad", "Delhi", 4500.0);
        Flight f2 = new Flight(202, "Air India", "Mumbai", "Chennai", 3800.0);

        session.persist(f1);
        session.persist(f2);

        tx.commit();
        System.out.println("✅ INSERT done using CreateQuery (persist)");

        // -------- SELECT using createQuery --------
        Query<Flight> query = session.createQuery("from Flight", Flight.class);

        List<Flight> list = query.list();

        System.out.println("\n📋 SELECT - createQuery Output:");
        for (Flight f : list) {
            System.out.println(f);
        }

        session.close();
        factory.close();
    }
}

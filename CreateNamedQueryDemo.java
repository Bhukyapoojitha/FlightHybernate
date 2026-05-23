package com.wipro.Example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wipro.Example.entity.Flight;

public class CreateNamedQueryDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Flight.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // -------- INSERT --------
        Transaction tx = session.beginTransaction();

        Flight f3 = new Flight(203, "SpiceJet", "Hyderabad", "Bangalore", 2500.0);
        Flight f4 = new Flight(204, "Vistara", "Delhi", "Kolkata", 5200.0);

        session.persist(f3);
        session.persist(f4);

        tx.commit();
        System.out.println("✅ INSERT done using CreateNamedQueryDemo");

        // -------- SELECT using createNamedQuery --------
        // Named Query defined in Flight.java: "Flight.findBySource"
        Query<Flight> namedQuery = session.createNamedQuery(
                "Flight.findBySource", Flight.class);

        namedQuery.setParameter("src", "Hyderabad");

        List<Flight> list = namedQuery.list();

        System.out.println("\n📋 SELECT - createNamedQuery Output (source = Hyderabad):");
        for (Flight f : list) {
            System.out.println(f);
        }

        session.close();
        factory.close();
    }
}

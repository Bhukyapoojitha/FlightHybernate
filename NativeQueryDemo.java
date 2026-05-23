package com.wipro.Example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wipro.Example.entity.Flight;

public class NativeQueryDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Flight.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // -------- INSERT using Native SQL --------
        Transaction tx = session.beginTransaction();

        session.createNativeMutationQuery(
            "insert into flight (flight_id, flight_name, source, destination, price) " +
            "values (207, 'BlueDart Air', 'Hyderabad', 'Mumbai', 4100.0)"
        ).executeUpdate();

        tx.commit();
        System.out.println("✅ INSERT done using NativeQueryDemo");

        // -------- SELECT using Named Native Query --------
        // Named Native Query defined in Flight.java: "Flight.findAll"
        Query<Flight> nativeQuery = session.createNamedQuery(
                "Flight.findAll", Flight.class);

        List<Flight> list = nativeQuery.list();

        System.out.println("\n📋 SELECT - Native Query Output (all flights):");
        for (Flight f : list) {
            System.out.println(f);
        }

        session.close();
        factory.close();
    }
}

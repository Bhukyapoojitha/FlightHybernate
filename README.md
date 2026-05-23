# FlightHibernate - Hibernate Query Types Demo

A real-time Hibernate project demonstrating all 4 types of queries using a **Flight** entity.

## Project Structure

```
FlightHibernate/
├── src/main/java/com/wipro/Example/
│   ├── CreateQueryDemo.java         ← createQuery() - SELECT & INSERT
│   ├── CreateNamedQueryDemo.java    ← createNamedQuery() - SELECT & INSERT
│   ├── HqlDemo.java                 ← HQL queries - SELECT & INSERT
│   └── NativeQueryDemo.java         ← Native SQL queries - SELECT & INSERT
├── src/main/java/com/wipro/Example/entity/
│   └── Flight.java                  ← Entity class with @NamedQuery & @NamedNativeQuery
├── src/main/resources/
│   └── hibernate.cfg.xml            ← Hibernate configuration
└── pom.xml
```

## Query Types Covered

| File | Query Type | Description |
|------|-----------|-------------|
| CreateQueryDemo | `session.createQuery()` | Basic HQL using createQuery |
| CreateNamedQueryDemo | `session.createNamedQuery()` | Pre-defined named queries |
| HqlDemo | HQL | Hibernate Query Language with parameters |
| NativeQueryDemo | `createNativeMutationQuery()` | Raw SQL / Named Native Query |

## Setup Instructions

1. Install MySQL and create database:
```sql
CREATE DATABASE flightdb;
```

2. Update `hibernate.cfg.xml` with your MySQL password

3. Run each demo class one by one as Java Application:
   - Run `CreateQueryDemo.java` first
   - Then `CreateNamedQueryDemo.java`
   - Then `HqlDemo.java`
   - Then `NativeQueryDemo.java`

## Technologies Used
- Java 17
- Hibernate 6.4.4
- MySQL 8
- Maven
- Spring Tool Suite 4 (STS)

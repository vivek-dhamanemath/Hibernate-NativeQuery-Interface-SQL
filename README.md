# Hibernate SQL Project

## NativeQuery Interface (SQL)

The `NativeQuery` interface is present in the `org.hibernate.query` package. It allows you to execute native SQL queries directly in Hibernate. This can be particularly useful when you need to perform complex queries or use database-specific features that are not easily expressed using HQL (Hibernate Query Language) or Criteria.

### How to Use NativeQuery

To use the `NativeQuery` interface, you need to create an instance of it by invoking the `createNativeQuery()` method using the session instance. Below is an example of how to use it:

```java
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

// ...existing code...

Session session = sessionFactory.openSession();
session.beginTransaction();

// Example of a native SQL query
String sql = "SELECT * FROM Product WHERE productPrice > :price";
NativeQuery query = session.createNativeQuery(sql, Product.class);
query.setParameter("price", 1000);

List<Product> products = query.getResultList();

for (Product product : products) {
    System.out.println(product);
}

session.getTransaction().commit();
session.close();
```

### Benefits of Using NativeQuery

- **Complex Queries**: Allows you to perform complex queries that might be difficult to express using HQL or Criteria.
- **Database-Specific Features**: Enables the use of database-specific features and optimizations.
- **Flexibility**: Provides more flexibility in querying the database.

### When to Use NativeQuery

- When you need to execute complex SQL queries.
- When you need to use database-specific features.
- When HQL or Criteria are not sufficient for your requirements.


### How to Run the Project

1. **Set Up the Database**: Ensure that you have a database set up and configured in your Hibernate configuration file (`hibernate.cfg.xml`).

2. **Compile the Project**: Compile the project using your preferred IDE or build tool (e.g., Maven, Gradle).

3. **Run the Main Class**: Execute the main class that contains the Hibernate session and NativeQuery example.

4. **Check the Output**: Verify the output in the console to see the results of the native SQL query.

### Conclusion

The `NativeQuery` interface is a powerful tool in Hibernate that provides the flexibility to execute native SQL queries. It is particularly useful for complex queries and database-specific features that are not easily handled by HQL or Criteria.

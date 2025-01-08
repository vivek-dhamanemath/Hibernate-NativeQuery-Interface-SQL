package com.Hibernate_SQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class App 
{
	public static void main( String[] args )
	{
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		//SQL:Native Query Interface

		//1.Fetch operation
		NativeQuery<Product> nativeQuery = session.createNativeQuery("SELECT * from Product", Product.class);
		List<Product> products = nativeQuery.list();
		for(Product product: products) {
			System.out.println(product);
		}

		//3. Update operation
		NativeQuery<Product> nativeQuery1 = session.createNativeQuery("UPDATE Product SET productPrice=?1 WHERE productName=?2",Product.class);
		nativeQuery1.setParameter(1, 777);
		nativeQuery1.setParameter(2, "Salt");		
		int rowUpdated = nativeQuery1.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println(rowUpdated + "data updated!!");
		}else {
			System.out.println("data not updated!!");
		}

		//4. Delete operation
		NativeQuery<Product> nativeQuery2 = session.createNativeQuery("DELETE FROM Product WHERE productId=:id",Product.class);
		nativeQuery2.setParameter("id", 3);
		int rowDeleted = nativeQuery2.executeUpdate();
		if(rowDeleted > 0) {
			System.out.println(rowDeleted + " data deletd!!");
		}else {
			System.out.println("data not deleted!!");
	}

		tran.commit();
		session.close();
		sf.close();


	}
}

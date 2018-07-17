package Beans;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HistoryDao {
	public static int register(HistoryBean history)
	{
		int i=0;
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		i=(Integer)session.save(history);
		
		transaction.commit();
		session.close();
		return i;
	}
	
}

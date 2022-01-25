import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//Written by @Ajith Sam
//Generic template for a Hibernate program 

public class App {
	
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration().configure().addAnnotatedClass(classname.class); // Enter your class name
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s1 = sf.openSession();
		
		s1.beginTransaction();
		
		// Logic goes here
		
		s1.getTransaction().commit();
		
		s1.close();
				
	}
	
}

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;


public class App {
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s1 = sf.openSession();
		
		s1.beginTransaction();
		
		SQLQuery q1 = s1.createSQLQuery("SELECT name, marks from Student WHERE marks > 60");
		
		q1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
		List stud = q1.list();
		
		for(Object s: stud)
		{
			Map m = (Map) s;
			System.out.println(m.get("name") + " : " + m.get("marks"));
		}
		
		s1.getTransaction().commit();
		
		s1.close();
				
	}
}

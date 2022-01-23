package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {    	
    	Alien sam = new Alien();       
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session1 = sf.openSession();
        
        Session session2 = sf.openSession();

        session1.beginTransaction();   
        
        sam = (Alien) session1.get(Alien.class, 102);
        
        System.out.println(sam);  
        
        session1.getTransaction().commit();
        
        session1.close();
        
        session2.beginTransaction();
        
        sam = (Alien) session2.get(Alien.class, 102);

       // session.save(sam);
        
        System.out.println(sam);
        
        session2.getTransaction().commit();
        
        session2.close();
               
        
    }
}
